package page.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OrderPlacement;

import java.time.Duration;

public class OrderPlacementSecondFormSteps {
    private WebDriver driver;
    private OrderPlacement orderPlacement;

    private By secondOrderForm = By.className("Order_Header__BZXOb"); // форма "Про аренду"
    private By orderDate = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]"); // поле "Когда привезти самокат"
    private By selectedDate = By.xpath(".//div[contains(@aria-label, 'Choose четверг, 27-е марта 2025 г.')]"); // выбранная дата в поле "Когда привезти самокат"
    private By orderPeriod = By.xpath("//div[@class='Dropdown-placeholder' and contains(text(), '* Срок аренды')]"); // выпадающий список "Срок аренды"
    private By selectedPeriodOfOrder = By.xpath("//div[@class='Dropdown-option' and contains(text(), 'сутки')]"); // выбранный вариант "двое суток" из выпадающего списка "Срок аренды"
    private By scooterColour = By.xpath("//input[@id='black']");  // выбранный цвет "черный" в чек-боксе "Цвет самоката"
    private By commentsToOrder = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]"); // поле "Комментарий для курьера"
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Заказать')]"); // кнопка "Заказать" в форме "Про аренду"

    public OrderPlacementSecondFormSteps(WebDriver driver) {
        this.driver = driver;
        orderPlacement = new OrderPlacement(driver);
    }
    public void waitForSecondOrderForm() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(secondOrderForm));
    }
    public void selectOrderDate() {
        driver.findElement(orderDate).click();
        WebElement selectedOrderDate = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(selectedDate));
        selectedOrderDate.click();
    }
    public void selectPeriodOfRent() {
        driver.findElement(orderPeriod).click();
        WebElement selectedPeriodOfRent = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(selectedPeriodOfOrder));
        selectedPeriodOfRent.click();
    }
    public void selectColourOfScooter() {
        driver.findElement(scooterColour).click();
    }
    public void putCommentToOrder(String comment) {
        driver.findElement(commentsToOrder).sendKeys(comment);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void fillSecondFormForOrder(String comment) {
        waitForSecondOrderForm();
        selectOrderDate();
        selectPeriodOfRent();
        selectColourOfScooter();
        putCommentToOrder(comment);
    }
}
