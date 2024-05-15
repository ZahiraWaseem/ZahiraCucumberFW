package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class BrowserFactory {
  
	public  WebDriver driver;
	public  int iBrowser = 2;

public WebDriver launchBrowser() {
	if(driver == null) {
	switch(iBrowser) {
	case 1:
		System.out.println("User option is "+iBrowser+",So invoking chrome Browser");
		driver= new ChromeDriver();
		break;
	case 2:
		System.out.println("User Option is "+iBrowser+", So invoking Edge Browser");
		driver= new EdgeDriver();
		break;
	case 3:
		System.out.println("User option is "+iBrowser+", So invoking Firefox Browser");
		driver= new FirefoxDriver();
		break;
	default:
		System.out.println("User option is wrong "+iBrowser+", So invoking default Chrome Browser");
		driver= new ChromeDriver();
		break;
	}
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
    return driver;

}
//public void closeBrowser() {
//	driver.quit();
//}
}