package org.projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OutilTechnique {
	
static WebDriver driver;

	
	static WebDriver choisirNavigateur(ENavigateur nav) {
		switch (nav) {
			case chrome : 
				System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
				driver = new ChromeDriver();
				return driver;
			
			case firefox :
				System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
				driver = new FirefoxDriver();
				return driver;
				
			case ie :
				System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				return driver;
				
			default : return null;
			
		}
	}
	
	static void remplirChamp (WebElement we, String s) {
		
		we.clear();
		we.sendKeys(s);
		
	}

}
