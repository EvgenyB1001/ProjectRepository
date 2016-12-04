package homework.commands;

/**
 * Class contains data of input command
 */
public class CommandDataKeeper {

    /**
     * Name of current command
     */
    private String name;

    /**
     * Attributes of current command
     */
    private String[] attributes;

    /**
     * Constructor of command data keeper
     *
     * @param name       name of command
     * @param attributes attributes of command
     */
    public CommandDataKeeper(String name, String[] attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    /**
     * Method returns name of current command
     *
     * @return name of command
     */
    public String getName() {
        return name;
    }

    /**
     * Method returns attributes of command
     *
     * @return attributes of command
     */
    public String[] getAttributes() {
        return attributes;
    }
}
