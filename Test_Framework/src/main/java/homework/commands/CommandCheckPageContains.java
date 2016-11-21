package homework.commands;

import org.openqa.selenium.WebDriver;

/**
 * Class performs command checkPageContains
 */
public class CommandCheckPageContains extends Command {

    /**
     * Line with command name
     */
    private final String COMMAND_NAME = "checkPageContains";

    /**
     * Attribute of current command
     */
    private String attribute = new String();

    /**
     * Status of command. True - command passed
     */
    private boolean isPassed = false;

    /**
     * Execution time
     */
    private long executionTime = 0;

    /**
     * Constructor of class
     */
    protected CommandCheckPageContains() {
    }

    /**
     * Method set attributes to current command
     *
     * @param attribute attribute of command
     */
    public void setAttributes(String[] attribute) throws Exception {
        if (attribute == null) {
            throw new Exception("Attributes are not initialized");
        }
        if (attribute.length == 0) {
            throw new Exception("Invalid attributes count");
        }
        this.attribute = attribute[0];
    }

    /**
     * Method returns command name
     *
     * @return name of command
     */
    public String getCommandName() {
        return COMMAND_NAME;
    }

    /**
     * Method returns line of attributes of command
     *
     * @return line of attributes of command
     */
    public String getCommandAttributesToString() {
        return "\"" + attribute + "\"";
    }

    /**
     * Method returns status of command
     *
     * @return boolean value: true - command passed
     */
    public boolean getCommandStatus() {
        return isPassed;
    }

    /**
     * Method performs current command
     *
     * @param driver object of WebDriver
     */
    public void performCommand(WebDriver driver) {
        try {
            isPassed = driver.getPageSource().contains(attribute);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            isPassed = false;
        }
    }

    /**
     * Method set execution time of operation
     *
     * @param time time of operation
     */
    public void setExecutionTime(long time) {
        this.executionTime = time;
    }

    /**
     * Method returns execution time of command
     *
     * @return execution time of command in ms
     */
    public long getExecutionTime() {
        return executionTime;
    }
}
