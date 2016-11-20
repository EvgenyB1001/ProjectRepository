package homework.parsers;

import homework.commands.CommandDataKeeper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class parses data got from txt file and returns set of command data keepers
 */
public class ParserTXT extends ParserFile {

    /**
     * Path to file to parse
     */
    private String filePath = new String();

    /**
     * Constructor of class.
     *
     * @param filePath path to file
     */
    protected ParserTXT(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Method parser definite file and returns list of command data keepers
     *
     * @return list of data keepers
     */
    public ArrayList<CommandDataKeeper> parse() throws Exception {
        ArrayList<String> commands = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(filePath));
        while (scanner.hasNext()) {
            commands.add(scanner.nextLine());
        }
        ArrayList<CommandDataKeeper> keepers = new ArrayList<>();
        for (String data : commands) {
            String name = data.substring(0, data.indexOf(" "));
            String attribute = data.substring(data.indexOf(" ") + 1);
            String[] current = attribute.split("\"");
            ArrayList<String> curAttributes = new ArrayList<>();
            for (int i = 0; i < current.length; i++) {
                if (!(current[i].equals(" ")) && !(current[i].equals(""))) {
                    curAttributes.add(current[i]);
                }
            }
            String[] attributes = new String[curAttributes.size()];
            for (int i = 0; i < curAttributes.size(); i++) {
                attributes[i] = curAttributes.get(i);
            }
            keepers.add(new CommandDataKeeper(name, attributes));
        }
        return keepers;
    }
}
