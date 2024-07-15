package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import pom.GeneralStore_LoginPage;

 public class BaseClass {
	AppiumDriverLocalService server;
	public static AndroidDriver driver;
	 
	
	public static AppiumDriverLocalService getService(int port) {
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(port).withLogFile(new File("../imss_appium/Logs/ServerLogs.txt"))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE));
	}
	
	
	@BeforeSuite
	public void startServer() {
		server=getService(4723);
		server.start();
		server.clearOutPutStreams();
	}
	
	
	@AfterSuite
	public void endServer() {
		server.stop();
	}
	 
	
	@BeforeClass
	public void launchApp() throws MalformedURLException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("automationName","uiautomator2");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME , "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME , "Redmi Note 8");
		dc.setCapability(MobileCapabilityType.UDID , "5123aee1");
		dc.setCapability("appPackage","com.androidsample.generalstore");
		dc.setCapability("appActivity",".SplashActivity");
		dc.setCapability("noReset", "true");
		
		URL url =new URL("http://127.0.0.1:4723");
		
		  driver=new AndroidDriver(url,dc);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15 ));
		
	 }
	
	
	
	@AfterClass
	public void closeApp() {
		driver.terminateApp("com.androidsample.generalstore");
	}
	
	
	
	
	public static String takescreenshot(String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\vishal\\eclipse-workspace\\imss_appium\\screenshots\\" + name + ".png";
		File dest = new File(path);
		Files.copy(src,dest);
		return path;
	

	}	

}
