import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.UsefulLinks;
import java.util.concurrent.TimeUnit;

public class HomePageTest extends BaseTest {
    @Before
    public void setUp() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(UsefulLinks.MAIN_PAGE);
    }

    @Test
    @Description("Проверяем, активна ли вкладка \"Булки\"")
    public void checkIfBunsTabActive() {
        Assert.assertEquals(homePage.getActiveTab(), "Булки");
    }

    @Test
    @Description("Проверяем, активна ли вкладка \"Соусы\"")
    public void clickSauceTabAndCheckActivity() {
        homePage.sauceButtonClick();
        Assert.assertEquals(homePage.getActiveTab(), "Соусы");
    }

    @Test
    @Description("Проверяем, активна ли вкладка \"Начинки\"")
    public void clickFillingTabAndCheckActivity() {
        homePage.fillingButtonClick();
        Assert.assertEquals(homePage.getActiveTab(), "Начинки");
    }
}