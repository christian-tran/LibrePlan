package org.projet_selenium;

import static org.junit.Assert.*;

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
	long pause = 3000;
	
	@Before
	public void setUp() throws InterruptedException {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		OutilTechnique.connexion();
	}
	
	@After
	public void tearDown() {
		
		driver.quit();	
	}
	
	@Test
	public void cri01() throws InterruptedException {
		
		
		PageAccueil page_Accueil = PageFactory.initElements(driver, PageAccueil.class) ;
		
		//Test pour voir si le login s'est bien déroulé
		assertTrue("La page accueil n'est pas affichée", page_Accueil.onglet_calendrier.isDisplayed());
		
		//Mouse-over et accès page critères
		Actions a = new Actions(driver);
		a.moveToElement(page_Accueil.onglet_ressources).build().perform();
		a.moveToElement(page_Accueil.sous_menu_critere).click().build().perform();	
		PageCritere page_Critere = PageFactory.initElements(driver, PageCritere.class);
		
		//Test si on se trouve bien sur la page critères
		assertEquals("La page Critère n'a pas été affiché", "Types de critères Liste", page_Critere.text_page_criteres.getText());
		
		//Tests sur les noms des colonnes
		assertEquals("Le tableau n'est pas bien affiché, la colonne Nom est différente", "Nom", page_Critere.nom.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Code est différente", "Code", page_Critere.code.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Type est différente", "Type", page_Critere.type.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Activé est différente", "Activé", page_Critere.active.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Opérations est différente", "Opérations", page_Critere.operations.getText());
		
		assertTrue("Le tableau n'est pas bien affiché, la colonne Nom n'est pas affiché", page_Critere.nom.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne Code n'est pas affiché", page_Critere.code.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne Type n'est pas affiché", page_Critere.type.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne Activé n'est pas affiché", page_Critere.active.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne Opérations n'est pas affiché", page_Critere.operations.isDisplayed());
		
		//Test si le bouton créé est présent
		assertTrue("Le bouton créer n'est pas présent", page_Critere.button_creer.isDisplayed());
		
		//Click sur le bouton créer
		page_Critere.button_creer.click();
		
		//Tests si on se trouve bien sur la page de création de critères
		assertEquals("La page de création de critère n'a pas été affiché","Créer Type de critère",page_Critere.text_page_criteres_creer.getText());
		
		//Tests pour voir si tous les boutons sont affichées
		assertTrue("Le boutton Enregistrer ne s'est pas affiché", page_Critere.button_enregistrer.isDisplayed());
		assertTrue("Le boutton Enregistrer ne s'est pas affiché", page_Critere.button_sauver_continuer.isDisplayed());
		assertTrue("Le boutton Enregistrer ne s'est pas affiché", page_Critere.button_annuler.isDisplayed());
		
		Thread.sleep(pause);
		
	}

}
