package homework.parsers;

import homework.commands.CommandDataKeeper;

import java.util.ArrayList;

/**
 * Base class to file parsers
 */
public abstract class ParserFile {

    /**
     * Method parses file by input file path and returns list of command data keepers
     *
     * @return list of command data keepers
     */
    public abstract ArrayList<CommandDataKeeper> parse() throws Exception;
}
