package steps;


	import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.BrowserFactory;
import base.PicoTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;

	public class AmazonSearchSD {
		
		AmazonHomePage amazonHomePage;
		
		public AmazonSearchSD(PicoTestContext pico) {
			amazonHomePage = pico.getPageObjectManager().getAmazonPage();
		}
		
		@Given("User should navigate to Amazon")
		public void user_should_navigate_to_amazon() {
			amazonHomePage.navigateURL();
		}

			
			@When("User search with multiple products in Amazon called")
			public void user_search_with_multiple_products_called(DataTable dataTable) {
			 List<Map<String, String>> searchs = dataTable.asMaps();
				for (Map<String, String> search : searchs) {
					amazonHomePage.enterProductName(search.get("ProdName"));
					amazonHomePage.selectProductCatagory(search.get("ProdCat"));
					amazonHomePage.clickSearchButton();
				}
		} 

		@Then("Validate the Amazon search result")
		public void validate_the_search_result() {
			String sResult = amazonHomePage.getsearchResult();
		    System.out.println("Result is : "+sResult);
		}
	}
