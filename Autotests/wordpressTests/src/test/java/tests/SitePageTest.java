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

    private final String URL = "https://local.wordpress.dev";
    private final String EXISTING_TEXT = "Hello world!";
    private final String INEXISTING_TEXT = "Inexisting post";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new SitePage(driver);
    }

    @Test
    public void searchExistingPost() {
        page.openSite(URL).search(EXISTING_TEXT).submitSearch();
        Assert.assertTrue(!driver.findElement(By.className("page-title")).getText().equals("Nothing Found"));
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
