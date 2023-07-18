package m.p;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String targetId = "42007";

        // Parsing the xml
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse("src/m/p/sma_gentext.xml");

        // Extracting the target-tags as Nodes
        NodeList nodeList = doc.getDocumentElement().getElementsByTagName("target");

        // Iterating over the Nodes
        for (int i = 0; i < nodeList.getLength(); i++) {

            // Finding the specific Node
            if (nodeList.item(i).getParentNode().getAttributes().getNamedItem("id").getNodeValue().equals(targetId)) {

                // Writing to file
                FileWriter fw = new FileWriter(targetId);
                fw.write(nodeList.item(i).getTextContent());
                fw.close();

                // Breaking the loop when done
                break;
            }
        }
    }
}
