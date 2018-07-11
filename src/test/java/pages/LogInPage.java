package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement emailEnterBox;
	

	@FindBy(xpath="//input[@id='passwd']")
	public WebElement passEnterBox;
	
	@FindBy(id="SubmitLogin")
	public WebElement buttonSignIn;
	
	public void login(String username, String passsword) {
		emailEnterBox.sendKeys(username);
		passEnterBox.sendKeys(passsword);
		buttonSignIn.click();
	}
}
