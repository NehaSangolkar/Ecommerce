package purchaseCase;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.seleniumUtility;

public class HomePage extends seleniumUtility {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	@FindBy(css = ".login")
	private WebElement signInBtn;

	@FindBy(id = "search_query_top")
	private WebElement searchBar;

	@FindBy(css = "button[name = submit_search]")
	private WebElement searchicon;

	@FindBy(xpath = "(//a[@title='Printed Dress'])[1]")
	private WebElement selectDress;

	@FindBy(css = "h1[itemprop='name']")
	private WebElement dressName;

	@FindBy(id = "short_description_content")
	private WebElement dressDetails;

	@FindBy(css = "#our_price_display")
	private WebElement priceOfDress;
	
	@FindBy(css = "a[name='Pink']")
	private WebElement color;
	
	@FindBy(xpath = "//span[text() = 'Add to cart']" )
	private WebElement addCart;
	
	@FindBy(xpath = "//b[text() = 'Cart']")
	private WebElement cart;
	
	@FindBy(xpath = "//body")
	private WebElement body;
	

	public void searchProduct(String search) {
		searchBar.sendKeys(search);
		searchicon.click();
	}

	public void clickOnSignInBtn() {
		signInBtn.click();
	}

	public void selectTheProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(selectDress));
		selectDress.click();

	}

	public String ProductDetailsName() {
		String productName = dressName.getAttribute("innerText");
		return productName;
	}

	public String ProductDetailsDescription() {
		String ProductDescription = dressDetails.getAttribute("innerText");
		return ProductDescription;
	}

	public String ProductDetailsPrice() {
		String ProductPrice = priceOfDress.getAttribute("innerText");
		return ProductPrice;
	}
	
	public void selectColor() throws InterruptedException {
		
		body.sendKeys(Keys.DOWN);
		body.sendKeys(Keys.DOWN);
		body.sendKeys(Keys.DOWN);
		body.sendKeys(Keys.DOWN);
		body.sendKeys(Keys.DOWN);
		body.sendKeys(Keys.DOWN);
wait.until(ExpectedConditions.elementToBeClickable(color));
color.click();
		Thread.sleep(5000);

	}
	
	public void addToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addCart));
		addCart.click();
	}
	
	public void goToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		cart.click();
	}
}
