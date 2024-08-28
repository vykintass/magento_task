import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPage extends BasePage{

    public WomenPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="ul:nth-of-type(2) > li:nth-of-type(1) > a")
    private WebElement pantsButton;

    public void clickPantsButton(){
        pantsButton.click();
    }
}
