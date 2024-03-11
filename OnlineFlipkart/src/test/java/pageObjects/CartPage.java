package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;

public class CartPage {

	static WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")

	public static WebElement addToCartButton;

	@FindBy(xpath = "//span[contains(text(),'Place Order')]")

	public static WebElement placeOrderbutton;

	@FindBy(xpath = "//span[contains(text(),'Login or Signup')]")
	public static WebElement Sighup;

	public static void addToCart() throws InterruptedException {
		try {
			GenericFunction.waitForElementVisibility(addToCartButton, 30);
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			Thread.sleep(3000);
			// Assert that the "Add to Cart" operation was successful
			assertTrue("Product is added to the cart", isProductAddedToCart());
		} catch (Exception e) {
			assertTrue("Failed to add product to the cart: " + e.getMessage(), false);
		}
	}

	public void placeOrder() throws InterruptedException {
		try {
			GenericFunction.waitForElementVisibility(placeOrderbutton, 10);
			placeOrderbutton.click();
			// Assert that the order is successfully placed
			assertTrue("Order is successfully placed", isOrderPlaced());
		} catch (Exception e) {
			assertTrue("Failed to place the order: " + e.getMessage(), false);
		}
	}

	public static boolean isProductAddedToCart() {
		try {

			GenericFunction.waitForElementVisibility(placeOrderbutton, 30);
			return placeOrderbutton.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}

	public boolean isOrderPlaced() {
		try {
			return Sighup.isDisplayed();
		} catch (NoSuchElementException e) {

			return false;
		}
	}

}
