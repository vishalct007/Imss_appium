package pom;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Gestures;


public class GeneralStore_LoginPage {

	AndroidDriver driver;

	public GeneralStore_LoginPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement selectCountry;

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nametxtField;

	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale") 
	private WebElement maleradioBtn;


	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleradioBtn;


	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShpBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='India']")
	private WebElement indiacountry;




	public WebElement getSelectCountry() {
		return selectCountry;
	}

	
	public WebElement getNametxtField() {
		return nametxtField;
	}

	public WebElement getMaleradioBtn() {
		return maleradioBtn;
	}

	

	public WebElement getFemaleradioBtn() {
		return femaleradioBtn;
	}

	
	public WebElement getLetsShpBtn() {
		return letsShpBtn;
	}

	
	public WebElement getIndiacountry() {
		return indiacountry;
	}

	public void loginToApp() {
		selectCountry.click();
		Gestures gesture=new Gestures(driver);
		  gesture.scrollToText("India");
		 indiacountry.click();
		 nametxtField.sendKeys("vishal");
		 letsShpBtn.click();
	}





}
