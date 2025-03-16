package pageSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPageSteps {
    private WebDriver driver;
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
    }
// открытие главной страницы Яндекс.Самокат
    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    // закрытие окна Cookies
    public void closeCookies() {
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
}