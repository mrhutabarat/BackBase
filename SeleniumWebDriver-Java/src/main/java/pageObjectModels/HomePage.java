package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static WebElement searchField(WebDriver driver) {
		return driver.findElement(By.id("searchbox"));
	}
	
	public static WebElement filterByNameButton(WebDriver driver) {
		return driver.findElement(By.id("searchsubmit"));
	}
	
	public static WebElement addComputer(WebDriver driver) {
		return driver.findElement(By.id("add"));
	}
	
	public static WebElement nextPageLink(WebDriver driver) {
		return driver.findElement(By.partialLinkText("Next"));
	}
	
	public static WebElement mainTable(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody"));
	}
	
	public static WebElement mainBanner(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/h1"));
	}
	
	public static WebElement messageBanner(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]"));
	}
	
}