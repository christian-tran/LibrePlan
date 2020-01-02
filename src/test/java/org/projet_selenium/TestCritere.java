package org.projet_selenium;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class TestCritere {
	
	WebDriver driver;
	
	//JDD
	String username = "admin";
	String pwd = "admin";
	String onglet = "Calendrier";
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
	
		//Connection au site et login
		driver.get("http://localhost:8090/libreplan/");
		PageLogin page_Login = PageFactory.initElements(driver, PageLogin.class);
		PageAccueil page_Accueil = page_Login.logIn(driver, username, pwd);
		
		//Test pour voir si le login s'est bien déroulé
		assertTrue(page_Accueil.onglet_calendrier.isDisplayed());
		
		//Mouse-over
		Actions a = new Actions(driver);
		a.moveToElement(page_Accueil.onglet_ressources).build().perform();
		a.moveToElement(page_Accueil.onglet_critere).click().build().perform();	
		PageCritere page_Critere = PageFactory.initElements(driver, PageCritere.class);

		
		Thread.sleep(pause);
		
	}

}
