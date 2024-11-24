package assignments;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		
		opt.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(opt);
		
		
		driver.get("demo.automationtesting.in/Alerts.html");
		
		Alert pop = driver.switchTo().alert();
		
		pop.accept();
		
		/*	/html/body/div/div/div/div/div/ul/li[1]/a[1]
				//div[@class='tabpane pullleft']//a[@href='#OKTab']
				//a[@href='#OKTab']*/
		
		

	}

}
