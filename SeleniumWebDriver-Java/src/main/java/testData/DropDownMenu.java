package testData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjectModels.EditPage;

public class DropDownMenu {
	
	public static String showDropDownResult(WebDriver driver) {
		WebElement actualCompany = EditPage.companyDropdownField(driver);
		String actualIndex = EditPage.companyDropdownField(driver).getAttribute("value");
		WebElement actualName = actualCompany.findElement(By.xpath("//option[@value='" + actualIndex + "']"));
		String actualCompanyName = actualName.getText();
		return actualCompanyName;
	}

}