package Test_HomePage;
/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Click on the Add To Basket button which adds that book to your basket
11) User can view that Book in the Menu item with price.
12) Now click on Item link which navigates to proceed to check out page.
13) Now click on Remove this icon in Check out page which removes that book from the grid.
14) User has the feasibility to remove the book at the time of check out also */

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikra\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("http://practice.automationtesting.in/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.findElement(By.xpath("//ul[@id='main-nav']//li//a[text()='Shop']")).click();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Home']")).click();
	    //The Home page must contains only three Arrivals
	    int a = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
	    System.out.println("NO. of Arrivals in Home Page : "+a);
	    String CourseToPurchase ="Selenium Ruby";
	    List<WebElement> arrivals =driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
	     for(int i=0;i<arrivals.size();i++)
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
	     driver.findElement(By.xpath("//div[@class='woocommerce-message']//a[text()='View Basket']")).click();
	    //Now click on Remove this icon in Check out page which removes that book from the grid.
	     
	     List<WebElement> itemsToRemove = driver.findElements(By.xpath("//div[@class='woocommerce']//tr//td[@class='product-name']"));
	     for(int i=0;i<itemsToRemove.size();i++)
	     {   
	    	 String item = itemsToRemove.get(i).getText();
	        if(item.equalsIgnoreCase(CourseToPurchase))
	         {
	      	   driver.findElements(By.xpath("//div[@class='woocommerce']//td[@class='product-remove']/a")).get(i).click(); 
	         }
	     }
	}

}
