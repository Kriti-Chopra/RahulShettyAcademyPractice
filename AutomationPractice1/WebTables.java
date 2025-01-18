import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Scenarios--
		//get number of records in table
		//get number of columns
		//print content of second row
		
		WebElement productTable = driver.findElement(By.id("product"));
		
		//Find tr under table for rows
		List<WebElement> tableRows = productTable.findElements(By.tagName("tr"));
		System.out.println(tableRows.size());
		
		//Find th under the table for columns
		List<WebElement> tableColumns = productTable.findElements(By.tagName("th"));
		System.out.println(tableColumns.size());
		
		//Get down to second row and print columnwise
		List<WebElement> secondRowDataList = tableRows.get(2).findElements(By.tagName("td"));
		for(WebElement column : secondRowDataList) {
			System.out.println(column.getText());
		}
		
		driver.quit();

	}
	
	

}
