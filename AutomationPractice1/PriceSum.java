import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PriceSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		List<WebElement> productList = driver.findElements(By.xpath("//table[@name='courses']//tr/td[3]"));
		int sum=0;
		for(WebElement product: productList) {
			sum+=Integer.parseInt(product.getText());
		}
		System.out.println(sum);
		
		driver.quit();
	}

}
