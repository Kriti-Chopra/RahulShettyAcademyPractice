import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckboxsDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scenario:
		//1. Select a value in checkbox
		//2. get the label
		//3. select same value in dropdown
		//4. send same option for alert text and verify the alert
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		//S-1
		int expectedNum = 2;
		List<WebElement> checkboxesList = driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
		WebElement checkBoxToBeSelectedElement= checkboxesList.get(expectedNum-1).findElement(By.tagName("input"));
		checkBoxToBeSelectedElement.click();
		Assert.assertTrue(checkBoxToBeSelectedElement.isSelected());
			
		//S-2
		WebElement selectedCheckbox= checkboxesList.get(expectedNum-1);
		String selectedOption = checkboxesList.get(expectedNum-1).getText().trim();
		System.out.println(selectedOption);
		
		//S-3
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByValue(selectedOption.toLowerCase());
		Assert.assertEquals(selectedOption, dropdown.getFirstSelectedOption().getText().trim());
		
		//S-4
		WebElement alertInputBox = driver.findElement(By.id("name"));
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		alertInputBox.sendKeys(selectedOption);
		alertBtn.click();
		
		Alert alert= driver.switchTo().alert();
		String alertText = alert.getText().split(",")[0].split(" ")[1];
		System.out.println(alertText);
		Assert.assertEquals(alertText, selectedOption);

		
		driver.quit();
	}

}
