package Test_HomePage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;



/* Testcase-2
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and should navigate to next page where user can add that book to his basket */


public class testcase2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikra\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("http://practice.automationtesting.in/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.findElement(By.xpath("//ul[@id='main-nav']//li//a[text()='Shop']")).click();	    
	  
	    driver.findElement(By.xpath("//div[@id='content']//nav//a[text()='Home']")).click();
	    
	    int a = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
	    System.out.println("NO. of Arrivals in Home Page : "+a);
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
	    String CourseToPurchase ="Mastering JavaScript";
	
	     for(int i=0;i<sliders.size();i++)
	    {  
	       String heading = driver.findElements(By.xpath("//div//ul//li//a//h3")).get(i).getText();
	       System.out.println(heading);
	       if(heading.equalsIgnoreCase(CourseToPurchase))
	       {
	    	   driver.findElements(By.xpath("//div//ul//li//a//img")).get(i).click();
	    	   break;
	       }
	     }
	     driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
	     String message = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
         System.out.println(message); 
         driver.findElement(By.xpath("//div//a[text()='View Basket']")).click();
         String bookinList = driver.findElement(By.xpath("//td[@class='product-name']//a")).getText();
         String total = driver.findElement(By.xpath("//tr[@class='cart-subtotal']//td/span")).getText();
         System.out.print(total);
         String coupon ="krishnasakinala";  
         driver.findElement(By.id("coupon_code")).sendKeys(coupon);
         driver.findElement(By.name("apply_coupon")).click();
         //driver.findElement(By.xpath("ul[@class='woocommerce-error']//li")).getText();
         driver.findElement(By.xpath("//div[@class='wc-proceed-to-checkout']//a")).click();
	    
	   
	}

}