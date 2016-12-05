package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LogInPage;

/**
 * Created by 777 on 04.12.2016.
 */
public class LoginPageTest {

    LogInPage page;
    WebDriver driver;

    private final String URL = "https://local.wordpress.dev/wp-login.php";
    private final String ADMIN_NAME = "admin";
    private final String UNREGISTERED_NAME = "unregistered";
    private final String ADMIN_PASSWORD = "password";
    private final String WRONG_PASSWORD = "paswor";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new LogInPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "invalid parameters")
    public Object[][] getInvalidParameters() {
        return new Object[][]{
                {"", ""},
                {"", ADMIN_PASSWORD},
                {"", WRONG_PASSWORD},
                {ADMIN_NAME, ""},
                {UNREGISTERED_NAME, ""},
                {ADMIN_NAME, WRONG_PASSWORD},
                {UNREGISTERED_NAME, ADMIN_PASSWORD}
        };
    }

    @DataProvider(name = "valid parameters")
    public Object[][] getValidParameters() {
        return new Object[][]{
                {ADMIN_NAME, ADMIN_PASSWORD}
        };
    }

   @Test (dataProvider = "invalid parameters")
    public void tstInvalidCases(String username, String password) {
        page.openPage(URL).setUsername(username).setPassword(password).clickSubmit();
        Assert.assertTrue((driver.getCurrentUrl().equals(URL)));
   }

    @Test (dataProvider = "valid parameters")
    public void tstValidCases(String username, String password) {
        page.openPage(URL).setUsername(username).setPassword(password).clickSubmit();
        Assert.assertTrue(!(driver.getCurrentUrl().equals(URL)));
    }
}
