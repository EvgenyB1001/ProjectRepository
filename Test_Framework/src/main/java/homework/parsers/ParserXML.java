package homework.parsers;

import homework.commands.CommandDataKeeper;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Class parses data, got as parameter, and returns object of command.
 */
public class ParserXML extends ParserFile {

    /**
     * Names of attributes in XML file
     */
    private final String COMMAND = "command";
    private final String NAME = "name";
    private final String ATTRIBUTE_1 = "attribute1";
    private final String ATTRIBUTE_2 = "attribute2";

    /**
     * Path to file to parse
     */
    private String filePath = new String();

    /**
     * Constructor of class.
     *
     * @param filePath path to file
     */
    protected ParserXML(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Method parser definite file and returns list of command data keepers
     *
     * @return list of data keepers
     */
    public ArrayList<CommandDataKeeper> parse() throws Exception {
        File inputFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);
        NodeList list = document.getElementsByTagName(COMMAND);
        ArrayList<CommandDataKeeper> result = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            String name = map.getNamedItem(NAME).getNodeValue();
            String[] attributes = {map.getNamedItem(ATTRIBUTE_1).getNodeValue(), (map.getNamedItem(ATTRIBUTE_2) == null ?
                    "" : map.getNamedItem(ATTRIBUTE_2).getNodeValue())};
            result.add(new CommandDataKeeper(name, attributes));
        }
        return result;
    }
}
