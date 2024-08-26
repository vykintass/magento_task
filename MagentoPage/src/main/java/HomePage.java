import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Men")
    private WebElement menCategoryButton;

    public void clickMenCategoryButton(){
        menCategoryButton.click();
    }
}
