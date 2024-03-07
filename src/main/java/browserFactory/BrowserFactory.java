package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowserInstance() {	
		return driver;
	}
	
	public static WebDriver startBrowser(String browserName,String applicationURL) 
	{
		
		if(browserName.contains("Chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browserName.contains("FireFox")) {
			driver = new FirefoxDriver();
		}
		
		else if(browserName.contains("Edge")){
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
		}
	}

