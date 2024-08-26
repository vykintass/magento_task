import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenPage extends BasePage{
    public MenPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css=".categories-menu > ul:nth-of-type(1) > li:nth-of-type(1) > a")
    private WebElement hoodiesAndSweathirtsButton;



    public void clickhoodiesAndSweathirtsButton(){
        hoodiesAndSweathirtsButton.click();
    }

}
