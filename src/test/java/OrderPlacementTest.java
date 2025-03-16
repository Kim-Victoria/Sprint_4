import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageSteps.*;

@RunWith(Parameterized.class)
public class OrderPlacementTest extends BaseTest {
    private final String buttonLocation;
    private final String username;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String comments;

    public OrderPlacementTest(String buttonLocation, String username, String surname, String address, String metroStation, String phoneNumber, String comments) {
        this.buttonLocation = buttonLocation;
        this.username = username;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.comments = comments;
    }

    @Parameterized.Parameters
    public static Object[][] checkText() {
        return new Object[][]{
                {"buttonOnTop", "Мария", "Иванова", "Ленина,3", "Охотный ряд", "+7900000000", "Нужен самокат с полным аккумулятором"},
                {"buttonOnBottom", "Анна", "Петрова", "Вернадского, 66", "Полежаевская", "+7800123456", ""}
        };
    }

    @Test
    public void OrderPlacementTest() {
        // открываем главную страницу
        MainPageSteps objMainPageSteps = new MainPageSteps(driver);
        objMainPageSteps.openPage();
        objMainPageSteps.closeCookies();
        // заполняем первую форму оформления заказа
        OrderPlacementFirstFormSteps objOrderPlacementSteps = new OrderPlacementFirstFormSteps(driver);
        objOrderPlacementSteps.clickOrderButton(buttonLocation);
        objOrderPlacementSteps.waitForOrderForm();
        objOrderPlacementSteps.fillFirstFormForOrder(username, surname, address, metroStation, phoneNumber);
        // заполняем вторую форму оформления заказа
        OrderPlacementSecondFormSteps objOrderPlacementSteps1 = new OrderPlacementSecondFormSteps(driver);
        objOrderPlacementSteps1.fillSecondFormForOrder(comments);
        objOrderPlacementSteps1.clickOrderButton();
        // подтверждаем размещение заказа во всплывающем окне
        FinalConfirmationPageSteps objOrderConfirmationPage = new FinalConfirmationPageSteps(driver);
        objOrderConfirmationPage.checkOrderConfirmation();
        // ожидаем появления окна с подтверждением заказа
        objOrderConfirmationPage.waitForConfirmedOrderMessage();
    }
}
