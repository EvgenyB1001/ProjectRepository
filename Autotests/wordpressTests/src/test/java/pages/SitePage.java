package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class of definite site page
 */
public class SitePage {

    /**
     * Object of Webdriver
     */
    WebDriver driver;

    /**
     * Lines with page data
     */
    private final String SEARCH_FIELD = "search-field";
    private final String SEARCH_BUTTON = "search-submit";

    public SitePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method open site by current url, got as parameter
     *
     * @param url url of site
     * @return current object of class
     */
    public SitePage openSite(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Method sets text to search
     *
     * @param text text to search
     * @return current object of class
     */
    public SitePage search(String text) {
        driver.findElement(By.className(SEARCH_FIELD)).sendKeys(text);
        return this;
    }

    /**
     * Method of click submit button
     */
    public SitePage submitSearch() {
        driver.findElement(By.className(SEARCH_BUTTON)).click();
        return this;
    }
}
