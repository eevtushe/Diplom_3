import pageobject.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import webdrivers.WebDriverSelector;
import utilities.ApiHelper;
import org.apache.commons.lang3.RandomStringUtils;

public class BaseTest {
    private static final String BROWSER_NAME = System.getenv("BROWSER_NAME");

    WebDriver webDriver = WebDriverSelector.get(BROWSER_NAME);

    SignInPage signInPage = new SignInPage(webDriver);
    HomePage homePage = new HomePage(webDriver);
    SignUpPage signUpPage = new SignUpPage(webDriver);
    PasswordRecoverPage passwordRecoverPage = new PasswordRecoverPage(webDriver);
    MyAccountPage myAccountPage = new MyAccountPage(webDriver);

    protected static String email = generateRandomEmail();
    protected static String password = RandomStringUtils.randomAlphanumeric(10);
    protected static String wrongPassword = RandomStringUtils.randomAlphanumeric(10);
    protected static String name = generateRandomName();
    protected static String token;

    private static String generateRandomEmail() {
        return "user" + RandomStringUtils.randomAlphanumeric(5) + "@yandex.ru";
    }

    private static String generateRandomName() {
        return "User" + RandomStringUtils.randomAlphabetic(5);
    }

    @After
    public void tearDownAndClearData() {
        webDriver.close();
        String authToken = ApiHelper.getToken(email, password);
        if (authToken != null) {
            ApiHelper.deleteUser(authToken);
        }
    }
}
