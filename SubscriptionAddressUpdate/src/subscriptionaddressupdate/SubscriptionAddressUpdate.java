/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptionaddressupdate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author u55369
 */
public class SubscriptionAddressUpdate {

    static Document doc = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        subsAddressUpdate();
    }

    private static void subsAddressUpdate() {
        File inputFolder = new File("inputProd");
        File outputFolder = new File("outputProd");

        for (File file : inputFolder.listFiles()) {

            addressUpdate(file, outputFolder);
        }
    }

    private static void addressUpdate(File inputFile, File outputFolder) {

        System.out.println("Processing File : " + inputFile.getName());

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(inputFile);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(SubscriptionAddressUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }

        Node subscription = doc.getElementsByTagName("members").item(0);
        Element subscriptionElement = (Element) subscription;

        NodeList memberContainerList = subscriptionElement.getElementsByTagName("MemberContainer");
        for (int memContCount = 0; memContCount < memberContainerList.getLength(); memContCount++) {
            Element memberContainerElem = (Element) memberContainerList.item(memContCount);
            Element memberElement = (Element) memberContainerElem.getElementsByTagName("member").item(0);

            //Physical Address Handling
            Element physicalAddressElement = (Element) memberElement.getElementsByTagName("physicalAddress").item(0);

            //Checking for multiple member physical Address
            NodeList memberPhysicalAddressElementList = physicalAddressElement.getElementsByTagName("MemberPhysicalAddress");
            if (memberPhysicalAddressElementList.getLength() > 1) {
                System.out.println("More than 1 Member Physical Address");
                System.exit(0);
            } else {

                Element memberPhysicalAddressElement = (Element) physicalAddressElement.getElementsByTagName("MemberPhysicalAddress").item(0);
                Element addressTypeElement = (Element) memberPhysicalAddressElement.getElementsByTagName("addressType").item(0);

                Node id1 = addressTypeElement.getElementsByTagName("ID").item(0);
                Node id2 = addressTypeElement.getElementsByTagName("ID").item(1);

                if (id1.getTextContent().equals("Residential")) {
                    Element addressInfoElement = (Element) memberPhysicalAddressElement.getElementsByTagName("addressInfo").item(0);
                    Element postalAddressElement = (Element) addressInfoElement.getElementsByTagName("postalAddress").item(0);
                    Element addressPhoneList = (Element) addressInfoElement.getElementsByTagName("addressPhoneList").item(0);
                    // removing existing postal address and adding the template address
                    addressInfoElement.removeChild(postalAddressElement);
                    addressInfoElement.insertBefore(addressGen(), addressPhoneList);

                } else {
                    System.out.println("Residential Address not found");
                    System.exit(0);
                }
            }

            //correspondence Address handling 
            Element correspondenceAddressElement = (Element) memberElement.getElementsByTagName("correspondenceAddress").item(0);
            Element postalAddressElement = (Element) correspondenceAddressElement.getElementsByTagName("postalAddress").item(0);
            
            correspondenceAddressElement.removeChild(postalAddressElement);
            correspondenceAddressElement.appendChild(addressGen());
        }

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(outputFolder.getName() + "/" + "AddressUpdated." + inputFile.getName()));
            transformer.transform(source, result);
        } catch (IllegalArgumentException | TransformerException e) {
            System.out.println(e);
        }

    }

    private static Node addressGen() {

        Node postalAddress = doc.createElement("postalAddress");

        Node address = doc.createElement("address");
        address.setTextContent("714 N. Senate Ave.");

        Node address2 = doc.createElement("address2");
        address2.setTextContent("Ste. 200");

        Node stateCode = doc.createElement("stateCode");
        stateCode.setTextContent("IN");

        Node zipCode = doc.createElement("zipCode");
        zipCode.setTextContent("46202");

        Node cityName = doc.createElement("cityName");
        cityName.setTextContent("Indianapolis");

        Node countyCode = doc.createElement("countyCode");
        countyCode.setTextContent("US");

        Node countryCode = doc.createElement("countryCode");
        countryCode.setTextContent("US");

        Node longitude = doc.createElement("longitude");
        longitude.setTextContent("-86.163580");

        Node latitude = doc.createElement("latitude");
        latitude.setTextContent("39.777330");

        Node ignoreAddressCheck = doc.createElement("ignoreAddressCheck");
        ignoreAddressCheck.setTextContent("true");

        Node undeliverableAddress = doc.createElement("undeliverableAddress");
        undeliverableAddress.setTextContent("false");

        postalAddress.appendChild(address);
        postalAddress.appendChild(address2);
        postalAddress.appendChild(stateCode);
        postalAddress.appendChild(zipCode);
        postalAddress.appendChild(cityName);
        postalAddress.appendChild(countyCode);
        postalAddress.appendChild(countryCode);
        postalAddress.appendChild(longitude);
        postalAddress.appendChild(latitude);
        postalAddress.appendChild(ignoreAddressCheck);
        postalAddress.appendChild(undeliverableAddress);

        return postalAddress;
    }

    private static void renameFile(File inputFile) {
        List cont;
        try {
            cont = Files.readAllLines(inputFile.toPath());
            String newName = cont.get(6).toString().replaceAll("<hccIdentifier>", "").replaceAll("</hccIdentifier>", "").replaceAll(" ", "");
            String oldName = inputFile.getName().split("\\.")[1];
            inputFile.renameTo(new File("inputProd/" + inputFile.getName().replaceAll(oldName, newName)));

            System.out.println(oldName + " ~ " + newName);
        } catch (IOException ex) {
            Logger.getLogger(SubscriptionAddressUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private static void nodeManp() {
        Document doc = null;
        File inputFile = new File("samp\\SubscriptionContainer.EA0000552.2018-01-01.a.xml");
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(inputFile);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(SubscriptionAddressUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }

        Node subscription = doc.getElementsByTagName("subscription").item(0);
        Element subscriptionElement = (Element) subscription;

    }
}
