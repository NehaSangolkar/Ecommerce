package purchaseCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(css = "#email")
	private WebElement userName;
	
	@FindBy(css = "#passwd")
	private WebElement password;
	
	@FindBy(css = "#SubmitLogin")
	private WebElement loginBtn;
	
	
	public void login(String username, String passwrd) {
		userName.sendKeys(username);
		password.sendKeys(passwrd);
		loginBtn.click();
	}

}
