package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddPostPage;
import pages.LogInPage;

/**
 * Created by 777 on 05.12.2016.
 */
public class AddPostPageTest {

    WebDriver driver;
    AddPostPage page;
    LogInPage logInPage;

    private final String ADMIN_NAME = "admin";
    private final String ADMIN_PASSWORD = "password";
    private final String URL = "http://localhost:8888/wp-admin/post-new.php";
    private final String LOGIN_URL = "http://localhost:8888/wp-login.php";
    private final String TITLE_TEXT = "New post";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");
        driver = new ChromeDriver();
        page = new AddPostPage(driver);
        logInPage = new LogInPage(driver);
        logInPage.openPage(LOGIN_URL).setUsername(ADMIN_NAME).setPassword(ADMIN_PASSWORD).clickSubmit();
        page.openPage(URL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void tstCheckPublishBarPresent() {
        driver.findElement(By.cssSelector("div#submitdiv.postbox"));
    }

    @Test
    public void tstCheckFormatBarPresent() {
        driver.findElement(By.cssSelector("div#formatdiv.postbox"));
    }

    @Test
    public void tstCheckCategoryBarPresent() {
        driver.findElement(By.cssSelector("div#categorydiv.postbox"));
    }

    @Test
    public void tstCheckTagsBarPresent() {
        driver.findElement(By.cssSelector("div#tagsdiv-post_tag.postbox"));
    }

    @Test
    public void tstCheckPostImageBarPresent() {
        driver.findElement(By.cssSelector("div#postimagediv.postbox"));
    }

    @Test
    public void tstValidSetNewPostByAdmin() {
        page.setTitle(TITLE_TEXT).publish();
        driver.findElement(By.linkText("View post")).click();
        Assert.assertTrue(driver.findElement(By.className("entry-title")).getText().equals(TITLE_TEXT));

    }
}
