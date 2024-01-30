import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.ApiHelper;
import utilities.Links;
import java.util.concurrent.TimeUnit;

public class SignUpPageTest extends BaseTest {
    @Before
    public void setUp() {
        try {
            signUpPage.openSignUpPage(Links.SIGNUP_PAGE);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            String authToken = ApiHelper.getToken(email, password);
            if (authToken != null) {
                ApiHelper.deleteUser(authToken);
            }
        }
    }

    @Test
    @Description("Корректная регистрация пользователя")
    public void signUpCorrectTest() {
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.signUpButtonClick();
        Assert.assertTrue(signInPage.checkEnterButton());
    }

    @Test
    @Description("Негативный тест с вводом пароля некорректной длины")
    public void signUpWithWrongPasswordTest() {
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(wrongPassword);
        signUpPage.signUpButtonClick();
        Assert.assertTrue(signUpPage.checkPasswordError());
    }
}
