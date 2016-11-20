package homework.parsers;

import homework.commands.CommandDataKeeper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class parses JSON file
 */
public class ParserJSON extends ParserFile {

    /**
     * Names of attributes in JSON file
     */
    private final String NAME = "name";
    private final String COMMAND = "command";
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
    protected ParserJSON(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Method parser definite file and returns list of command data keepers
     *
     * @return list of data keepers
     */
    public ArrayList<CommandDataKeeper> parse() throws Exception {
        ArrayList<CommandDataKeeper> keepers = new ArrayList<>();
        FileReader reader = new FileReader(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray array = (JSONArray) jsonObject.get(COMMAND);
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            String name = (String) obj.get(NAME);
            String[] arguments = {((String) obj.get(ATTRIBUTE_1)),
                    (obj.get(ATTRIBUTE_2) == null ? "" : (String) obj.get(ATTRIBUTE_2))};
            keepers.add(new CommandDataKeeper(name, arguments));
        }
        return keepers;
    }
}
