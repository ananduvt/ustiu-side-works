/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author u55369
 */
public class XMLParse {

    public static void main(String[] args) {
        try {
            File inputFile = new File("sminu.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            Node root = doc.getDocumentElement();
            //System.out.println("Root element :" + root.getNodeName());
            listChilds(root, "");
        } catch (SAXException ex) {
            Logger.getLogger(XMLParse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLParse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLParse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void listChilds(Node root, String parent) {

        NodeList nodeList = root.getChildNodes();
        parent += root.getNodeName() + "\\";

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node child = nodeList.item(i);
            if (child.getNodeType() == 3 || child.getNodeType() == 8) {
                // ignoring comment nodes and #text nodes
                continue;
            }
            System.out.println(parent + "" + child.getNodeName());

            listChilds(child, parent);
        }
    }

}
