package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoverPage {
    private WebDriver webDriver;

    //Locators
    private By loginButton = By.xpath(".//a[@class='Auth_link__1fOlj']");
    private By emailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']");
    private By passwordRecoverButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");


    public PasswordRecoverPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Вводим корректный e-mail")
    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    @Step("Нажимаем кнопку \"Восстановить\"")
    public void passwordRecoverButtonClick() {
        webDriver.findElement(passwordRecoverButton).click();
    }

    @Step("Нажимаем кнопку \"Войти\"")
    public void signInButtonClick() {
        webDriver.findElement(loginButton).click();
    }
}