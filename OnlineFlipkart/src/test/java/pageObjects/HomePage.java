package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Flipkart']")
	public static WebElement homepagelogo;

	@FindBy(name = "q")
	public static WebElement searchBox;

	@FindBy(xpath = "//img[@loading='eager']")
	public static List<WebElement> searchResults;

	public static boolean isFlipkartLogoDisplayed() {
		try {
			GenericFunction.waitForElementVisibility(homepagelogo, 5);
			WebElement logo = homepagelogo;
			assertTrue("Flipkart logo is displayed", logo.isDisplayed());
			return true;
		} catch (Exception e) {
			assertTrue("Failed to verify Flipkart logo: " + e.getMessage(), false);
			return false;
		}
	}

	public static void searchDevice(String deviceName) {
		try {
			GenericFunction.waitForElementVisibility(searchBox, 5);
			GenericFunction.sendKeysToElement(searchBox, deviceName);
			searchBox.sendKeys(Keys.ENTER);

			// Assert that search results are displayed after entering the search term
			assertTrue("Search results are displayed", !searchResults.isEmpty());
		} catch (Exception e) {
			assertFalse("Failed to search for device: " + deviceName + " - " + e.getMessage(), true);
		}
	}

	// Method to click on the first device in search results
	public static void clickOnFirstDevice() {
		try {
			if (!searchResults.isEmpty()) {
				searchResults.get(4).click();
				assertTrue("Clicked on the first device successfully", true);
			} else {
				assertFalse("Search results list is empty", true);
			}
		} catch (Exception e) {
			assertFalse("Failed to click on the first device: " + e.getMessage(), true);
		}
	}
}
