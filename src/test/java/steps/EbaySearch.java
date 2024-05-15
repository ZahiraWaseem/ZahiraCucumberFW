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
import pages.EbayHomePage;

public class EbaySearch extends BrowserFactory{
	
EbayHomePage ebayHomePage;

public EbaySearch(PicoTestContext pico) {
	ebayHomePage = pico.getPageObjectManager().getEbayPage();
}

@Given("I should navigate to Ebay URL")
public void i_should_navigate_to_ebay_url() {
	ebayHomePage.navigateToEbayURL();
}

@When("I will type the product and select the product catagory")
public void i_will_type_the_product_and_select_the_product_catagory() {
	ebayHomePage.enterSearchText("iPhone");
	ebayHomePage.selectProdCatagory("Cell Phones & Accessories");
}


@When("^I will type the multiple product name as (\\D+) and select the multiple product catagory as (\\D+)$")
public void i_will_type_the_multiple_product_name_as_i_phone_and_select_the_multiple_product_catagory_as_cell_phones_accessories(String prodName,String prodCatagory) {
	ebayHomePage.enterSearchText(prodName);
	ebayHomePage.selectProdCatagory(prodCatagory);
}


@When("I will type the product name from the below data table as a map")
public void i_will_type_the_product_name_from_the_below_data_table_as_a_map(DataTable dataTable) {
	List<Map<String, String>> rows = dataTable.asMaps();
	for (Map<String, String> row : rows) {
		String prodName = row.get("ProductName");
		String prodCat = row.get("ProductCatagory");
		ebayHomePage.enterSearchText(prodName);
		ebayHomePage.selectProdCatagory(prodCat);
	}
}


@When("I will click on search button")
public void i_will_click_on_search_button() {
    ebayHomePage.clickOnSearchButton();
}

@Then("I should see the search product result")
public void i_should_see_the_search_product_result() {
	String sResult = ebayHomePage.getSearchResult();
	System.out.println("Result is : "+sResult);
	sResult = sResult.replaceAll("[^0-9]", "");
	int iResult = Integer.parseInt(sResult);
	System.out.println("Number Result is : "+iResult);
	}

}
