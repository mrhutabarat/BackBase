package testScripts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjectModels.EditPage;
import pageObjectModels.HomePage;
import testData.DataFile;
import utilities.DriverUtilities;

public class DeleteComputer {
	
	DriverUtilities myDriverUtilities = new DriverUtilities();
	WebDriver driver = myDriverUtilities.getDriver();
	
	@Test
	public void deleteExistingComputer() {
		
		driver.get(DataFile.homePageURL);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		Fill out the Search box
		HomePage.searchField(driver).sendKeys(DataFile.computerNameToDelete);
		HomePage.filterByNameButton(driver).click();
//		Select the top row in the result set of the main table
		WebElement table = HomePage.mainTable(driver);
		WebElement tableRow = table.findElement(By.tagName("tr"));
		WebElement tableColumn = tableRow.findElement(By.tagName("td"));
//		Click on the value of the cell of the first column
		driver.findElement(By.linkText(tableColumn.getText())).click();
		
		EditPage.deleteThisComputerButton(driver).click();
		
//		Verify the creation of a new computer
		String actualDeletionMessage = HomePage.messageBanner(driver).getText();
		Assert.assertEquals(DataFile.expectedMessageToDelete, actualDeletionMessage);

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}