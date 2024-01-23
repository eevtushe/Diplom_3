import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.UsefulLinks;
import java.util.concurrent.TimeUnit;

public class SignInPageTest extends BaseTest {

    @Before
    public void setUp() {
            signUpPage.createUser(EMAIL, PASSWORD, NAME);
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    @Test
    @Description("Проверка входа в личный кабинет с помощью кнопки \"Войти в аккаунт\" с домашней страницы")
    public void signInFromHomePageTest() {
        webDriver.get(UsefulLinks.MAIN_PAGE);
        homePage.loginButtonClick();
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка входа в личный кабинет с помощью кнопки \"Личный кабинет\"")
    public void signInFromMyAccountTest() {
        webDriver.get(UsefulLinks.MAIN_PAGE);
        homePage.MyAccountButtonClick();
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка входа в личный кабинет с помощью кнопки \"Войти\" со страницы регистрации")
    public void signInFromSignUpPageTest() {
        webDriver.get(UsefulLinks.SIGNUP_PAGE);
        signUpPage.signInButtonClick();
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка входа в личный кабинет с помощью кнопки \"Войти\" со страницы восстановления пароля")
    public void signInFromRecoveryPage() {
        webDriver.get(UsefulLinks.RECOVER_PASSWORD_PAGE);
        passwordRecoverPage.signInButtonClick();
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }
}