package testScripts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjectModels.EditPage;
import pageObjectModels.HomePage;
import testData.DataFile;
import testData.DropDownMenu;
import utilities.DriverUtilities;

public class _02_ReadComputer {
	
	DriverUtilities myDriverUtilities = new DriverUtilities();
	WebDriver driver = myDriverUtilities.getDriver();
	
	@Test
	public void readExistingComputer() {
		
		driver.get(DataFile.homePageURL);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		Verify the Main page
		try {
			HomePage.mainTable(driver).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("This is not main page.");
			driver.quit();
		}
		
//		Fill out the Search box
		HomePage.searchField(driver).sendKeys(DataFile.computerNameToRead);
		HomePage.filterByNameButton(driver).click();
//		Select the top row in the result set of the main table
		WebElement table = HomePage.mainTableNoHeader(driver);
		WebElement tableRow = table.findElement(By.tagName("tr"));
		WebElement tableColumn = tableRow.findElement(By.tagName("td"));
//		Click on the value of the cell of the first column
		driver.findElement(By.linkText(tableColumn.getText())).click();
		
//		Verify the Edit page
		String actualHeader = EditPage.headerBanner(driver).getText();
		Assert.assertEquals(DataFile.expectedHeaderBanner, actualHeader);
		
//		Verify the small table
		try {
			EditPage.smallTable(driver).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Table does not exist.");
		}
		
//		Verify the reading of an existing computer
//		1. Computer name field
		String actualComputerName = EditPage.computerNameField(driver).getAttribute("value");
		Assert.assertEquals(DataFile.computerNameToRead, actualComputerName);
//		2. Introduced date field
		String actualIntroducedDate = EditPage.introducedDateField(driver).getAttribute("value");
		Assert.assertEquals(DataFile.introducedDateToRead, actualIntroducedDate);
//		3. Discontinued date field
		String actualDiscontinuedDate = EditPage.discontinuedDateField(driver).getAttribute("value");
		Assert.assertEquals(DataFile.discontinuedDateToRead, actualDiscontinuedDate);
//		4. Company dropdown menu field
		Assert.assertEquals(DataFile.companyToRead, DropDownMenu.showDropDownResult(driver));
		
		EditPage.cancelButton(driver).click();
		
//		Verify main table on main page
		try {
			HomePage.mainTable(driver).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("This is not main page.");
		}

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
