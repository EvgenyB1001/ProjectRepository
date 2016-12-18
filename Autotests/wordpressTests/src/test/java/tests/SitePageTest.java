package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class SitePageTest {

    private SitePage page;
    private WebDriver driver;

    private final String URL = "http://localhost:8888";
    private final String EXISTING_TEXT = "Hello world!";
    private final String INEXISTING_TEXT_TITLE = "Nothing Found";
    private final String INEXISTING_TEXT = "Inexisting post";
    private final String CHROME_DRIVER = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\" + "chromedriver.exe";

    private final By PAGE_TITLE = By.className("page-title");
    private final By ENTRY_TITLE = By.className("entry-title");
    private final By COMMENT_TEXT = By.cssSelector("li#comment-1.comment.even.thread-even.depth-1");

    @BeforeTest
    public void setUp() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        page = new SitePage(driver);
    }

    @BeforeMethod
    public void tearUp() {
        page.openSite(URL);
    }

    @Test
    public void searchExistingPost() {
        page.openSite(URL).search(EXISTING_TEXT).submitSearch();
    }

    @Test
    public void checkLinkPost() {
        page.checkLinkPost();
        Assert.assertTrue(driver.findElement(ENTRY_TITLE).getText().equals(EXISTING_TEXT));
    }

    @Test
    public void checkLinkComment() {
        page.checkLinkComment();
        driver.findElement(COMMENT_TEXT);
    }

    @Test
    public void checkSearchFieldPresent() {
        page.findSearchField();
    }

    @Test
    public void checkMainTextPresent() {
        page.findMainTextField();
    }

    @Test
    public void checkSiteHeaderPresent() {
        page.findHeaderField();
    }

    @Test
    public void checkSidebarPresent() {
        page.findSidebarField();
    }

    @Test
    public void searchInexistingPost() {
        page.search(INEXISTING_TEXT).submitSearch();
        Assert.assertTrue(driver.findElement(PAGE_TITLE).getText().equals(INEXISTING_TEXT_TITLE));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
