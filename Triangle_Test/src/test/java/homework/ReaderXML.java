package homework;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;

/**
 * Class reads data from XML file
 */
public class ReaderXML {

    /**
     * Method gets file path, names of item and attributes, reads definite XML-file and returns array of data
     *
     * @param filePath        path to file
     * @param item            name of item
     * @param attributesNames names of attributes
     * @return result array of data
     */
    public Object[][] read(String filePath, String item, String[] attributesNames) throws Exception {
        File inputFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList list = document.getElementsByTagName(item);
        Object[][] result = new BigDecimal[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new BigDecimal[]{
                    map.getNamedItem(attributesNames[0]) == null ?
                            null : new BigDecimal(map.getNamedItem(attributesNames[0]).getNodeValue()),
                    map.getNamedItem(attributesNames[1]) == null ?
                            null : new BigDecimal(map.getNamedItem(attributesNames[1]).getNodeValue()),
                    map.getNamedItem(attributesNames[2]) == null ?
                            null : new BigDecimal(map.getNamedItem(attributesNames[2]).getNodeValue())
            };
        }
        return result;
    }
}