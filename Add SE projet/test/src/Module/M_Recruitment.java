package Module;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import Util.Common;
import Util.ElementLocators;

public class M_Recruitment {
 public void AddCandidate() throws IOException {
                String propFilePath = "Resources//Recruitment.properties";
                Properties prop = Common.LoadPropertiesFile(propFilePath);

                // Click on Recruitment to open screen
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "mnRecruitment"), true).click();

                // Click on Add
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "btnAdd"), true).click();

                // Keyed Data
                Common.LoadWebElement(Common.objDriver, ElementLocators.Name,
                                Common.ReadPropertiesFileKeys(prop, "txtFirstName"), true).sendKeys("Purva");

                Common.LoadWebElement(Common.objDriver, ElementLocators.Name,
                                Common.ReadPropertiesFileKeys(prop, "txtLastName"), false).sendKeys("Sanghvi");

                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "txtEmail"), false).sendKeys("test@gmail.com");

                // Save Record
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "btnSubmit"), false).click();
        }

        public void EditCandidate() throws IOException, AWTException {
                String propFilePath = "Resources//Recruitment.properties";
                Properties prop = Common.LoadPropertiesFile(propFilePath);

                // Click Edit button
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "btnEdit"), true).click();

                // Set JobVacancy
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "ddlJobVacancy"), false).click();
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "ddlJobVacancyOption"), false).click();

                // Set Application Date
                WebElement dpAppDate = Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "dpAppDate"), false);
                dpAppDate.click();
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "dpAppDateClear"), false).click();
                dpAppDate.sendKeys("2024-14-06");

                // Set Censent checkbox
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "chkConsent"), false).click();

                // File upload
                String filePath = "C:\\Users\\purva.sanghvi\\Desktop\\1.txt";
                WebElement btnBrowse = Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "btnFileBrowse"), false);
                Common.fileupload(btnBrowse, filePath);

                // Save Record
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "btnSubmit"), false).click();
        }

        public void ReplaceFile() throws IOException, AWTException {
                String propFilePath = "Resources//Recruitment.properties";
                Properties prop = Common.LoadPropertiesFile(propFilePath);

                // Click Edit button
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "btnEdit"), true).click();

                // WebElement rep = Common.objDriver.findElement(By.xpath("//*[text()='Replace
                // Current']//input[@type='radio']"));
                // rep.click();
                // Common.objDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                // Replace file
                Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "lblReplaceCurrentFile"), true).click();
                                
                String filePath = "C:\\Users\\purva.sanghvi\\Desktop\\New Text Document.txt";
                WebElement btnBrowse = Common.LoadWebElement(Common.objDriver, ElementLocators.Xpath,
                                Common.ReadPropertiesFileKeys(prop, "btnFileBrowse"), false);
                Common.fileupload(btnBrowse, filePath);
        }
}
