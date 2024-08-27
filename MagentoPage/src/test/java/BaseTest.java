import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected  HomePage homePage;
    protected MenPage menPage;
    protected HoodiesAndSweatshirtsPage hoodiesAndSweatshirtsPage;
    protected FrankieSweatshirtPage frankieSweatshirtPage;
    protected ShoppingCartPage shoppingCartPage;
    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        menPage = new MenPage(driver);
        hoodiesAndSweatshirtsPage = new HoodiesAndSweatshirtsPage(driver);
        frankieSweatshirtPage = new FrankieSweatshirtPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://magento.softwaretestingboard.com/");
        
    }
    @AfterEach
    void tearDown(){
    //    driver.quit();
    }
}
