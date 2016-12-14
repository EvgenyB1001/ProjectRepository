package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;
import pages.LogInPage;


/**
 * Created by 777 on 04.12.2016.
 */
public class LoginPageTest {

    LogInPage page;
    WebDriver driver;
    ProviderData provider = ProviderData.getInstance();

    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    private final String VALID_DATA = "valid";
    private final String INVALID_DATA = "invalid";
    private final String URL = "http://localhost:8888/wp-login.php";
    private final String FILENAME = "/Data_Provider_Users.xml";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");
        driver = new ChromeDriver();
        page = new LogInPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "invalid user data")
    public Object[][] getInvalidData() throws Exception {
        return provider.readUserDataXml(FILENAME, INVALID_DATA, new String[]{LOGIN, PASSWORD});
    }

    @DataProvider(name = "valid user data")
    public Object[][] getValidData() throws Exception {
        return provider.readUserDataXml(FILENAME, VALID_DATA, new String[]{LOGIN, PASSWORD});
    }

    @Test(dataProvider = "invalid user data")
    public void tstInvalidCases(String username, String password) {
        page.openPage(URL).setUsername(username).setPassword(password).clickSubmit();
        Assert.assertTrue((driver.getCurrentUrl().equals(URL)));
    }

    @Test(dataProvider = "valid user data")
    public void tstValidCases(String username, String password) {
        page.openPage(URL).setUsername(username).setPassword(password).clickSubmit();
        Assert.assertTrue(!(driver.getCurrentUrl().equals(URL)));
    }
}
