package com.coherantsolutions.store.helpers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XmlParser {

    private final String PATH = "store/src/main/resources/config.xml";

    public Map<String, String> xmlParser() throws ParserConfigurationException {
        String sortTag = "sort";
        Map<String, String> configMap = new LinkedHashMap<>();

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        try {
            FileInputStream file = new FileInputStream(PATH);
            Document doc = documentBuilder.parse(file);

            Node node = doc.getElementsByTagName(sortTag).item(0);
            NodeList nodeList = node.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {

                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nodeList.item(i);
                    String sortField = eElement.getTagName();
                    String sortBy = eElement.getTextContent();
                    configMap.put(sortField, sortBy);
                }
            }

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return configMap;
    }
}
