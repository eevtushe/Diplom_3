import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.ApiHelper;
import utilities.Links;
import java.util.concurrent.TimeUnit;

public class SignInPageTest extends BaseTest {

    @Before
    public void setUp() {
        Response response = ApiHelper.createUser(email, password, name);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    @Test
    @Description("Проверка входа в личный кабинет с помощью кнопки \"Войти в аккаунт\" с домашней страницы")
    public void signInFromHomePageTest() {
        webDriver.get(Links.MAIN_PAGE);
        homePage.loginButtonClick();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickEnter();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка входа в личный кабинет с помощью кнопки \"Личный кабинет\"")
    public void signInFromMyAccountTest() {
        webDriver.get(Links.MAIN_PAGE);
        homePage.MyAccountButtonClick();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickEnter();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка входа в личный кабинет с помощью кнопки \"Войти\" со страницы регистрации")
    public void signInFromSignUpPageTest() {
        webDriver.get(Links.SIGNUP_PAGE);
        signUpPage.signInButtonClick();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickEnter();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка входа в личный кабинет с помощью кнопки \"Войти\" со страницы восстановления пароля")
    public void signInFromRecoveryPage() {
        webDriver.get(Links.RECOVER_PASSWORD_PAGE);
        passwordRecoverPage.signInButtonClick();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickEnter();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }
}