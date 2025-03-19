import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }
    public void startBrowserFirefox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
    }

@Before
public void initBrowser() {
    String browser = System.getProperty("browser", "chrome");
    if (browser.equals("chrome")) {
        startBrowserChrome();
    } else if (browser.equals("firefox")) {
        startBrowserFirefox();
    }
    driver.get(BASE_URL);
    driver.findElement(By.id("rcc-confirm-button")).click();
}

@After
public void tearDownBrowser() {
    WebDriverManager.chromedriver().setup();
    driver.quit();
}
}
