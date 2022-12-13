package Test_HomePage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Testcase-1
  Home Page with three Sliders only
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Sliders only
6) The Home page must contains only three sliders  */


public class testcase1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikra\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("http://practice.automationtesting.in/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.findElement(By.xpath("//ul[@id='main-nav']//li//a[text()='Shop']")).click();	    
	  
	    driver.findElement(By.xpath("//div[@id='content']//nav//a[text()='Home']")).click();
	    
	    int a = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
	    System.out.println("NO. of slider in Home Page : "+a);
	    List<WebElement> sliders =driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
	    /*1st method
	     for(int i=0;i<sliders.size();i++)
	    {  
	       WebElement x= sliders.get(i);
	       String heading = x.findElements(By.xpath("//div//ul//li//a//h3")).get(i).getText();
	       System.out.println(heading);
	    }
	    driver.close();*/
	    
	    /*2nd method */
	
	     for(int i=0;i<sliders.size();i++)
	    {  
	       String heading = driver.findElements(By.xpath("//div//ul//li//a//h3")).get(i).getText();
	       System.out.println(heading);
	    }
	    driver.close();
	    
	   
	}

}
