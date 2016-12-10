package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CurrentPostPage;
import pages.LogInPage;

/**
 * Created by 777 on 05.12.2016.
 */
public class PostPageTest {
    CurrentPostPage page;
    WebDriver driver;

    private final String LOGIN_URL = "http://localhost:8888/wp-login.php";
    private final String URL = "http://localhost:8888/?p=1";
    private final String USERNAME = "commentator";
    private final String EMAIL = "commentator@gmail.com";
    private final String INCORRECT_EMAIL = "@incorrectEmail";
    private final String COMMENT = "Some comment";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new CurrentPostPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "invalid parameters")
    public Object[][] getInvalidParameters() {
        return new Object[][]{
                {"", "", ""},
                {"", "", EMAIL},
                {"", USERNAME, ""},
                {COMMENT, "", ""},
                {COMMENT, USERNAME, ""},
                {COMMENT, "", EMAIL},
                {COMMENT, USERNAME, INCORRECT_EMAIL}
        };
    }

    @Test(dataProvider = "invalid parameters")
    public void tstInvalidCommentByUnauthorizedUser(String comment, String name, String email) {
        page.openPage(URL).commentByUnknownUser(comment, name, email).clickSubmit();
        Assert.assertTrue(driver.getTitle().equals("Comment Submission Failure"));
    }

    @Test
    public void tstValidCommentByAuthorizedUser() {
        new LogInPage(driver).openPage(LOGIN_URL).setUsername("user1").setPassword("user1").clickSubmit();
        page.openPage(URL).commentByAuthorizedUser(COMMENT).clickSubmit();
        Assert.assertTrue(!(driver.getTitle().equals("Comment Submission Failure")));
    }

}
