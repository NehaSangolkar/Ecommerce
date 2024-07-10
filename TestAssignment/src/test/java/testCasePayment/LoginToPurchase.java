package testCasePayment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.seleniumUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import purchaseCase.HomePage;
import purchaseCase.Login;
import purchaseCase.PruchasePage;

public class LoginToPurchase extends seleniumUtility {

	WebDriver driver;
	HomePage hmp;
	Login lgn;
	PruchasePage purchaspg;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));;
	
	@Given("open the Browser and hit the URL")
	public void open_the_browser_and_hit_the_url() {
		driver = setUp("chrome", "http://www.automationpractice.pl/index.php");
	}

	@Given("click on the signIn button")
	public void click_on_the_sign_in_button() {

		hmp = PageFactory.initElements(driver, HomePage.class);
		hmp.clickOnSignInBtn();
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "Login - My Shop");
	}

	@When("Enter the {string} and {string}")
	public void enter_the_and(String username, String Password) {
		lgn = PageFactory.initElements(driver, Login.class);
		lgn.login(username, Password);

	}

	@Then("For the {int} successful login user should navigate to the home page")
	public void for_the_successful_login_user_should_navigate_to_the_home_page(int test) {
		String pageTitle = driver.getTitle();
		if(test == 1) {
			assertEquals(pageTitle, "My account - My Shop");
		} else
			assertEquals(pageTitle, "Login - My Shop");
		
		driver.close();

	}

	@Given("open the browser")
	public void open_the_browser() {
		driver = setUp("chrome", "http://www.automationpractice.pl/index.php");

	}

	@Given("Login to the site")
	public void login_to_the_site() throws Throwable {
		hmp = PageFactory.initElements(driver, HomePage.class);
		hmp.clickOnSignInBtn();
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "Login - My Shop");
		lgn = PageFactory.initElements(driver, Login.class);
		lgn.login("tester@test.com", "Tester");
		pageTitle = driver.getTitle();
		assertEquals(pageTitle,"My account - My Shop");
	}

	@When("Search the product {string}")
	public void search_the_product(String string) {
	    hmp.searchProduct("Dress");
	}

	@When("Select the dress")
	public void select_the_dress() {
		hmp.selectTheProduct();
		
	}

	@When("Select the color and size")
	public void select_the_color_and_size() throws InterruptedException {
	   
		hmp.selectColor();
	}

	@When("get the price and the text of the product")
	public void get_the_price_and_the_text_of_the_product() {
		System.out.println(hmp.ProductDetailsName());
		System.out.println(hmp.ProductDetailsDescription());
		System.out.println(hmp.ProductDetailsPrice());
	}

	@When("click to the cart option")
	public void click_to_the_cart_option() throws InterruptedException {
		Thread.sleep(3000);
	   hmp.addToCart();
	   
	}

	@When("click on the process")
	
	public void click_on_the_process() {
		hmp.goToCart();
	}

	@When("Verifi the address by clickin on process")
	public void verifi_the_address_by_clickin_on_process() throws InterruptedException {
		purchaspg = PageFactory.initElements(driver,PruchasePage.class);
		assertEquals(purchaspg.getTheNameAddress(), "Anami SS");
		purchaspg.clickToProcess();
		}
}

	
	
	

