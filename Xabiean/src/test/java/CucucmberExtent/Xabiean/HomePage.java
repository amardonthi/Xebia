package CucucmberExtent.Xabiean;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(how=How.XPATH,using="//input[@title='Search']")
	WebElement search;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchData(String searchString)
	{
		search.sendKeys(searchString,Keys.ENTER);
		
	}

}
