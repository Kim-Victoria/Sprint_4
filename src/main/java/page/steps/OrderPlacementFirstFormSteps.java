package page.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OrderPlacement;

import java.time.Duration;

public class OrderPlacementFirstFormSteps {
    private WebDriver driver;
    private OrderPlacement orderPlacement;
    private By buttonOnTop = By.xpath(".//button[@class='Button_Button__ra12g' and contains(text(),'Заказать')]"); // кнопка Заказать в шапке страницы
    private By buttonOnBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Заказать')]");
    private By orderForm = By.className("Order_Content__bmtHS"); // первая форма для заказа
    private By nameField = By.xpath(".//input[contains(@placeholder,'* Имя')]"); // поле Имя
    private By surnameField = By.xpath(".//input[contains(@placeholder, '* Фамилия')]"); // поле Фамилия
    private By addressField = By.xpath(".//input[contains(@placeholder, '* Адрес: куда привезти заказ')]"); // поле Адрес
    private By metroStationDropDown = By.xpath(".//input[contains(@placeholder, '* Станция метро')]"); // выпадающий список Станция метро
    private By selectedMetroStation = By.xpath(".//div[@class='select-search__select']//li[1]");
    private By phoneNumberField = By.xpath(".//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]"); // поле Телефон
    private By continueButton = By.xpath(".//button[text()='Далее']"); // кнопка Далее

    public OrderPlacementFirstFormSteps(WebDriver driver) {
        this.driver = driver;
        orderPlacement = new OrderPlacement(driver);
    }

    public void clickOrderButton(String orderButton) {
        if (orderButton.equals("buttonOnTop")) {
            driver.findElement(buttonOnTop).click();
        } else if (orderButton.equals("buttonOnBottom")) {
            WebElement element = driver.findElement(buttonOnBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        driver.findElement(buttonOnBottom).click();
    }
    }

    public void clickOrderButtonOnBottom(String buttonOnBottom) {

        driver.findElement(By.xpath(buttonOnBottom)).click();
    }
    public void waitForOrderForm() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderForm));
        driver.findElement(orderForm).click();
    }

    public void setUsername(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void clickMetroStation(String metroStation) {
        driver.findElement(metroStationDropDown).click();
        driver.findElement(metroStationDropDown).sendKeys(metroStation);
        WebElement selectedStation = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(selectedMetroStation));
        selectedStation.click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        WebElement element = driver.findElement(continueButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        driver.findElement(continueButton).click();
    }

    public void fillFirstFormForOrder(String username, String surname, String address,String metroStation, String phoneNumber){
        setUsername(username);
        setSurname(surname);
        setAddress(address);
        clickMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        clickContinueButton();
    }
}
