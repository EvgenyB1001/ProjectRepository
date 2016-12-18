package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

/**
 * Class of page to add new post
 */
public class AddPostPage {

    /**
     * Object of Webdriver
     */
    private WebDriver driver;

    /**
     * Locators of current page
     */
    private final By PUBLISH_BAR = By.cssSelector("div#submitdiv.postbox");
    private final By FORMAT_BAR = By.cssSelector("div#formatdiv.postbox");
    private final By CATEGORY_BAR = By.cssSelector("div#categorydiv.postbox");
    private final By TAGS_BAR = By.cssSelector("div#tagsdiv-post_tag.postbox");
    private final By IMAGE_BAR = By.cssSelector("div#postimagediv.postbox");
    private final By VIEW_POST_LINK = By.linkText("View post");

    /**
     * Lines with page data
     */
    private final String TITLE_FIELD = "title";
    private final String PUBLISH_BUTTON = "publish";

    public AddPostPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method open site by current url, got as parameter
     *
     * @param url url of site
     * @return current object of class
     */
    public AddPostPage openPage(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Method sets text of post title
     *
     * @param title text of title
     * @return current object of class
     */
    public AddPostPage setTitle(String title) {
        driver.findElement(By.id(TITLE_FIELD)).sendKeys(title);
        return this;
    }

    /**
     * Method searches for publish bar
     *
     * @return current object of class
     */
    public AddPostPage findPublishBarField() {
        driver.findElement(PUBLISH_BAR);
        return this;
    }

    /**
     * Method searches for format bar
     *
     * @return current object of class
     */
    public AddPostPage findFormatBarField() {
        driver.findElement(FORMAT_BAR);
        return this;
    }

    /**
     * Method searches for category bar
     *
     * @return current object of class
     */
    public AddPostPage findCategoryBarField() {
        driver.findElement(CATEGORY_BAR);
        return this;
    }

    /**
     * Method searches for tags bar
     *
     * @return current object of class
     */
    public AddPostPage findTagsBarField() {
        driver.findElement(TAGS_BAR);
        return this;
    }

    /**
     * Method searches for image bar
     *
     * @return current object of class
     */
    public AddPostPage findImageBarField() {
        driver.findElement(IMAGE_BAR);
        return this;
    }

    /**
     * Method searches for view post link and clicks it
     *
     * @return current object of class
     */
    public AddPostPage clickViewPost() {
        driver.findElement(VIEW_POST_LINK).click();
        return this;
    }

    /**
     * Method of click submit button
     */
    public void publish() {
        driver.findElement(By.id(PUBLISH_BUTTON)).click();
    }
}
