package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by 777 on 04.12.2016.
 */
public class SitePageTest {

    SitePage page;
    WebDriver driver;

    private final String URL = "http://localhost:8888";
    private final String EXISTING_TEXT = "Hello world!";
    private final String INEXISTING_TEXT = "Inexisting post";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");
        driver = new ChromeDriver();
        page = new SitePage(driver);
    }

    @Test
    public void searchExistingPost() {
        page.openSite(URL).search(EXISTING_TEXT).submitSearch();
        Assert.assertTrue(!driver.findElement(By.className("page-title")).getText().equals("Nothing Found"));
    }

    @Test
    public void checkLinkPost() {
        page.openSite(URL).checkLinkPost();
        Assert.assertTrue(driver.findElement(By.className("entry-title")).getText().equals(EXISTING_TEXT));
    }

    @Test
    public void checkLinkComment() {
        page.openSite(URL).checkLinkComment();
        driver.findElement(By.cssSelector("li#comment-1.comment.even.thread-even.depth-1"));
    }

    @Test
    public void checkSearchFieldPresent() {
        page.openSite(URL);
        driver.findElement(By.cssSelector("input.search-field"));
    }

    @Test
    public void checkMainTextPresent() {
        page.openSite(URL);
        driver.findElement(By.cssSelector("main.site-main"));
    }

    @Test
    public void checkSiteHeaderPresent() {
        page.openSite(URL);
        driver.findElement(By.cssSelector("header.site-header"));
    }

    @Test
    public void checkSidebarPresent() {
        page.openSite(URL);
        driver.findElement(By.cssSelector("aside.sidebar.widget-area"));
    }

    @Test
    public void searchInexistingPost() {
        page.openSite(URL).search(INEXISTING_TEXT).submitSearch();
        Assert.assertTrue(driver.findElement(By.className("page-title")).getText().equals("Nothing Found"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
