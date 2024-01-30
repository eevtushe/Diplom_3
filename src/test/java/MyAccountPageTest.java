import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.Links;
import java.util.concurrent.TimeUnit;
import utilities.ApiHelper;

public class MyAccountPageTest extends BaseTest {
    @Before
    public void setUp() {
        Response response = ApiHelper.createUser(email, password, name);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(Links.SIGN_IN_PAGE);
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickEnter();
    }

    @Test
    @Description("Проверка переадресации авторизованного пользователя с домашней страницы на страницу личного кабинета")
    public void myAccountRedirectionTest() {
        homePage.MyAccountButtonClick();
        Assert.assertTrue(myAccountPage.checkIfExitButtonIsAvailable());
    }

    @Test
    @Description("Проверка переадресации со страницы личного кабинета на домашнюю страницу с помощью кнопки конструктора")
    public void myAccountPageToHomePageWithConstructorButtonTest() {
        homePage.MyAccountButtonClick();
        homePage.constructorButtonClick();
        Assert.assertTrue(homePage.checkCreateOrderButtonVisibility());
    }

    @Test
    @Description("Проверка переадресации со страницы личного кабинета на домашнюю страницу с помощью нажатия на логотип Stellar-Burgers")
    public void myAccountPageToHomePageWithLogoButtonTest() {
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