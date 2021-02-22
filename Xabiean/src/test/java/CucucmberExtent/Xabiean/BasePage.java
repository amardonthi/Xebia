package CucucmberExtent.Xabiean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasePage {
	
	WebDriver driver;
	HomePage homePage;
	Response response;
	public BasePage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	public void load()
	{
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void search(String search)
	{
		homePage=new HomePage(driver);
		homePage.searchData(search);
	}
	
	public void closeB()
	{
		driver.quit();
	}
	
	public boolean validate()
	{
		boolean result=true;
		
		List<WebElement> links=driver.findElements(By.xpath("//h3/span"));
		for(WebElement element:links)
		{
			System.out.println(element.getText());
			if(element.getText().length()>1)
			if(!(element.getText().toLowerCase().contains("duck")))
			{
				if(!element.getText().equals("Related searches"))
				result=false;
				break;
			}
			
		}
		return result;
		
	}
	
	public void performGet(){
		response=RestAssured.given().get(" https://jsonplaceholder.typicode.com/posts");
		System.out.println(response.asString());
	}
	
	public boolean validateResponse()
	{
		boolean result=true;
		Object obj = JSONValue.parse(response.asString());
	    JSONArray array = (JSONArray)obj;
	    for(int i=0;i<array.size();++i)
	    {
	    	JSONObject obj2 = (JSONObject)array.get(i);
	    	if(obj2.get("userId").toString()==null&&obj2.get("id").toString()==null&&
	    			obj2.get("title").toString()==null&&obj2.get("body").toString()==null)
	    	{
	    		return false;
	    	}
	    }
	    return result;
	}
}
