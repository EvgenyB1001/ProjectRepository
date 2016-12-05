package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class of log in page
 */
public class LogInPage {

    /**
     * Object of Webdriver
     */
    WebDriver driver;

    /**
     * Lines with page data
     */
    private final String USERNAME_FIELD = "user_login";
    private final String PASSWORD_FIELD = "user_pass";
    private final String SUBMIT_BUTTON_ID = "wp-submit";

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method open site by current url, got as parameter
     *
     * @param url url of site
     * @return current object of class
     */
    public LogInPage openPage(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Method sets text of name of user
     *
     * @param username username
     * @return current object of class
     */
    public LogInPage setUsername(String username) {
        driver.findElement(By.id(USERNAME_FIELD)).sendKeys(username);
        return this;
    }

    /**
     * Method sets text of password of user
     *
     * @param password username
     * @return current object of class
     */
    public LogInPage setPassword(String password) {
        driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(password);
        return this;
    }

    /**
     * Method of click submit button
     */
    public void clickSubmit() {
        driver.findElement(By.id(SUBMIT_BUTTON_ID)).click();
    }
}
