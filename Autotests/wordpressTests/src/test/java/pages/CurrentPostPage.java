package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

/**
 * Class of definite post page
 */
public class CurrentPostPage {

    /**
     * Object of Webdriver
     */
    private WebDriver driver;

    /**
     * Locators for current page
     */
    private final By COMMENT_TEXT = By.cssSelector("article.post-1.post.type-post.status-publish.format-standard.hentry.category-uncategorized");
    private final By POST_TEXT = By.cssSelector("li#comment-1.comment.even.thread-even.depth-1");

    /**
     * Lines with page data
     */
    private final String COMMENT_FIELD = "comment";
    private final String EMAIL_FIELD = "email";
    private final String NAME_FIELD = "author";
    private final String SUBMIT_BUTTON = "submit";

    public CurrentPostPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method open site by current url, got as parameter
     *
     * @param url url of site
     * @return current object of class
     */
    public CurrentPostPage openPage(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Method sets text of comment, name of unauthorized user and his email
     *
     * @param comment text od comment
     * @param name    username
     * @param email   email of user
     * @return current object of class
     */
    public CurrentPostPage commentByUnknownUser(String comment, String name, String email) {
        driver.findElement(By.id(COMMENT_FIELD)).sendKeys(comment);
        driver.findElement(By.id(NAME_FIELD)).sendKeys(name);
        driver.findElement(By.id(EMAIL_FIELD)).sendKeys(email);
        return this;
    }

    /**
     * Method sets text of comment, name of authorized user and his email
     *
     * @param comment text od comment
     * @return current object of class
     */
    public CurrentPostPage commentByAuthorizedUser(String comment) {
        driver.findElement(By.id(COMMENT_FIELD)).sendKeys(comment);
        return this;
    }

    /**
     * Method searches for comment text field
     *
     * @return object of class
     */
    public CurrentPostPage findCommentTextField() {
        driver.findElement(COMMENT_TEXT);
        return this;
    }

    /**
     * Method searches for post text field
     *
     * @return object of class
     */
    public CurrentPostPage findPostTextField() {
        driver.findElement(POST_TEXT);
        return this;
    }

    /**
     * Method of click submit button
     */
    public void clickSubmit() {
        driver.findElement(By.id(SUBMIT_BUTTON)).click();
    }
}
