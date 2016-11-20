package homework.parsers;

import homework.commands.*;

import java.util.ArrayList;

/**
 * Class parses data, got from command line as parameters
 */
public class CommandLineParser extends ParserFile {

    /**
     * Arguments to parse
     */
    String[] args;

    /**
     * Constructor of class
     *
     * @param args arguments to parse
     */
    protected CommandLineParser(String[] args) {
        this.args = args;
    }

    /**
     * Method parses data and returns list
     * of objects of CommandDataKeeper
     *
     * @return list of object with parsed data
     */
    public ArrayList<CommandDataKeeper> parse() throws Exception {
        String line = new String();
        for (int i = 0; i < args.length; i++) {
            line += args[i] + " ";
        }
        ArrayList<String> result = new ArrayList<>();
        // Splits to separate line of commands
        String[] cur = line.split("--");
        for (int i = 0; i < cur.length; i++) {
            if (!cur[i].equals(""))
                result.add(cur[i]);
        }
        ArrayList<CommandDataKeeper> keepers = new ArrayList<>();
        // Parses for each line with commands
        for (String data : result) {
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
            // Adds another command data keeper
            keepers.add(new CommandDataKeeper(name, attributes));
        }
        return keepers;
    }
}
