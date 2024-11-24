package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment4 {
	static long CTime = 1000;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		
		opt.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(opt);
		
		
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		System.out.println("Current Page is :: "+driver.getTitle());
		Thread.sleep(CTime);
		
		WebElement signInbutton = driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
		
		signInbutton.click();
		
		Thread.sleep(CTime);
		
		WebElement verifysignonForm = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/p[1]"));
		
		System.out.println("Landed on new page :: "+verifysignonForm.getText());
		
		WebElement userNameField = driver.findElement(By.name("username"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@name=\"signon\"]"));
		
		
		userNameField.sendKeys("test007");
		passwordField.clear();
		passwordField.sendKeys("test001");
		
		loginBtn.click();
		System.out.println("Navigated page is : "+driver.getCurrentUrl());
		
		Thread.sleep(CTime);
		
		WebElement dogLink = driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[2]/img"));
		
		dogLink.click();
		
		System.out.println("Navigated page is : "+driver.getCurrentUrl());
		
		Thread.sleep(CTime);
		
		WebElement DalmationProdID = driver.findElement(By.xpath("//a[normalize-space()=\"K9-DL-01\"]"));
		
		DalmationProdID.click();
		
		System.out.println("Navigated page is : "+driver.getCurrentUrl());
		
		Thread.sleep(CTime);
		
		
		WebElement AddCartDalmation = driver.findElement(By.cssSelector("a[href=\"/actions/Cart.action?addItemToCart=&workingItemId=EST-10\"]"));
		
		AddCartDalmation.click();
		
		System.out.println("Navigated page is : "+driver.getCurrentUrl());
		
		Thread.sleep(CTime);
		
		WebElement dogDesp = driver.findElement(By.cssSelector("tbody tr td:nth-child(3)"));
		WebElement AddCartval = driver.findElement(By.xpath("//input[@name=\"EST-10\"]"));
		
		System.out.println("Verified Dog Name and quantity is : "+dogDesp.getText()+" and "+AddCartval.getAttribute("value"));
		
		WebElement signOutLink = driver.findElement(By.xpath("//a[normalize-space()=\"Sign Out\"]"));
		
		signOutLink.click();
		
		System.out.println("Navigated page is : "+driver.getCurrentUrl());
		
		driver.close();
		

	}

}
