package com.example.demo;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XMLParser {

    public XMLParser(String inputFilePath, String outputFilePath, XMLParams xmlParams) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File inputFile = new File(inputFilePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);

        // change params

        Node node = doc.getElementsByTagName("СвСчФакт").item(0);
        NamedNodeMap namedNodeMap = node.getAttributes();
        Node n = namedNodeMap.getNamedItem("ДатаСчФ");
        n.setNodeValue(xmlParams.dscf);
        n = namedNodeMap.getNamedItem("НомерСчФ");
        n.setNodeValue(xmlParams.nscf);

        node = doc.getElementsByTagName("СвПРД").item(0);
        namedNodeMap = node.getAttributes();
        n = namedNodeMap.getNamedItem("ДатаПРД");
        n.setNodeValue(xmlParams.dprd);
        n = namedNodeMap.getNamedItem("НомерПРД");
        n.setNodeValue(xmlParams.nprd);

        node = doc.getElementsByTagName("ТекстИнф").item(0);
        namedNodeMap = node.getAttributes();
        n = namedNodeMap.getNamedItem("Идентиф");
        n.setNodeValue(xmlParams.identif);
        n = namedNodeMap.getNamedItem("Значен");
        n.setNodeValue(xmlParams.znacen);

        node = doc.getElementsByTagName("СведТов").item(0);
        namedNodeMap = node.getAttributes();
        n = namedNodeMap.getNamedItem("НаимТов");
        n.setNodeValue(xmlParams.naimTov);
        n = namedNodeMap.getNamedItem("НалСт");
        n.setNodeValue(xmlParams.nalSt);
        n = namedNodeMap.getNamedItem("СтТовУчНал");
        n.setNodeValue(xmlParams.stTovYcNal);

        node = doc.getElementsByTagName("ВсегоОпл").item(0);
        namedNodeMap = node.getAttributes();
        n = namedNodeMap.getNamedItem("СтТовУчНалВсего");
        n.setNodeValue(xmlParams.stTovYcNal);

        NodeList nodeList = doc.getElementsByTagName("СумНал");
        for (int i=0;i<nodeList.getLength();i++) {
            Node node1 = nodeList.item(i);

            System.out.println(node1.getParentNode().getNodeName());
            if (node1.getParentNode().getNodeName().equals("СумНал") || node1.getParentNode().getNodeName().equals("СумНалВсего")) {
                node1.setTextContent(xmlParams.sumNal);
            }
        }

        node = doc.getElementsByTagName("СвЮЛУч").item(0);
        namedNodeMap = node.getAttributes();
        n = namedNodeMap.getNamedItem("КПП");
        n.setNodeValue(xmlParams.kpp);

        // create the xml file
        //transform the DOM Object to an XML File
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(outputFilePath));
        transformer.transform(domSource, streamResult);
        System.out.println("Done creating XML File");
    }

}
