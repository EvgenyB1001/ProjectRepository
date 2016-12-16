package tests;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Class provides actions to get data from XML file (like data provider)
 */
public class ProviderData {

    /**
     * Instance of class
     */
    private static ProviderData instance;

    /**
     * Singleton implementation
     */
    public static ProviderData getInstance() {
        if (instance == null) {
            instance = new ProviderData();
        }
        return instance;
    }

    /**
     * Method gets file name, attributes of file, reads data from XML file and returns array of data
     *
     * @param fileName   name of file
     * @param type       type of data from XML
     * @param attributes attributes of line
     * @return array of objects of data from XML
     */
    public Object[][] readUserDataXml(String fileName, String type, String[] attributes) throws Exception {
        File inputFile = new File(System.getProperty("user.dir") + fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);
        NodeList list = document.getElementsByTagName(type);
        Object[][] result = new String[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new String[]{
                    map.getNamedItem(attributes[0]) == null ? null : map.getNamedItem(attributes[0]).getNodeValue(),
                    map.getNamedItem(attributes[1]) == null ? null : map.getNamedItem(attributes[1]).getNodeValue()
            };
        }
        return result;
    }
}