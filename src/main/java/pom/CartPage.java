package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	
	AndroidDriver driver;
	
	
	public CartPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement pageTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedBtn;


	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getProceedBtn() {
		return proceedBtn;
	}
	
	

}
