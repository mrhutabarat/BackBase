package testScripts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjectModels.EditPage;
import pageObjectModels.HomePage;
import testData.DataFile;
import utilities.DriverUtilities;

public class _01_CreateComputer {

	DriverUtilities myDriverUtilities = new DriverUtilities();
	WebDriver driver = myDriverUtilities.getDriver();
	
	@Test
	public void createNewComputer() {
		
		driver.get(DataFile.homePageURL);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		HomePage.addComputer(driver).click();
		
//		Fill out the form
//		1. Computer name field
		EditPage.computerNameField(driver).sendKeys(DataFile.computerNameToCreate);
//		2. Introduced date field
		EditPage.introducedDateField(driver).sendKeys(DataFile.introducedDateToCreate);
//		3. Discontinued date field
		EditPage.discontinuedDateField(driver).sendKeys(DataFile.discontinuedDateToCreate);
//		4. Company dropdown menu field
		WebElement companyField = EditPage.companyDropdownField(driver);
		Select companyOptionSelect = new Select(companyField);
		companyOptionSelect.selectByVisibleText(DataFile.companyToCreate);
		
		EditPage.createThisComputerButton(driver).click();
		
//		Verify the creation of a new computer
		String actualCreationMessage = HomePage.messageBanner(driver).getText();
		Assert.assertEquals(DataFile.expectedMessageToCreate, actualCreationMessage);

	}
	
//	@After
//	public void tearDown() {
//		driver.quit();
//	}

}