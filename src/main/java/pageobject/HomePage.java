package pageobject;

import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    private WebDriver webDriver;

    //Upper row
    private By loginButton = (By.xpath("//button[contains(text(),'Войти в аккаунт')]"));
    private By myAccountButton = (By.linkText("Личный Кабинет"));
    private By starLogoButton = (By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']"));

    //Middle row
    private By bunButton = (By.xpath(".//div/span[text()='Булки']"));
    private By sauceButton = (By.xpath(".//div/span[text()='Соусы']"));
    private By fillingsButton = (By.xpath(".//div/span[text()='Начинки']"));
    private By makeYourBurgerButtons = (By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']"));
    private By burgerConstructionButton = (By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2']"));
    private By makeAnOrderButton = (By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']"));

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Нажимаем кнопку \"Войти в аккаунт\"")
    public void loginButtonClick() {
        webDriver.findElement(loginButton).click();
    }
    @Step("Нажимаем кнопку \"Личный кабинет\"")
    public void MyAccountButtonClick() {
        webDriver.findElement(myAccountButton).click();
    }
    @Step("Нажимаем на логотип сайта")
    public void logoClick() {
        webDriver.findElement(starLogoButton).click();
    }
    @Step("Нажимаем кнопку \"Булки\"")
    public void bunButtonClick() {
        webDriver.findElement(bunButton).click();
    }
    @Step("Нажимаем кнопку \"Соусы\"")
    public void sauceButtonClick() {
        webDriver.findElement(sauceButton).click();
    }
    @Step("Нажимаем кнопку \"Начинки\"")
    public void fillingButtonClick() {
        webDriver.findElement(fillingsButton).click();
    }
    @Step("Нажимаем кнопку \"Конструктор\"")
    public void constructorButtonClick() {
        webDriver.findElement(burgerConstructionButton).click();
    }
    @Step("Нажимаем кнопку \"Оформить заказ\"")
    public boolean checkCreateOrderButtonVisibility() {
        return webDriver.findElement(makeAnOrderButton).isDisplayed();
    }
    @Step("Переключаемся между кнопками \"Булки\", \"Соусы\", \"Начинки\"")
    public String getActiveTab() {
        return webDriver.findElement(makeYourBurgerButtons).getText();
    }
}