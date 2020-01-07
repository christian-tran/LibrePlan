	package org.projet_selenium;



import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class OutilTechnique {
	
static WebDriver driver;
static String navigateur = "Chrome";

	
	static WebDriver choisirNavigateur(ENavigateur nav) {
		switch (nav) {
			case chrome : 
				System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
				driver = new ChromeDriver();
				navigateur="Chrome";
				return driver;
			
			case firefox :
				System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
				driver = new FirefoxDriver();
				navigateur="Firefox";
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
	
	// Methode de connexion au site, à utiliser en @Before
	
	static String username ="admin" ;
	static String pwd = "admin" ;
	static int pause = 7000 ;
		
	static void connexion () throws InterruptedException {
			
		driver.get("http://localhost:8090/libreplan/");
		PageLogin page_Login = PageFactory.initElements(driver, PageLogin.class);
		page_Login.logIn(driver, username , pwd);
		
	}
	
	static boolean chercherElement(WebDriver driver, String s, String xpath){ 
		List<WebElement> lignes = driver.findElements(By.xpath(xpath));
		for(WebElement ligne : lignes){
		   List<WebElement> cases = ligne.findElements(By.xpath("td"));
		   for(WebElement cellule : cases) {
			   if(cellule.getText().equals(s)){
				   return true;	
			   }
		   }
		}
		return false;
	}
	
	static int retournerNumeroDeLigne(WebDriver driver, String s, String xpath){ 
		int ligneCourante = 1;
		
		List<WebElement> lignes = driver.findElements(By.xpath(xpath));
		for(WebElement ligne : lignes){
		   List<WebElement> cases = ligne.findElements(By.xpath("td"));
		   for(WebElement cellule : cases) {
			   if(cellule.getText().equals(s)){
				   return ligneCourante;
			   }
		   }
	      ligneCourante++;
		}
		return -1;
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
	}

}
