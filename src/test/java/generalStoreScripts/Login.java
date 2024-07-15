package generalStoreScripts;

import static org.testng.Assert.assertEquals;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pom.GeneralStore_LoginPage;
import pom.ProductsPge;




@Listeners(base.ListenersImp.class)
public class Login extends BaseClass {

	@Test
	public void checklogin() {
		
		
			GeneralStore_LoginPage loginPage=new GeneralStore_LoginPage(driver);
			loginPage.loginToApp();
		
		ProductsPge productsPge=new ProductsPge(driver);
		    
		String title=productsPge.getTextTitle();
		 Assert.assertEquals(title, "Products");
	}
	
	
}
