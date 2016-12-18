package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;
import pages.CurrentPostPage;
import pages.LogInPage;


public class PostPageTest {

    private CurrentPostPage page;
    private WebDriver driver;
    private ProviderData providerData = ProviderData.getInstance();

    private final String LOGIN_URL = "http://localhost:8888/wp-login.php";
    private final String URL = "http://localhost:8888/?p=1";
    private final String INVALID_DATA = "invalid";
    private final String AUTHORIZED_DATA = "authorized";
    private final String NAME_ATTRIBUTE = "name";
    private final String PASSWORD_ATTRIBUTE = "password";
    private final String COMMENT_ATTRIBUTE = "comment";
    private final String USERNAME_ATTRIBUTE = "username";
    private final String EMAIL_ATTRIBUTE = "email";
    private final String FILENAME = "/Data_Provider_Comments.xml";
    private final String ERROR_TEXT = "Comment Submission Failure";
    private final String CHROME_DRIVER = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\" + "chromedriver.exe";

    @BeforeTest
    public void setUp() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
    }

    @BeforeMethod
    public void tearUp() {
        driver = new ChromeDriver();
        page = new CurrentPostPage(driver);
        page.openPage(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "invalid parameters")
    public Object[][] getInvalidParameters() throws Exception {
        return providerData.readDataXml(FILENAME, INVALID_DATA, new String[]{COMMENT_ATTRIBUTE,
                USERNAME_ATTRIBUTE, EMAIL_ATTRIBUTE});
    }

    @DataProvider(name = "authorized parameters")
    public Object[][] getAuthorizedParameters() throws Exception {
        return providerData.readDataXml(FILENAME, AUTHORIZED_DATA, new String[]{COMMENT_ATTRIBUTE,
                NAME_ATTRIBUTE, PASSWORD_ATTRIBUTE});
    }

    @Test
    public void tstCommentPresent() {
        page.findCommentTextField();
    }

    @Test
    public void tstPostPresent() {
        page.findPostTextField();
    }

    @Test(dataProvider = "invalid parameters")
    public void tstInvalidCommentByUnauthorizedUser(String comment, String name, String email) {
        page.commentByUnknownUser(comment, name, email).clickSubmit();
        Assert.assertTrue(driver.getTitle().equals(ERROR_TEXT));
    }

    @Test(dataProvider = "authorized parameters")
    public void tstValidCommentByAuthorizedUser(String comment, String loginName, String loginPassword) {
        new LogInPage(driver).openPage(LOGIN_URL).setUsername(loginName).setPassword(loginPassword).clickSubmit();
        page.openPage(URL).commentByAuthorizedUser(comment).clickSubmit();
        Assert.assertTrue(!(driver.getTitle().equals(ERROR_TEXT)));
    }
}
