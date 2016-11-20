package homework.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Class performs command checkLinkPresentByHref
 */
public class CommandCheckLinkPresentByHref extends Command {

    /**
     * Line with command name
     */
    private final String COMMAND_NAME = "checkLinkPresentByHref";

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
    protected CommandCheckLinkPresentByHref() {
    }

    /**
     * Method set attributes to current command
     *
     * @param attribute attributes of command
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
            long start = System.currentTimeMillis();
            driver.findElement(By.xpath("//*[@href='" + attribute + "']"));
            long finish = System.currentTimeMillis();
            executionTime = finish - start;
            isPassed = true;
        } catch (NoSuchElementException e) {
            isPassed = false;
        }
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
