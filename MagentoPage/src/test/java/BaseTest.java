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
    protected MenHoodiesAndSweatshirtsPage hoodiesAndSweatshirtsPage;
    protected MenFrankieSweatshirtPage frankieSweatshirtPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutPage checkoutPage;
    protected WomenPage womenPage;
    protected WomenPantsPage womenPantsPage;
    protected WomenKarmenYogaPantsPage womenKarmenYogaPantsPage;

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        menPage = new MenPage(driver);
        hoodiesAndSweatshirtsPage = new MenHoodiesAndSweatshirtsPage(driver);
        frankieSweatshirtPage = new MenFrankieSweatshirtPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        womenPage = new WomenPage(driver);
        womenPantsPage = new WomenPantsPage(driver);
        womenKarmenYogaPantsPage = new WomenKarmenYogaPantsPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://magento.softwaretestingboard.com/");
        
    }
    @AfterEach
    void tearDown(){
    //    driver.quit();
    }
}
