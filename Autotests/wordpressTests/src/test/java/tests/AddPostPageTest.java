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

/**
 * Created by 777 on 05.12.2016.
 */
public class AddPostPageTest {

    WebDriver driver;
    AddPostPage page;
    DBManager manager = DBManager.getInstance();

    private final String LOGIN_URL = "https://local.wordpress.dev/wp-login.php";
    private final String URL = "http://local.wordpress.dev/wp-admin/post-new.php";
    private final String TITLE_TEXT = "New post";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new AddPostPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void tstValidSetNewPost() {
        Integer previousCount = manager.getCountOfPosts();
        page.openPage(URL);
        driver.findElement(By.id("user_login")).sendKeys("admin");
        driver.findElement(By.id("user_pass")).sendKeys("password");
        driver.findElement(By.id("wp-submit")).click();
        page.setTitle(TITLE_TEXT).publish();
        Assert.assertEquals(manager.getCountOfPosts(), (Integer)(previousCount + 1));
    }
}
