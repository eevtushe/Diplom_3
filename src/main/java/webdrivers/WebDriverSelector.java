package webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSelector {
    public static WebDriver get(String browserName) {
        WebDriver webDriver;

        if ("Chrome Browser".equals(browserName)) {
            webDriver = new ChromeDriver();
        } else if ("Yandex Browser".equals(browserName)) {
            ChromeOptions options = new ChromeOptions();
            String yandexBinaryPath = System.getProperty("yandex.binary.path");
            if (yandexBinaryPath != null && !yandexBinaryPath.isEmpty()) {
                options.setBinary(yandexBinaryPath);
            } else {
                throw new RuntimeException("Не указан путь к Yandex Browser");
            }
            webDriver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Некорректное имя браузера");
        }
        return webDriver;
    }
}
