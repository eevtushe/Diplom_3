package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;


public class SignInPage {
    WebDriver webDriver;

    //Локаторы входа в аккаунт
    private final By emailField = By.xpath(".//fieldset[1]//input");
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    private By enterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //Другие локаторы
    private By recoverPasswordButton = By.xpath(".//a[.='Восстановить пароль']");
    private By registerButton = By.xpath(".//a[.='Зарегистрироваться']");

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Вход в аккаунт
    @Step("Вводим корректный e-mail")
    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);

    }
    @Step("Вводим корректный пароль")

    public void enterPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажимаем кнопку \"Войти\"")
    public void clickEnter() {
        webDriver.findElement(enterButton).click();
    }

    //Другие действия
    @Step("Нажимаем кнопку регистрации")
    public void clickRegister() {
        webDriver.findElement(registerButton).click();
    }

    @Step("Нажимаем кнопку \"Восстановить пароль\"")
    public void clickRecoverPasswordButton() {
        webDriver.findElement(recoverPasswordButton).click();
    }

    @Step("Проверяем кнопку \"Вход\"")
    public boolean checkEnterButton() {
        return webDriver.findElement(enterButton).isDisplayed();
    }
}