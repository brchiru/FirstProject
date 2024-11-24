package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.net.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//BASE CLASS FOR INTILIZATION OF THE SETUP OF ENVIRONMENT TO PERFROM AUTOMATION TEST
public class BaseClass {
	
	public static WebDriver driver;
	public Properties p;
	public long CTime = 5000; 

	@BeforeClass(groups={"Master","Sanity","Regression"})
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String br) throws IOException 
	{
		ChromeOptions options = new ChromeOptions(); 
		//SafariOptions options = new SafariOptions();
		options.addArguments("--headless"); // Enable headless mode
        //options.addArguments("--disable-gpu"); // Required for Windows systems
        options.addArguments("--window-size=1920,1080");

		// TODO Auto-generated constructor stub
		// Reader the file from resources location
		FileReader file = new FileReader("./src/test/java/resources/config.properties");
		// p as properties object has been created 
		p = new Properties();
		// load the properties file  
		p.load(file);
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "safari": capabilities.setBrowserName("safari"); break;
			case "edge": capabilities.setBrowserName("edge"); break;
			default: System.out.println("No matching browser found"); return;
			}
			//WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.122:4444/wd/hub"),capabilities);
			driver = new RemoteWebDriver(new URL("http://192.168.0.122:4444/wd/hub"),capabilities);
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
			switch(br.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver(options); break;
			case "safari" : driver = new SafariDriver(); break;
			default: System.out.println("Invalid Browser Name .... "); return;
			}
		}
		//Initiate Browser 
		//driver = new ChromeDriver(options);
		
		//implicitlyWait for all the requests sent
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// navigate to the url which is in properties.config file
		driver.get(p.getProperty("appURL")); // reading url from config.property file
		//Browser maximise 
		driver.manage().window().maximize();
		
	}

	
	@AfterClass(groups={"Master","Sanity","Regression"})
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(CTime);
		driver.manage().deleteAllCookies();
		driver.quit(); 
	} 
	
}
