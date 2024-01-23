package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver webDriver;
    private By logOutButton = By.xpath(".//button[text()='Выход']");

    public MyAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверяем доступность кнопки \"Выход\"")
    public boolean checkIfExitButtonIsAvailable() {
        return webDriver.findElement(logOutButton).isDisplayed();
    }

    @Step("Нажимаем кнопку \"Выход\"")
    public void logOutButtonClick() {
        webDriver.findElement(logOutButton).click();
    }
}