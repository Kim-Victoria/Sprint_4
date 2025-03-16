package pageSteps;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FinalConfirmationPage;
import pages.OrderPlacement;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class FinalConfirmationPageSteps {
    private WebDriver driver;
    private FinalConfirmationPage finalConfirmationPage;
    private OrderPlacement orderPlacement;
    private By confirmationOrderQuestion = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Хотите оформить заказ?')]");
    private By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Да')]");
    private By messageOrderConfirmed = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]");

    public FinalConfirmationPageSteps(WebDriver driver) {
        this.driver = driver;
        orderPlacement = new OrderPlacement(driver);
        finalConfirmationPage = new FinalConfirmationPage(driver);
    }
    public void checkOrderConfirmation() {
        WebElement confirmationOrderMessage = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmationOrderQuestion));
        assertTrue(confirmationOrderMessage.isDisplayed());
        driver.findElement(buttonYes).click();
    }

    public void waitForConfirmedOrderMessage() {
        WebElement waitForConfirmedOrderText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(messageOrderConfirmed));
        MatcherAssert.assertThat("Заказ не оформлен", waitForConfirmedOrderText.isDisplayed());
    }
}
