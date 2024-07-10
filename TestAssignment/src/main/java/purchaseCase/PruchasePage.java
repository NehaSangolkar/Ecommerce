package purchaseCase;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruchasePage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	

	@FindBy(xpath = "(//span[@class = 'address_name'])[1]")
	private WebElement adderss;

	@FindBy(xpath = "//span[text() = 'Proceed to checkout']")
	private WebElement processed;

	@FindBy(css = "(//span[@class='checked'])[1]")
	private WebElement checkbox;

	@FindBy(css = "a[title= 'Pay by check.']")
	private WebElement paymentOption;

	@FindBy(xpath = "//span[text() = 'I confirm my order']")
	private WebElement orderConfirm;

	@FindBy(xpath = "//p[text() = 'Your order on My Shop is complete.']")
	private WebElement success;

	@FindBy(css = "button[name='submit_search']")
	private WebElement checkout;

	@FindBy(xpath = "//body")
	private WebElement body;

	public String getTheNameAddress() {
		return adderss.getAttribute("innerText");
	}

	public void clickToProcess() {
		body.sendKeys(Keys.END);
		wait.until(ExpectedConditions.elementToBeClickable(processed));

		processed.click();
	}


}
