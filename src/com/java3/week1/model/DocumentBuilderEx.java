package com.java3.week1.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DocumentBuilderEx {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            try {
                Document doc = builder.parse("src/com/java3/week1/model/people.xml");
                NodeList personList = doc.getElementsByTagName("person");
                for (int i = 0; i< personList.getLength(); i++){
                    Node p = personList.item(i);
                    if (p.getNodeType()==Node.ELEMENT_NODE){
                        Element person = (Element) p;
                        String id = person.getAttribute("id");
                        NodeList nameList = person.getChildNodes();
                        for (int j = 0; j< nameList.getLength();j++){
                            Node n = nameList.item(j);
                            if (n.getNodeType()==Node.ELEMENT_NODE){
                                Element name = (Element) n;
                                System.out.println("Person "+ id + ":" + name.getTagName() +
                                        "=" + name.getTextContent());
                            }
                        }
                    }
                }

            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
