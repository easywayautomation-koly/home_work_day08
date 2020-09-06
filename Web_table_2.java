package home_work_day08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_table_2 {
	
	static WebDriver driver=null;
	//Question:print only first column & skip Header
		//Ans:print first column & skip Header (use counter)
		
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("file:///C:/Users/Nurun%20Nahar/Desktop/Student_Course_List.html");

		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		
		List<Data_class> lists = new ArrayList<Data_class>();
		
		
		int counter=0;
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			if (counter!=0) {
				Data_class data = new Data_class();
				
				data.SSN=cols.get(0).getText();
				data.StudentName=cols.get(1).getText();
				data.CourseName=cols.get(2).getText();
				lists.add(data);
				
			}
			counter++;	
		}
		
		for (Data_class data_class : lists) {
			System.out.println(data_class.StudentName);
		}
		

	}

}
