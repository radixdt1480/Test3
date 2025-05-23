package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Common {
	public static WebDriver objDriver = null;

	public static void InitializedBrowser() {
		try 
		{
			Properties prop;
			prop = LoadPropertiesFile("src/Resources//InitBrowser.properties");

			System.setProperty(ReadPropertiesFileKeys(prop, "webDriver_Name"), ReadPropertiesFileKeys(prop, "webDriver_Path"));

			objDriver = new FirefoxDriver();
			objDriver.manage().window().maximize();

			objDriver.get(Common.ReadPropertiesFileKeys(prop, "WebURL"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static String ReadPropertiesFileKeys(Properties prop, String key) throws IOException {
		return prop.getProperty(key);
	}

	public static Properties LoadPropertiesFile(String filePath) throws IOException {
		Properties prop = null;

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static WebElement LoadWebElement(WebDriver driver, ElementLocators locator, String elementPath,
			boolean isWaitRequired) {
		WebElement webElement = null;
		if (isWaitRequired) {
			// implicit Wait
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Explicit Wait
			webElement = ExplicitWaitTillElementIsLoad(driver, locator, elementPath);

			// Fluent Wait
			// webElement = FluentWaitTillElementIsLoad(driver, locator, elementPath);
		} else {
			webElement = LoadElement(driver, locator, elementPath);
		}
		return webElement;
	}

	public static void Screenshot(WebDriver driver) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(".\\Screenshots");

		FileUtils.copyFileToDirectory(SrcFile, DestFile);
	}

	static WebElement ExplicitWaitTillElementIsLoad(WebDriver driver, ElementLocators locator, String elementPath) {
		WebElement webElement = null;

		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locator) {
			case Name:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementPath)));
				break;
			case Xpath:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementPath)));
				break;
			case Class:
				break;
			case CssSelectors:
				break;
			case ID:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementPath)));
				break;
			case LinkText:
				break;
			case PartialLinkText:
				break;
			case TagName:
				break;
			default:
				break;
		}

		return webElement;
	}

	static WebElement LoadElement(WebDriver driver, ElementLocators locator, String elementPath) {
		WebElement webElement = null;

		switch (locator) {
			case Name:
				webElement = driver.findElement(By.name(elementPath));
				break;
			case Xpath:
				webElement = driver.findElement(By.xpath(elementPath));
				break;
			case Class:
				break;
			case CssSelectors:
				break;
			case ID:
				webElement = driver.findElement(By.id(elementPath));
				break;
			case LinkText:
				break;
			case PartialLinkText:
				break;
			case TagName:
				break;
			default:
				break;
		}
		return webElement;
	}

	public static void fileupload(WebElement element, String fileToUpload) throws AWTException 
	{
		//Click Browse button
		element.click();
		
		// copying File path to Clipboard
		StringSelection selection = new StringSelection(fileToUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot = new Robot();
		robot.delay(1000);
 
 		// Press Control + V to paste the file path
 		robot.keyPress(KeyEvent.VK_CONTROL);
 		robot.keyPress(KeyEvent.VK_V);
 		robot.keyRelease(KeyEvent.VK_V);
 		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter to confirm
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);		
	}


}
