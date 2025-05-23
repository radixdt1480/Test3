package Module;

import java.io.IOException;
import java.util.Properties;

import Util.Common;
import Util.ElementLocators;

public class M_Login {
public void OrangeHRMLogin() throws IOException
	{
		Common.InitializedBrowser();		

		String propFilePath = "src//Resources//Login.properties";
		Properties prop = Common.LoadPropertiesFile(propFilePath);
		
		//System.setProperty(Common.ReadPropertiesFileKeys(prop, "webDriver_Name"),Common.ReadPropertiesFileKeys(prop, "webDriver_Path"));
		
		//Common.objDriver.get(Common.ReadPropertiesFileKeys(prop, "WebURL"));
		
		Common.LoadWebElement(Common.objDriver, ElementLocators.Name, Common.ReadPropertiesFileKeys(prop, "userName_XPath"), true).sendKeys(Common.ReadPropertiesFileKeys(prop, "userName_Value"));		
		Common.LoadWebElement(Common.objDriver, ElementLocators.Name, Common.ReadPropertiesFileKeys(prop, "psw_XPath"), false).sendKeys(Common.ReadPropertiesFileKeys(prop, "psw_Value"));
		
		//Common.Screenshot(Common.objDriver);
		
		Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath, Common.ReadPropertiesFileKeys(prop, "btnLogin_XPath"), false).click();
		
		//String dashboadURL = driver.getCurrentUrl();
		//System.out.print("Current Page URL : " + dashboadURL + "\n");
		//String result = dashboadURL.contains("dashboard") ? "Passed" : "Failed";
		//System.out.print(result + "\n");
	}
}
