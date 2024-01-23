import pageobject.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import webdrivers.WebDriverSelector;

public class BaseTest {
    WebDriver webDriver = WebDriverSelector.get("Chrome Browser");

    SignInPage signInPage = new SignInPage(webDriver);
    HomePage homePage = new HomePage(webDriver);
    SignUpPage signUpPage = new SignUpPage(webDriver);
    PasswordRecoverPage passwordRecoverPage = new PasswordRecoverPage(webDriver);
    MyAccountPage myAccountPage = new MyAccountPage(webDriver);

    protected static String EMAIL = "eevtushe@gmail.com";
    protected static String PASSWORD = "qwerty12345";
    protected static String WRONG_PASSWORD = "qwerty5432";
    protected static String NAME = "Name";
    protected static String TOKEN;

    @After
    public void tearDownAndClearData() {
        webDriver.close();
        TOKEN = SignUpPage.getToken(EMAIL, PASSWORD);
        if (TOKEN != null) {
            SignUpPage.deleteUser(TOKEN);
        }
    }
}
