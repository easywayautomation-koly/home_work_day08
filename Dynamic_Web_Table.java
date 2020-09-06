package home_work_day08;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Web_Table {
	
	static WebDriver driver=null;
	
	//Question: Print all html data table.
	//Ans:print all data type.
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/Nurun%20Nahar/Desktop/Student_List.html");
		List<WebElement>rows=driver.findElements(By.tagName("tr"));
		
		for(WebElement row :rows) {
			List<WebElement>cols=driver.findElements(By.tagName("td"));
			for(WebElement col:cols) {
				System.out.println(col.getText());
			}
			
			
		}
		
		

	}

}
