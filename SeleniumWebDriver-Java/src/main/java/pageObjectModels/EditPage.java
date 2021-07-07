package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage {
	
	public static WebElement computerNameField(WebDriver driver) {
		return driver.findElement(By.id("name"));
	}
	
	public static WebElement introducedDateField(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"introduced\"]"));
	}

	public static WebElement discontinuedDateField(WebDriver driver) {
		return driver.findElement(By.id("discontinued"));
	}
	
	public static WebElement companyDropdownField(WebDriver driver) {
		return driver.findElement(By.id("company"));
	}
	
	public static WebElement createThisComputerButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Create this computer']"));
	}
	
	public static WebElement saveThisComputerButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/form[1]/div/input"));
	}
	
	public static WebElement cancelButton(WebDriver driver) {
		return driver.findElement(By.linkText("Cancel"));
	}
	
	public static WebElement deleteThisComputerButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Delete this computer']"));
	}

}