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
    private WebDriver driver;

    /**
     * Locators for current page
     */
    private final By POST_LINK = By.xpath("//*[@href='http://localhost:8888/?p=1']");
    private final By COMMENT_LINK = By.xpath("//*[@href='http://localhost:8888/?p=1#comments']");
    private final By SEARCH_FIELD_FORM = By.cssSelector("main.site-main");
    private final By MAIN_TEXT_FIELD = By.cssSelector("main.site-main");
    private final By SITE_HEADER_FIELD = By.cssSelector("header.site-header");
    private final By SIDEBAR_FIELD = By.cssSelector("aside.sidebar.widget-area");

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
     * Method searches for post link and clicks it
     *
     * @return current object of class
     */
    public SitePage checkLinkPost() {
        driver.findElement(POST_LINK).click();
        return this;
    }

    /**
     * Method searches for search field
     *
     * @return current object of class
     */
    public SitePage findSearchField() {
        driver.findElement(SEARCH_FIELD_FORM);
        return this;
    }

    /**
     * Method searches for main text field
     *
     * @return current object of class
     */
    public SitePage findMainTextField() {
        driver.findElement(MAIN_TEXT_FIELD);
        return this;
    }

    /**
     * Method searches for header field
     *
     * @return current object of class
     */
    public SitePage findHeaderField() {
        driver.findElement(SITE_HEADER_FIELD);
        return this;
    }

    /**
     * Method searches for sidebar field
     *
     * @return current object of class
     */
    public SitePage findSidebarField() {
        driver.findElement(SIDEBAR_FIELD);
        return this;
    }

    /**
     * Method searches for comment link and clicks it
     *
     * @return current object of class
     */
    public SitePage checkLinkComment() {
        driver.findElement(COMMENT_LINK).click();
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
