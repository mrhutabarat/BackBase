package testScripts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjectModels.EditPage;
import pageObjectModels.HomePage;
import testData.DataFile;
import testData.DropDownMenu;
import utilities.DriverUtilities;

public class UpdateComputer {
	
	DriverUtilities myDriverUtilities = new DriverUtilities();
	WebDriver driver = myDriverUtilities.getDriver();
	
	@Test
	public void updateExistingComputer() {
		
		driver.get(DataFile.homePageURL);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		Fill out the Search box
		HomePage.searchField(driver).sendKeys(DataFile.computerNameToUpdate);
		HomePage.filterByNameButton(driver).click();
//		Select the top row in the result set of the main table
		WebElement table = HomePage.mainTable(driver);
		WebElement tableRow = table.findElement(By.tagName("tr"));
		WebElement tableColumn = tableRow.findElement(By.tagName("td"));
//		Click on the value of the cell of the first column
		driver.findElement(By.linkText(tableColumn.getText())).click();
		
//		Verify the reading of an existing computer
//		1. Computer name field
		String actualComputerName = EditPage.computerNameField(driver).getAttribute("value");
		Assert.assertEquals(DataFile.computerNameToUpdate, actualComputerName);
//		2. Introduced date field
		String actualIntroducedDate = EditPage.introducedDateField(driver).getAttribute("value");
//		2A. When the assertion is in error (meaning the field is empty),
		try {
			Assert.assertEquals(DataFile.introducedDateToUpdate, actualIntroducedDate);
//		2B. then update the field
		} catch (AssertionError e) {
			EditPage.introducedDateField(driver).sendKeys(DataFile.introducedDateToUpdate);
		}
//		3. Discontinued date field
		String actualDiscontinuedDate = EditPage.discontinuedDateField(driver).getAttribute("value");
//		3A. When the assertion is in error (meaning the field is empty),
		try {
			Assert.assertEquals(DataFile.discontinuedDateToUpdate, actualDiscontinuedDate);
//		3B. then update the field
		} catch (AssertionError e) {
			EditPage.discontinuedDateField(driver).sendKeys(DataFile.discontinuedDateToUpdate);
		}
//		4. Company dropdown menu field
		try {
			Assert.assertEquals(DataFile.companyToUpdate, DropDownMenu.showDropDownResult(driver));
		} catch (AssertionError e) {
			WebElement companyField = EditPage.companyDropdownField(driver);
			Select companyOptionSelect = new Select(companyField);
			companyOptionSelect.selectByVisibleText(DataFile.companyToUpdate);
		}
		
		EditPage.saveThisComputerButton(driver).click();
		
//		Verify the update of an existing computer
		String actualCreationMessage = HomePage.messageBanner(driver).getText();
		Assert.assertEquals(DataFile.expectedMessageToUpdate, actualCreationMessage);

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}