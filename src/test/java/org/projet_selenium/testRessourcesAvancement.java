package org.projet_selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class testRessourcesAvancement {

	WebDriver driver ;
	
	@Before
	public void setUp() throws InterruptedException
	{
		driver = OutilTechnique.choisirNavigateur(ENavigateur.firefox) ;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
		OutilTechnique.connexion() ;	
	}
		
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000) ;
		driver.quit();	
	}
	
	
	@Test
	public void testTypeavancement() throws InterruptedException 
	{

		//instanciation page accueil
		PageAccueil page_Accueil = PageFactory.initElements(driver, PageAccueil.class) ;
		
		//test presence sur page accueil pour verif login OK
		assertTrue(page_Accueil.onglet_calendrier.isDisplayed()) ;
		
		//action souris sur onglet ressources puis "Types d'avancement"
		Actions a = new Actions(driver) ;
		a.moveToElement(page_Accueil.onglet_ressources).build().perform() ;
		a.moveToElement(page_Accueil.sous_menu_types_avancement).click().build().perform() ;
		
		//instanciation page ressources
		PageRessources page_Ressource = PageFactory.initElements(driver, PageRessources.class) ;
		
		//verif presence tableau avec en titre de col. : nom, activé, prédéfini, opérations
		assertTrue(page_Ressource.col_nom.isDisplayed()) ;
		assertTrue(page_Ressource.col_active.isDisplayed()) ;
		assertTrue(page_Ressource.col_predefini.isDisplayed()) ;
		assertTrue(page_Ressource.col_operations.isDisplayed()) ;
		assertTrue(page_Ressource.button_creer.isDisplayed()) ;
		
		//clique sur le bouton creer
		page_Ressource.button_creer.click() ;
		
		//verif elements nécessaires à la suite des actions
		assertTrue(page_Ressource.titre_type_avancement.isDisplayed()) ;//titre localisation
		assertTrue(page_Ressource.tab_modif.isDisplayed()) ;			//
		page_Ressource.nom_unit.equals(null) ; 					//champ vide
		page_Ressource.actif.isEnabled() ;						//case cochée par defaut
		page_Ressource.val_max.getText().equals("100,00") ;		//defaut 100,00
		page_Ressource.val_max.getText().equals("0,1000") ;		//defaut 0,1000
		
		//Pour montrer que le champ type n'est pas modifiable on tente 'try' d'y insérer
		// du texte. Cela génère une Exception que l'on catch.
		try { page_Ressource.type.sendKeys("test") ; }
		catch (Exception e) 
		{ //assertTrue("user non modifiable", true) ; }
		}
		// case non cochée par défaut
		assertFalse(page_Ressource.pourcentage.isSelected()) ;
		
		
		
		
		
		
		
		
	}

}
