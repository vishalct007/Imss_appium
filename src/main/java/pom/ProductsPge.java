package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPge {
	
	AndroidDriver driver;
	
	public ProductsPge(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement pageTitle;
	
	
	@AndroidFindBy(xpath="android.widget.TextView[@text='Air Jordan 4 Retro']/parent::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")
	private WebElement addtoCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartBtn;

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getAddtoCart() {
		return addtoCart;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}
	public String getTextTitle() {
		return pageTitle.getText();
	}
}
