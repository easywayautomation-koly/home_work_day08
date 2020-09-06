package home_work_day08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Web_Col {
static WebDriver driver=null;

//Question:print only first column & skip Header
	//Ans:print first column & skip Header(skipheader)
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/Nurun%20Nahar/Desktop/Student_List.html");
		List<WebElement>rows=driver.findElements(By.tagName("tr"));
		List<Data_class_1>lists=new ArrayList<Data_class_1>();
		int skipHeader=0;
		
		for(WebElement row:rows) {
			List<WebElement>cols=row.findElements(By.tagName("td"));
			
		
			if(skipHeader!=0) {
				Data_class_1 data=new Data_class_1();
				data.SSN=cols.get(0).getText();
				data.Studentname=cols.get(1).getText();
				data.CourseName=cols.get(2).getText();
				lists.add(data);
			}
			skipHeader++;
			}
			
		for(Data_class_1 data:lists) {
			System.out.println(data.Studentname);
			
		}
		
		
	}

}
