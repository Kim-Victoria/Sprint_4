import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }
    public void startBrowserFirefox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
    }

@Before
public void initBrowser() {
    String browser = System.getProperty("browser", "chrome");
    if (browser.equals("chrome")) {
        startBrowserChrome();
    } else if (browser.equals("firefox")) {
        startBrowserFirefox();
    }
}

@After
public void tearDownBrowser() {
    WebDriverManager.chromedriver().setup();
    driver.quit();
}
}
