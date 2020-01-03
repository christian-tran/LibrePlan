package org.projet_selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class TestCal1 {

	WebDriver driver;
	
	//JDD
	String username = "admin";
	String pwd = "admin";
	String onglet = "Calendrier";
	long pause = 3000;
	
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

	public void cal1() throws InterruptedException {
	//Connection au site et login
			driver.get("http://localhost:8090/libreplan/");
			PageLogin page_Login = PageFactory.initElements(driver, PageLogin.class);
			PageAccueil page_Accueil = page_Login.logIn(driver, username, pwd);
			
			//Test pour voir si le login s'est bien déroulé
			assertTrue(page_Accueil.onglet_calendrier.isDisplayed());
			
			//Mouse-over pour accéder à la page Liste des calendriers
			Actions b = new Actions(driver);
			b.moveToElement(page_Accueil.onglet_ressources).build().perform();
			b.moveToElement(page_Accueil.sous_menu_calendrier).click().build().perform();	
			PageCalendrier page_Calendrier = PageFactory.initElements(driver, PageCalendrier.class);

			//Test pour voir si on arrive bien sur la page Liste des calendriers
			assertTrue(page_Calendrier.listecalendrier.isDisplayed());
			
			//Tests sur les noms des colonnes
			assertEquals("Le tableau n'est pas bien affiché, la colonne Nom est manquante", "Nom", page_Calendrier.nom.getText());
			assertEquals("Le tableau n'est pas bien affiché, la colonne Hérité de la date est manquante", "Hérité de la date", page_Calendrier.herite.getText());
			assertEquals("Le tableau n'est pas bien affiché, la colonne Héritages à jour est manquante", "Héritages à jour", page_Calendrier.heritages.getText());
			assertEquals("Le tableau n'est pas bien affiché, la colonne Opérations est manquante", "Opérations", page_Calendrier.operations.getText());
			
			//Test si le bouton 'Créer' est présent
			
			assertTrue("Le bouton 'créer' est manquant", page_Calendrier.btn_creer.isDisplayed());
			
			Thread.sleep(pause);
}
}