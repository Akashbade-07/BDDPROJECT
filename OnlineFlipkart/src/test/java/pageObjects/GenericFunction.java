package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunction {

	static WebDriver driver;

	public GenericFunction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']") //// *[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
																	//// ////button[contains(text(),'Add to Cart')]
	public static WebElement addToCartButton;

	public static void clickElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			System.out.println("Clicked on the element successfully.");
		} catch (Exception e) {
			System.out.println("Unable to click on the element: " + e.getMessage());
		}
	}

	public static void sendKeysToElement(WebElement element, String keysToSend) {
		try {
			element.clear();
			element.sendKeys(keysToSend);
			System.out.println("Sent keys '" + keysToSend + "' to the element successfully.");
		} catch (Exception e) {
			System.out.println("Unable to send keys to the element: " + e.getMessage());
		}
	}

	public static void waitForElementVisibility(WebElement element, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Element is visible.");
		} catch (Exception e) {
			System.out.println("Element is not visible: " + e.getMessage());
		}
	}
}
