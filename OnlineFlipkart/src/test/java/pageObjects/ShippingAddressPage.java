package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {
	WebDriver driver;

	public ShippingAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[contains(text(),'Change')])[2]")
	public WebElement addressChangeButton;

	@FindBy(xpath = "//button[contains(text(),'EDIT')]")
	public WebElement addressEditButton;

	@FindBy(xpath = "//input[@name='name']")
	public WebElement name;

	@FindBy(xpath = "//input[@name='phone']")
	public WebElement phone;

	@FindBy(xpath = "//input[@name='pincode']")
	public WebElement pincode;

	@FindBy(xpath = "//input[@name='addressLine2']")
	public WebElement addressLine2;

	@FindBy(xpath = "//textarea[@name='addressLine1']")
	public WebElement addressLine1;

	@FindBy(xpath = "//input[@name='city']")
	public WebElement city;

	@FindBy(xpath = "//button[contains(text(),'Save and Deliver Here')]")
	public WebElement saveandDeliverButton;

	public void enterAddress() {
		GenericFunction.waitForElementVisibility(addressChangeButton, 10);
		GenericFunction.clickElement(addressChangeButton);
		GenericFunction.waitForElementVisibility(addressEditButton, 5);
		GenericFunction.clickElement(addressEditButton);
		GenericFunction.waitForElementVisibility(name, 5);
		GenericFunction.sendKeysToElement(phone, "akash bade");
		GenericFunction.waitForElementVisibility(phone, 5);
		GenericFunction.sendKeysToElement(phone, "9403981172");
		GenericFunction.waitForElementVisibility(pincode, 5);
		GenericFunction.sendKeysToElement(pincode, "414502");
		GenericFunction.waitForElementVisibility(addressLine2, 5);
		GenericFunction.sendKeysToElement(addressLine2, "shevgaon");
		GenericFunction.waitForElementVisibility(city, 5);
		GenericFunction.sendKeysToElement(city, "shevgaon");
		GenericFunction.waitForElementVisibility(saveandDeliverButton, 5);
		GenericFunction.clickElement(saveandDeliverButton);

	}

}
