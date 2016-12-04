package homework.commands;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Class perform action on command open "URL" "timeout"
 */
public class CommandOpen extends Command {

    /**
     * Line with command name
     */
    private final String COMMAND_NAME = "open";

    /**
     * URL name of site to check
     */
    private String url = new String();

    /**
     * Value of timeout
     */
    private long timeout = 0;
    /**
     * Time of command execution
     */
    private long executionTime = 0;

    /**
     * Constructor of class
     */
    protected CommandOpen() {
    }

    /**
     * Status of command. True - command passed
     */
    private boolean isPassed = false;

    /**
     * Method set attributes to current command
     *
     * @param attributes attributes of command
     */
    public void setAttributes(String[] attributes) throws Exception {
        if (attributes == null) {
            throw new Exception("Attributes are not initialized");
        }
        if (attributes.length != 2) {
            throw new Exception("Invalid attributes count. Expected 2");
        }
        this.url = attributes[0];
        this.timeout = Long.parseLong(attributes[1]);
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
     * Method returns status of command
     *
     * @return boolean value: true - command passed
     */
    public boolean getCommandStatus() {
        return isPassed;
    }

    /**
     * Method returns line of attributes of command
     *
     * @return line of attributes of command
     */
    public String getCommandAttributesToString() {
        return "\"" + url + "\"" + " \"" + timeout + "\"";
    }

    /**
     * Method performs current command
     *
     * @param driver object of WebDriver
     */
    public void performCommand(WebDriver driver) {
        try {
            driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
            driver.get(url);
            isPassed = true;
        } catch (TimeoutException e) {
            System.err.println("Site open failed due timeout");
            isPassed = false;
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
