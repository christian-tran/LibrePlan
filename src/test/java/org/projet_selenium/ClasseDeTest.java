package org.projet_selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClasseDeTest {
	
	WebDriver driver;
	
	//JDD
	String username = "admin";
	String pwd = "admin";
	long pause = 7000;
	
	@Before
	public void setUp() {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test
	public void exercice4() throws InterruptedException {
	
		driver.get("http://localhost:8090/libreplan/");
		PageLogin page_Login = PageFactory.initElements(driver, PageLogin.class);
		page_Login.logIn(driver, username, pwd);
		Thread.sleep(pause);
		
	}

}
