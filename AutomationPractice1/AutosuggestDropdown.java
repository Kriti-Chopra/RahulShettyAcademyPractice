import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		//Scenarios-
		//select values from auto-suggestive dropdowns
		WebElement dropdown = driver.findElement(By.id("autocomplete"));
		dropdown.sendKeys("Uni");
		
		for(int i=0;i<5;++i) {
			dropdown.sendKeys(Keys.DOWN);
		}
		
		dropdown.sendKeys(Keys.ENTER);
		System.out.println(dropdown.getDomProperty("value"));
		

		driver.quit();
	
	}

}
