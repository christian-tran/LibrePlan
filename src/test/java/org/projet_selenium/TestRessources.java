package org.projet_selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class TestRessources {
	
	WebDriver driver;
	
	//JDD
	String username = "admin";
	String pwd = "admin";
	String onglet = "Calendrier";
	long pause = 7000;
	
	@Before
	public void setUp() throws Exception {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		BDDConnexion.insertData("src/test/JDD/JDD.xml");
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test
	public void gre01() throws InterruptedException {
	
		//Connection au site et login
		driver.get("http://localhost:8090/libreplan/");
		PageLogin page_Login = PageFactory.initElements(driver, PageLogin.class);
		PageAccueil page_Accueil = page_Login.logIn(driver, username, pwd);
		
		//Test pour voir si le login s'est bien déroulé
		assertTrue(page_Accueil.onglet_calendrier.isDisplayed());
		
		//Mouse-over et accès page Participants
		Actions a = new Actions(driver);
		a.moveToElement(page_Accueil.onglet_ressources).build().perform();
		a.moveToElement(page_Accueil.sous_menu_participants).click().build().perform();	
		PageParticipants page_Participants = PageFactory.initElements(driver, PageParticipants.class);
		
		//Test si on se trouve bien sur la page Participants
		assertEquals("La page Participants n'a pas été affiché", "Liste des participants", page_Participants.text_page_participants.getText());
		
		//Tests sur les noms des colonnes
		assertEquals("Le tableau n'est pas bien affiché, la colonne Nom est manquante", "Surnom", page_Participants.surnom.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Prénom est manquante", "Prénom", page_Participants.prenom.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne ID est manquante", "ID", page_Participants.id.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Code est manquante", "Code", page_Participants.code.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne En file est manquante", "En file", page_Participants.en_file.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Opérations est manquante", "Opérations", page_Participants.operations.getText());
		
		//Test si le bouton créer est présent

		
		Thread.sleep(pause);
		
	}

}
