package stepDefinations;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.GenericFunction;
import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.ShippingAddressPage;
import java.util.logging.Logger;

public class Steps {
	public WebDriver driver;
	public Loginpage lp;
	public HomePage hp;
	public CartPage cp;
	public ShippingAddressPage ca;
	private String mainWindowHandle;
	private static final Logger LOGGER = Logger.getLogger(Steps.class.getName());
	@Given("the user opens the flipkart {string} website")
	public void the_user_opens_the_flipkart_website(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new Loginpage(driver);
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		mainWindowHandle = driver.getWindowHandle();
		// driver.quit();
	}

	@When("verify homepage")
	public void verify_homepage() throws InterruptedException {
		hp = new HomePage(driver);
		assertTrue(HomePage.isFlipkartLogoDisplayed());
		LOGGER.info("home page verified successfully");
	}

	@When("the user searches for a device {string} and verify device details")
	public void the_user_searches_for_a_device_and_verify_device_details(String deviceName) {
		hp = new HomePage(driver);
		HomePage.searchDevice(deviceName);
		HomePage.clickOnFirstDevice();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
	}

	@When("adds the device to the cart")
	public void adds_the_device_to_the_cart() throws InterruptedException {
		Thread.sleep(3000);
		cp = new CartPage(driver);
		Thread.sleep(3000);
		CartPage.addToCart();
		Thread.sleep(3000);
		//CartPage.placeOrder();
		
		
		/*
		 * Thread.sleep(3000); WebElement element =
		 * driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		 * Thread.sleep(3000); Actions actions = new Actions(driver);
		 * actions.moveToElement(element).click().perform();
		 */
		 
		 
	}

	@When("proceeds to checkout page and verify checkout page")
	public void proceeds_to_checkout_page_and_verify_checkout_page() throws InterruptedException {
		cp=new CartPage(driver);
		Thread.sleep(3000);
		ca=new ShippingAddressPage(driver);
		Thread.sleep(3000);
		cp.placeOrder();
		Thread.sleep(3000);
		ca.enterAddress();
		//Thread.sleep(13000);
	}
	@When("completes the checkout process without placing the order")
	public void completes_the_checkout_process_without_placing_the_order() {
	   
	}

	@Then("verify that the user has navigated through the checkout process successfully")
	public void verify_that_the_user_has_navigated_through_the_checkout_process_successfully() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}


}
