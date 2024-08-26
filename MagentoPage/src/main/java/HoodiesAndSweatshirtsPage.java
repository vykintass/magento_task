import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoodiesAndSweatshirtsPage extends BasePage {

    public HoodiesAndSweatshirtsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "page-title-heading")
    private WebElement getSectionName;
    @FindBy(css = ".items.list.product-items.products > li")
    private List<WebElement> getProductsCount;
    @FindBy(css = "div:nth-of-type(4) > .field.limiter > .control > select#limiter")
    private WebElement getPerPageNumber;
    @FindBy(linkText = "Frankie Sweatshirt")
    private WebElement selectOneItem;

    public String getSectionName() {
        return getSectionName.getText();
    }

    public int getProductsCount() {
        return getProductsCount.size();
    }
    public void clickselectedOneItem(){
        selectOneItem.click();
    }

    public int getPerPageNumber() {
        Scroller.scrollToElement(driver, getPerPageNumber);
        String selectedPerPageNumber = getPerPageNumber.getText().trim();  // Trim whitespace

        // Split by spaces or newlines and parse the first number
        String[] numbers = selectedPerPageNumber.split("\\s+");  // Split by any whitespace (spaces, newlines, etc.)

        try {
            return Integer.parseInt(numbers[0]);  // Assuming the first number is what you need
        } catch (NumberFormatException e) {
            throw new RuntimeException("Failed to parse per page number: " + selectedPerPageNumber, e);
        }
    }

}
