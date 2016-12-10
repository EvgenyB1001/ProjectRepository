package tests;

import database.DBManager;
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

    private final String SITE_NAME = "My_Site";
    private final String ADMIN_NAME = "admin";
    private final String ADMIN_PASSWORD = "password";
    private final String URL = "http://localhost:8888/wp-admin/post-new.php";
    private final String LOGIN_URL = "http://localhost:8888/wp-login.php";
    private final String TITLE_TEXT = "New post";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new AddPostPage(driver);
        logInPage = new LogInPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void tstValidSetNewPostByAdmin() {
        logInPage.openPage(LOGIN_URL).setUsername(ADMIN_NAME).setPassword(ADMIN_PASSWORD).clickSubmit();
        page.openPage(URL).setTitle(TITLE_TEXT).publish();
        driver.findElement(By.linkText("View post")).click();
        Assert.assertEquals(driver.getTitle(), TITLE_TEXT + " – " + SITE_NAME);
    }
}
