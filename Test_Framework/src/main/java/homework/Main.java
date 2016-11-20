package homework;

import homework.commands.*;
import homework.parsers.*;

import java.util.ArrayList;

/**
 * Class has entry point to the application
 */
public class Main {

    /**
     * Line with file name
     */
    private static final String LOG_FILE_NAME = "Log.txt";

    /**
     * Method has entry point to the program
     */
    public static void main(String[] args) {
        try {
            validateArguments(args);
            Logger logger = new Logger();
            WriterLogFile writerLog = new WriterLogFile();
            ArrayList<CommandDataKeeper> keepers = buildParser(args).parse();
            ArrayList<Command> commands = buildCommands(keepers);
            new CommandPerformer().performCommands(commands, logger);
            writerLog.writeLog(System.getProperty("user.dir") + "\\" + LOG_FILE_NAME, logger.getLog());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method gets list of command data keepers and returns list of commands, depending on names of
     * commands in command data keeper
     *
     * @param keepers list of command data keepers
     * @return list of objects of commands
     */
    private static ArrayList<Command> buildCommands(ArrayList<CommandDataKeeper> keepers) {
        ArrayList<Command> commands = new ArrayList<>();
        CommandFactory factory = new CommandFactory();
        for (CommandDataKeeper keeper : keepers) {
            try {
                Command command = factory.createCommand(keeper.getName());
                command.setAttributes(keeper.getAttributes());
                commands.add(command);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return commands;
    }

    /**
     * Method gets parameters from command line and depending on first argument return object of parser
     *
     * @param args arguments from the command line
     * @return object of parser
     */
    private static ParserFile buildParser(String[] args) throws Exception {
        ParserFile parserFile;
        ParserFileFactory fileFactory = new ParserFileFactory();
        parserFile = fileFactory.createParser(args);
        return parserFile;
    }

    private static void validateArguments(String[] args) throws Exception {
        if (args == null) {
            throw new Exception("Arguments are not initialized");
        }
        if (args.length == 0 || args[0] == null) {
            throw new Exception("Wrong input arguments");
        }
    }
}
