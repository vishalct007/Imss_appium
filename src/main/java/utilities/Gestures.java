package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;

public class Gestures {

	
	 AndroidDriver driver;
	 
	 public Gestures(AndroidDriver driver) {
		 this.driver=driver;
	 }
	 
	 
	 public void click(WebElement element) {
		 driver.executeScript("mobile: clickGesture", ImmutableMap.of(
		     "elementId", ((RemoteWebElement) element).getId()
		 ));
	 }
	 
	 
	 
	 public void double_Click(WebElement element) {
		
		 ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
		     "elementId", ((RemoteWebElement) element).getId()
		 ));
	 }
	 
	 
	 
	 public void click_w_r_t_cordinates(int x, int y) {
		 driver.executeScript("mobile: clickGesture", ImmutableMap.of(
		     "x" , x,
		     "y", y
		 ));
	 }
	 
	 
	 
	 public void dragAndDrop(WebElement element , int endx , int endy) {

		 ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		     "elementId", ((RemoteWebElement) element).getId(),
		     "endX", endx,
		     "endY", endy
		 )); 
	 }
	 
	 
	 
	 public void pinchOpen(WebElement element , float percent) {
		 ((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
		     "elementId", ((RemoteWebElement) element).getId(),
		     "percent", percent
		 )); 
	 }
	 
	 
	 
	 
	 public void pinchClose(WebElement element) {
		 
		 ((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
		     "elementId", ((RemoteWebElement) element).getId(),
		     "percent",0.75
		 ));
	 }
	 
	 public void swipeAction(WebElement ele,String direction)
		{
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
					"elementId", ((RemoteWebElement)ele).getId(),
				 
				    "direction", direction,
				    "percent", 0.75
				));
			
			
		}
	 
	 
	 
	 
	 public void scrollIntoView(String an , String av) {
	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollabale(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))"));
	 }
	 
	 public void scrollToText(String text ) {
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
		}
	 
	 
}
