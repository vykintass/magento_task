import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li#shipping > .step-title")
    private WebElement getShippingPageName;
    @FindBy(id = "customer-email")
    private WebElement emailField;
    @FindBy(css = "input[name='firstname']")
    private WebElement firstnameField;
    @FindBy(name = "lastname")
    private WebElement lastnameField;
    @FindBy(css = "input[name='street[0]']")
    private WebElement addressField;
    @FindBy(css = "input[name='city']")
    private WebElement cityField;
    @FindBy(name = "postcode")
    private WebElement postalCodeField;
    @FindBy(css = "input[name='telephone']")
    private WebElement phoneNumberField;
    @FindBy(css = "div#shipping-new-address-form select[name='region_id']")
    private WebElement provinceField;
    @FindBy(css = "select#BTJ0IYA")
    private WebElement selectCountryDropDownList;
    @FindBy(css="tr:nth-of-type(2) > td:nth-of-type(1)")
    private WebElement selectShippingMethod;
    @FindBy(css= ".continue")
    private WebElement nextButton;
    @FindBy(css="div#checkout-payment-method-load .step-title")
    private WebElement getPaymentPageText;
    @FindBy(xpath = "//button[@title='Place Order']")
    private WebElement placeOrderButton;
    @FindBy(css=".base")
    private WebElement confirmationText;


    public String getPageName() {
        return getShippingPageName.getText();
    }

    public static String generateEmail() {

        Random random = new Random();
        int randomNumber = random.nextInt((int) Math.pow(10, 3)); // Generate a number with 3 digits
        String randomEmail = String.format("test%03d@mail.com", randomNumber); // Format with leading zeros if needed
        return randomEmail;
    }

    public void inputEmailField() {
        String randomEmail = generateEmail();
        emailField.sendKeys(randomEmail);
    }
    public WebElement getEmailField() {
        return emailField;
    }

    public void inputFirstnameField(String firstname) {
        firstnameField.sendKeys(firstname);
    }

    public void inputLastnameField(String lastname) {
        lastnameField.sendKeys(lastname);
    }

    public void inputAddressField(String address) {
        addressField.sendKeys(address);
    }

    public void inputCityField(String city) {
        cityField.sendKeys(city);
    }

    public void inputPostalCodeField(String postalcode) {
        postalCodeField.sendKeys(postalcode);
    }

    public void inputPhoneNumberField(String number) {
        phoneNumberField.sendKeys(number);
    }

    public void inputProvinceField(String province) {
        Scroller.scrollToElement(driver, provinceField);
        provinceField.sendKeys(province);
    }
    public void clickSelectShippingMethod(){
        selectShippingMethod.click();
    }
    public void clickNextButton(){
        nextButton.click();
    }
    public String getPaymentPageText(){
        return getPaymentPageText.getText();
    }
    public void clickPlaceOrderButton() {
        WebElement paymentMethod = driver.findElement(By.cssSelector("li.checkout-payment-method"));
        paymentMethod.click();  // or interact with it as needed
        WebElement placeOrderButton = driver.findElement(By.xpath("//button[@title='Place Order']"));
        placeOrderButton.click();
    }
    public boolean checkConfirmationText(){

        return confirmationText.isDisplayed();
    }
    public String getConfirmationText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //
        By confirmationTextLocator = By.cssSelector(".base");
        WebElement confirmationTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationTextLocator));
        return confirmationTextElement.getText();
    }

}
