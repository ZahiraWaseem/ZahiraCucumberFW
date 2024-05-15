package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.PropertyReader;

public class EbayHomePage {

	private WebDriver driver;
	public String sURL = PropertyReader.readDataFromPropertyFile("environment", "ebay");
	private By productNameTxt = By.id("gh-ac");
	private By productCatagoryDrop = By.id("gh-cat");
	private By searchButton = By.id("gh-btn");
	private By searchResult = By.xpath("(//h1[@class='srp-controls__count-heading']/span)[1]");
	
	public EbayHomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void navigateToEbayURL() {
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void enterSearchText(String prodName) {
		WebElement oSearch;
		oSearch = driver.findElement(productNameTxt);
		oSearch.clear();
		oSearch.sendKeys(prodName);
	}
	
	public void selectProdCatagory(String prodCatagory) {
		WebElement oDropdown;
		oDropdown = driver.findElement(productCatagoryDrop);
		Select oSelect = new Select(oDropdown);
		oSelect.selectByVisibleText(prodCatagory);
		
	}
	
	public void clickOnSearchButton() {
		WebElement oBtn = driver.findElement(searchButton);
		oBtn.submit();
	}
	
	public String getSearchResult() {
		WebElement result;
		result = driver.findElement(searchResult);
		String resultText = result.getText();
		return resultText;
	}
}
