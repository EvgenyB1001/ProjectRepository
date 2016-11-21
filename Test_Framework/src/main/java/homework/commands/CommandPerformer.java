package homework.commands;

import homework.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

/**
 * Class performs definite commands, set by user
 */
public class CommandPerformer {

    /**
     * Line with Google Chrome driver property name
     */
    private static final String CHROME_PROPERTY_NAME = "webdriver.chrome.driver";

    /**
     * Line with default file path to Chrome driver
     */
    private static final String WINDOWS_DEFAULT_CHROME_PATH =
            "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";

    /**
     * Method gets list of command, perform them and set another information about execution
     * to logger.
     *
     * @param commands list of commands
     * @param logger   object of logger
     */
    public void performCommands(ArrayList<Command> commands, Logger logger) throws Exception {
        if (commands == null || logger == null) {
            throw new Exception("Parameters to perform commands or to log are not initialized");
        }
        System.setProperty(CHROME_PROPERTY_NAME, WINDOWS_DEFAULT_CHROME_PATH);
        WebDriver driver = new ChromeDriver();
        for (Command command : commands) {
            long start = System.currentTimeMillis();
            command.performCommand(driver);
            long finish = System.currentTimeMillis();
            command.setExecutionTime(finish - start);
            logger.setRecord(command);
        }
        driver.quit();
    }
}
