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

public class AddPostPageTest {

    private WebDriver driver;
    private AddPostPage page;
    private LogInPage logInPage;

    private final String ADMIN_NAME = "admin";
    private final String ADMIN_PASSWORD = "password";
    private final String URL = "http://localhost:8888/wp-admin/post-new.php";
    private final String LOGIN_URL = "http://localhost:8888/wp-login.php";
    private final String TITLE_TEXT = "New post";
    private final String CHROME_DRIVER = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\" + "chromedriver.exe";

    private final By ENTRY_TITLE = By.className("entry-title");

    @BeforeTest
    public void setUp() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
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
        page.findPublishBarField();
    }

    @Test
    public void tstCheckFormatBarPresent() {
        page.findFormatBarField();
    }

    @Test
    public void tstCheckCategoryBarPresent() {
        page.findCategoryBarField();
    }

    @Test
    public void tstCheckTagsBarPresent() {
        page.findTagsBarField();
    }

    @Test
    public void tstCheckPostImageBarPresent() {
        page.findImageBarField();
    }

    @Test
    public void tstValidSetNewPostByAdmin() {
        page.setTitle(TITLE_TEXT).publish();
        page.clickViewPost();
        Assert.assertTrue(driver.findElement(ENTRY_TITLE).getText().equals(TITLE_TEXT));
    }
}
