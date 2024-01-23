import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.UsefulLinks;
import java.util.concurrent.TimeUnit;

public class MyAccountPageTest extends BaseTest {
    @Before
    public void setUp() {
        signUpPage.createUser(EMAIL, PASSWORD, NAME);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(UsefulLinks.SIGN_IN_PAGE);
        signInPage.enterEmail(EMAIL);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickEnter();
    }

    @Test
    @Description("Проверка переадресации авторизованного пользователя с домашней страницы на страницу личного кабинета")
    public void MyAccountRedirectionTest() {
        homePage.MyAccountButtonClick();
        Assert.assertTrue(myAccountPage.checkIfExitButtonIsAvailable());
    }

    @Test
    @Description("Проверка переадресации со страницы личного кабинета на домашнюю страницу с помощью кнопки конструктора")
    public void MyAccountPageToHomePageWithConstructorButtonTest() {
        homePage.MyAccountButtonClick();
        homePage.constructorButtonClick();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка переадресации со страницы личного кабинета на домашнюю страницу с помощью нажатия на логотип Stellar-Burgers")
    public void MyAccountPageToHomePageWithLogoButtonTest() {
        homePage.MyAccountButtonClick();
        homePage.logoClick();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка выхода с помощью кнопки \"Выход\" и переадресация из личного кабинета на страницу авторизации")
    public void logOutTest() {
        homePage.MyAccountButtonClick();
        myAccountPage.logOutButtonClick();
        Assert.assertTrue(signInPage.checkEnterButton());
    }
}