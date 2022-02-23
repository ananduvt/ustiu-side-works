/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptionupdate;

import POJO.DataChange;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author u55369
 */
public class SubscriptionUpdate {

    /**
     * @param args the command line arguments
     */
    static ArrayList<DataChange> inputChangeDataList;
    static Document doc;

    public static void main(String[] args) {
        // TODO code application logic here

        //File inputData = new File(args[0]);
        File inputData = new File("InputDataProd.csv");
        File logFile = new File("Log.csv");

        inputChangeDataList = processInputdata(inputData.getPath());
        ArrayList<ArrayList<String>> logList = new ArrayList<>();

        //File inputFolder = new File(args[1]);
        File inputFolder = new File("inputProd");
        for (File inputFile : inputFolder.listFiles()) {

            System.out.println("Processing File : " + inputFile.getName());

            logList.add(UpdateSubscription(inputFile, "outputProd"));

            System.out.println("\n*************************************************************************\n");
        }
        if (logFile.exists()) {
            logFile.delete();
        }
        logList.get(0).add(0, "Input FileName,Old SubId,New SubId,Old Account,New Account,Old MembId,End Dates,Member Status,New MembId,old IdNum, New IdNum");

        for (ArrayList list : logList) {
            try {
                FileUtils.writeLines(logFile, list, true);
            } catch (IOException ex) {
                Logger.getLogger(SubscriptionUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Log write Success");
    }

    private static ArrayList<String> UpdateSubscription(File inputFile, String outputFolder) {

        ArrayList<String> log = new ArrayList<>();

        ArrayList<String> subsLog = new ArrayList() {
            @Override
            public String toString() {

                String csv = "";
                for (Object s : this) {
                    csv = csv + "\"" + s + "\"" + ",";
                }
                return csv;
            }
        };
        subsLog.add(inputFile.getName());

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(inputFile);

            //subscription edit
            Node subscription = doc.getElementsByTagName("subscription").item(0);
            NodeList nodeListSubs = subscription.getChildNodes();
            DataChange dataChange = null;

            for (int subChildCount = 0; subChildCount < nodeListSubs.getLength(); subChildCount++) {
                //subscription child nodes
                Node nodeSubsChild = nodeListSubs.item(subChildCount);
                //hccIdentifier change
                if (nodeSubsChild.getNodeName().equals("hccIdentifier")) {
                    dataChange = getDataChange(nodeSubsChild.getTextContent());
                    if (dataChange == null) {
                        System.exit(0);
                    }
                    System.out.println("Editing Subscription");
                    //sets value 
                    System.out.println("\tChanging  hccIdentifier " + nodeSubsChild.getTextContent() + " to " + dataChange.getNewSubscriptionId());
                    subsLog.add(nodeSubsChild.getTextContent());
                    nodeSubsChild.setTextContent(dataChange.getNewSubscriptionId());
                    subsLog.add(dataChange.getNewSubscriptionId());
                }

                //identifiedAccount change
                if (nodeSubsChild.getNodeName().equals("identifiedAccount")) {
                    NodeList nodeIdAcc = nodeSubsChild.getChildNodes();
                    for (int i = 0; i < nodeIdAcc.getLength(); i++) {
                        Node nodeIdAccChild = nodeIdAcc.item(i);
                        if (nodeIdAccChild.getNodeName().equals("ID")) {
                            System.out.println("\tChanging identifiedAccount : " + nodeIdAccChild.getTextContent() + " to " + dataChange.getIdentifiedAccount());

                            subsLog.add(nodeIdAccChild.getTextContent());
                            nodeIdAccChild.setTextContent(dataChange.getIdentifiedAccount());

                            subsLog.add(dataChange.getIdentifiedAccount());
                        }
                    }
                }
            }

            log.add(subsLog.toString());
            subsLog.clear();

            System.out.println("Editing Members");
            //member edit 
            Node members = doc.getElementsByTagName("members").item(0);
            Element membersElement = (Element) members;
            NodeList memberContainers = membersElement.getElementsByTagName("MemberContainer");
            ArrayList<Node> nodeRemoveList = new ArrayList<>();
            // opening member container 
            for (int memberContCount = 0; memberContCount < memberContainers.getLength(); memberContCount++) {
                Node memberContainer = memberContainers.item(memberContCount);
                Element memContElem = (Element) memberContainer;

                Node lmember = memContElem.getElementsByTagName("member").item(0);
                Element lmemberElement = (Element) lmember;
                Node lmemHccId = lmemberElement.getElementsByTagName("hccIdentifier").item(0);
                System.out.println("\tMember Id : " + lmemHccId.getTextContent());

                String oldMemId = lmemHccId.getTextContent();
                String newMemId = "";
                String endDates = "";
                String memStatus = "";
                String oldIdNum = "";
                String newIdNum = "";

                // prcessing Selections
                Element selections = (Element) memContElem.getElementsByTagName("selections").item(0);
                Element planSelections = (Element) selections.getElementsByTagName("planSelections").item(0);

                if (planSelections == null) {
                    System.out.println("\t No plan selection - removing member");
                    nodeRemoveList.add(memberContainer);
                    memStatus = "No plan selection";
                } else {
                    NodeList memberPlanSelectionList = planSelections.getElementsByTagName("MemberPlanSelection");
                    ArrayList<String> endDateList = new ArrayList<>();
                    // each member plan selection 
                    for (int memPlanSeleCount = 0; memPlanSeleCount < memberPlanSelectionList.getLength(); memPlanSeleCount++) {

                        Element memberPlanSelection = (Element) memberPlanSelectionList.item(memPlanSeleCount);

                        Element dateRanges = (Element) memberPlanSelection.getElementsByTagName("dateRanges").item(0);
                        NodeList memberPlanSelectionDateRangeList = dateRanges.getElementsByTagName("MemberPlanSelectionDateRange");
                        // each MemberPlanSelectionDateRange
                        for (int memberPlanSelectionDateRangeCount = 0; memberPlanSelectionDateRangeCount < memberPlanSelectionDateRangeList.getLength(); memberPlanSelectionDateRangeCount++) {

                            Element memberPlanSelectionDateRange = (Element) memberPlanSelectionDateRangeList.item(memberPlanSelectionDateRangeCount);
                            Node endDate = memberPlanSelectionDateRange.getElementsByTagName("endDate").item(0);
                            endDateList.add(endDate.getTextContent());
                        }
                    }
                    endDates = endDateList.toString();

                    //removing plan selections
                    while (planSelections.hasChildNodes()) {

                        planSelections.removeChild(planSelections.getFirstChild());
                    }

                    System.out.println("\tEndDates : " + endDateList);

                    if (dateCheck(endDateList, dataChange.getStartDate())) {//enddate>2018-05-01

                        memStatus = "Active Member";

                        System.out.println("\tActive Member - Updating other member details");
                        // member hcc id 
                        Node member = memContElem.getElementsByTagName("member").item(0);
                        Element memberElement = (Element) member;
                        Node memHccId = memberElement.getElementsByTagName("hccIdentifier").item(0);

                        System.out.println("\t\tChanging member-hccIdentifier : " + memHccId.getTextContent() + " to " + dataChange.getNewSubscriptionId() + memHccId.getTextContent().substring(memHccId.getTextContent().length() - 2));
                        memHccId.setTextContent(dataChange.getNewSubscriptionId() + memHccId.getTextContent().substring(memHccId.getTextContent().length() - 2));

                        newMemId = memHccId.getTextContent();

                        // member otherIdNumberList  
                        Node otherIdNumberList = memberElement.getElementsByTagName("otherIdNumberList").item(0);
                        Element otherIdNumListElem = (Element) otherIdNumberList;

                        NodeList identificationNumberList = otherIdNumListElem.getElementsByTagName("IdentificationNumber");
                        for (int idNumCount = 0; idNumCount < identificationNumberList.getLength(); idNumCount++) {
                            Node identificationNumber = identificationNumberList.item(idNumCount);
                            Element idNumElem = (Element) identificationNumber;

                            Node identificationType = idNumElem.getElementsByTagName("identificationType").item(0);
                            Element idTypeElem = (Element) identificationType;
                            Node id1 = idTypeElem.getElementsByTagName("ID").item(0);
                            Node id2 = idTypeElem.getElementsByTagName("ID").item(1);

                            //identificationNumber 
                            if (id1.getTextContent().equalsIgnoreCase("Health Care Company") && id2.getTextContent().equalsIgnoreCase("IdentificationType")) {

                                Node idNum = idNumElem.getElementsByTagName("identificationNumber").item(0);
                                System.out.println("\t\tChanging identificationNumber " + idNum.getTextContent() + " to " + dataChange.getNewSubscriptionId() + idNum.getTextContent().substring(idNum.getTextContent().length() - 2));

                                oldIdNum = idNum.getTextContent();
                                idNum.setTextContent(dataChange.getNewSubscriptionId() + idNum.getTextContent().substring(idNum.getTextContent().length() - 2));

                                newIdNum = idNum.getTextContent();
                            }
                        }

                        // adding benefit plan selection node 
                        planSelections.appendChild(createBPSNode(dataChange));
                        System.out.println("\t\tAdding member Plan Selection : " + dataChange.getEnrolledPlan() + " with " + dataChange.getStartDate());

                    } else {
                        //delete memberContainer node 
                        memStatus = "Member Not Active";
                        System.out.println("\tMember not Active - removing the member");
                        nodeRemoveList.add(memberContainer);
                    }
                }

                subsLog.add("");
                subsLog.add("");
                subsLog.add("");
                subsLog.add("");
                subsLog.add("");
                subsLog.add(oldMemId);
                subsLog.add(endDates);
                subsLog.add(memStatus);
                subsLog.add(newMemId);
                subsLog.add(oldIdNum);
                subsLog.add(newIdNum);

                log.add(subsLog.toString());
                subsLog.clear();

            }
            // removal of member Nodes 

            for (Node node : nodeRemoveList) {
                members.removeChild(node);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(outputFolder + "/" + inputFile.getName()));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            Logger.getLogger(SubscriptionUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }

    private static boolean dateCheck(ArrayList<String> dateList, String checkDate) {
        boolean eligible = false;
        try {
            Date refDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkDate);

            for (String s : dateList) {
                Date compDate = new SimpleDateFormat("yyyy-MM-dd").parse(s);
                if (compDate.after(refDate)) {
                    eligible = true;
                }
            }
        } catch (ParseException ex) {
            System.err.println("Date format error");
        }
        return eligible;
    }

    private static Node createBPSNode(DataChange dataChange) {
        Node mps = doc.createElement("MemberPlanSelection");
        {
            Node dr = doc.createElement("dateRanges");
            {
                Node mpsdr = doc.createElement("MemberPlanSelectionDateRange");
                {
                    Node sd = doc.createElement("startDate");
                    sd.setTextContent(dataChange.getStartDate());
                    Node ed = doc.createElement("endDate");
                    ed.setTextContent("3000-01-01");
                    Node stat = doc.createElement("status");
                    stat.setTextContent("A");
                    mpsdr.appendChild(sd);
                    mpsdr.appendChild(ed);
                    mpsdr.appendChild(stat);
                }
                dr.appendChild(mpsdr);
            }
            mps.appendChild(dr);
            Node ep = doc.createElement("enrolledPlan");
            {
                Element id = doc.createElement("ID");
                id.setTextContent(dataChange.getEnrolledPlan());
                id.setAttribute("xsi:type", "xsd:string");
                //add attribute 
                ep.appendChild(id);
            }
            mps.appendChild(ep);
        }
        return mps;
    }

    private static DataChange getDataChange(String subId) {
        for (DataChange dataChange : inputChangeDataList) {
            if (dataChange.getExistingSubscriptionId().equals(subId)) {
                System.out.println("Found InputData for  : " + subId + " = " + dataChange);
                return dataChange;
            }
        }
        System.err.println(subId + " not found in input data");
        return null;
    }

    private static ArrayList<DataChange> processInputdata(String inputData) {
        ArrayList<DataChange> changeDataList = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(inputData));
            changeDataList = new ArrayList<>();

            List<String[]> csvData = csvReader.readAll();

            for (String[] line : csvData) {
                DataChange dataChange = new DataChange();
                dataChange.setExistingSubscriptionId(line[0]);
                dataChange.setNewSubscriptionId(line[1]);
                dataChange.setIdentifiedAccount(line[2]);
                dataChange.setStartDate(line[3]);
                dataChange.setEnrolledPlan(line[4]);

                changeDataList.add(dataChange);
            }

//            for(DataChange dataChange : changeDataList)
//            {
//                System.out.println(dataChange);
//            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SubscriptionUpdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SubscriptionUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }

        return changeDataList;
    }
}
