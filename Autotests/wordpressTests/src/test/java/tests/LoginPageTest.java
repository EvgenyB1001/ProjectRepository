package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;
import pages.LogInPage;

public class LoginPageTest {

    private LogInPage page;
    private WebDriver driver;
    private ProviderData provider = ProviderData.getInstance();

    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    private final String VALID_DATA = "valid";
    private final String INVALID_DATA = "invalid";
    private final String URL = "http://localhost:8888/wp-login.php";
    private final String FILENAME = "/Data_Provider_Users.xml";
    private final String CHROME_DRIVER = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\" + "chromedriver.exe";

    @BeforeMethod
    public void setUp() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        page = new LogInPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "invalid user data")
    public Object[][] getInvalidData() throws Exception {
        return provider.readDataXml(FILENAME, INVALID_DATA, new String[]{LOGIN, PASSWORD});
    }

    @DataProvider(name = "valid user data")
    public Object[][] getValidData() throws Exception {
        return provider.readDataXml(FILENAME, VALID_DATA, new String[]{LOGIN, PASSWORD});
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
