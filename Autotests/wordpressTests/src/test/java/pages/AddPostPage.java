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
    WebDriver driver;

    /**
     * Lines with page data
     */
    private final String URL = "http://local.wordpress.dev/wp-admin/post-new.php";
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
     * Method of click submit button
     */
    public void publish() {
        driver.findElement(By.id(PUBLISH_BUTTON)).click();
    }

}
