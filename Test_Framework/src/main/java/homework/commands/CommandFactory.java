package homework.commands;

import java.util.ArrayList;

/**
 * Class creates object of commands depending on name of command
 */
public class CommandFactory {

    private ArrayList<Command> commands = new ArrayList<>();

    public CommandFactory() {
        commands.add(new CommandOpen());
        commands.add(new CommandCheckPageContains());
        commands.add(new CommandCheckLinkPresentByHref());
        commands.add(new CommandCheckLinkPresentByName());
        commands.add(new CommandCheckPageTitle());
    }

    /**
     * Method creates object of command depending on name, got as parameter
     *
     * @param name name of command
     * @return object of command
     */
    public Command createCommand(String name) throws Exception {
        if (name == null) {
            throw new Exception("Name isn't initialized");
        }
        for (Command command : commands) {
            if (name.equals(command.getCommandName())) {
                return command;
            }
        }
        throw new Exception("No such command");
    }
}
