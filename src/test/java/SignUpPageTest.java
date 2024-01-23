import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.UsefulLinks;
import java.util.concurrent.TimeUnit;

public class SignUpPageTest extends BaseTest {
    @Before
    public void setUp() {
        signUpPage.openSignUpPage(UsefulLinks.SIGNUP_PAGE);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @Description("Корректная регистрация пользователя")
    public void signUpCorrectTest() {
        signUpPage.enterName(NAME);
        signUpPage.enterEmail(EMAIL);
        signUpPage.enterPassword(PASSWORD);
        signUpPage.signUpButtonClick();
        Assert.assertTrue(signInPage.checkEnterButton());
    }

    @Test
    @Description("Негативный тест с вводом пароля некорректной длины")
    public void signUpWithWrongPasswordTest() {
        signUpPage.enterName(NAME);
        signUpPage.enterEmail(EMAIL);
        signUpPage.enterPassword(WRONG_PASSWORD);
        signUpPage.signUpButtonClick();
        Assert.assertTrue(signUpPage.checkPasswordError());

    }
}
