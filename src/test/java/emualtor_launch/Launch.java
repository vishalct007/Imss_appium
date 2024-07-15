package emualtor_launch;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Launch {
	
AppiumDriverLocalService service;
	
	
	@BeforeSuite
	public void startServer() {
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	
	@AfterSuite
	public void endServer() {
		service.stop();
	}
	
	
	@Test
	public void start() throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("automationName","uiautomator2");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME , "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME , "pixel");
		dc.setCapability(MobileCapabilityType.UDID , "emulator-5554");
		dc.setCapability("app","C:\\Users\\vishal\\Downloads\\General-Store.apk");
		//dc.setCapability("appActivity",".SplashActivity");
		//dc.setCapability("noReset", "true");
		
		URL url =new URL("http://127.0.0.1:4723");
		
		 AndroidDriver driver=new AndroidDriver(url,dc);
		
		
	}
	
	
}


