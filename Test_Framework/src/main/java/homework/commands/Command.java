package homework.commands;

import org.openqa.selenium.WebDriver;

/**
 * Base class to all commands, that supported by framework
 */
public abstract class Command {

    /**
     * Method performs command
     *
     * @param driver object of WebDriver
     */
    public abstract void performCommand(WebDriver driver) throws Exception;

    /**
     * Method set execution time of operation
     *
     * @param time time of operation
     */
    public abstract void setExecutionTime(long time);

    /**
     * Method sets attributes to command
     *
     * @param attributes attributes of command
     */
    public abstract void setAttributes(String[] attributes) throws Exception;

    /**
     * Method returns line of command
     *
     * @return line of command
     */
    public abstract String getCommandName();

    /**
     * Method returns status of command
     *
     * @return boolean value: true - command passed
     */
    public abstract boolean getCommandStatus();

    /**
     * Method returns line of attributes of command
     *
     * @return line of attributes of command
     */
    public abstract String getCommandAttributesToString();

    /**
     * Method returns execution time of command
     *
     * @return execution time of command in ms
     */
    public abstract long getExecutionTime();
}
