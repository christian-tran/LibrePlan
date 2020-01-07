package org.projet_selenium;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class testRessourcesAvancement {

	WebDriver driver ;
		
	String nom_test_avanacement = "Type d'avancement - Test 1" ;
	String nom_test_avanacement_2 = "Type d'avancement - Test 2" ;	
	
	@Before
	public void setUp() throws InterruptedException
	{
		driver = OutilTechnique.choisirNavigateur(ENavigateur.firefox) ;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS) ;
		OutilTechnique.connexion() ;	
	}
		
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000) ;
		driver.quit();	
	}
	
	@Test
	public void testTypeavancement() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver,2) ;

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
		assertTrue(page_Ressource.titre_type_avancement.isDisplayed()) ;//titre localisation dans la navigation
		assertTrue(page_Ressource.tab_modif.getText().equals("Modifier")) ;
		
		assertEquals("Nom d'unité",page_Ressource.nom_unit.getText()) ;
		assertEquals("Actif",page_Ressource.actif.getText()) ;
		assertEquals("Valeur maximum par défaut", page_Ressource.val_max.getText()) ;
		assertEquals("Précision",page_Ressource.precision.getText()) ;
		assertEquals("Type",page_Ressource.type.getText()) ;
		assertEquals("Pourcentage",page_Ressource.pourcentage.getText()) ;
		
		
		//Pour montrer que le champ type n'est pas modifiable on tente 'try' d'y insérer
		// du texte. Cela génère une Exception que l'on catch.
		
		assertEquals("",page_Ressource.champ_nom_unit.getText()) ; 	//champ vide
		assertTrue(page_Ressource.checkbox_actif.isSelected()) ;	//case cochée par defaut
		assertEquals("100,00", page_Ressource.champ_val_max.getAttribute("value"));//defaut 100,00
		assertEquals("0,1000", page_Ressource.champ_precision.getAttribute("value")) ;//defaut 0,1000
		try {  page_Ressource.champ_type.sendKeys("test") ; }
		catch (Exception e) { /* mettre un logger ici */ }
		assertFalse(page_Ressource.checkbox_pourcentage.isSelected()) ;	// case non cochée par défaut
		assertTrue(page_Ressource.bouton_annuler.isDisplayed()) ;		//presence du bouton Annuler
		assertTrue(page_Ressource.bouton_sauver_continuer.isDisplayed()) ;
		assertTrue(page_Ressource.bouton_enregistrer.isDisplayed()) ;
		
		//Remplissage du tableau test 1, sans pourcentage
		page_Ressource.champ_nom_unit.sendKeys(nom_test_avanacement) ;
		page_Ressource.checkbox_actif.click() ;
		OutilTechnique.remplirChamp(page_Ressource.champ_val_max, "10,00");
		assertEquals("User",page_Ressource.champ_type.getText()) ;
		
		//click bouton enregistrer
		page_Ressource.bouton_enregistrer.click() ;
		
		assertTrue(page_Ressource.titre_liste_avancement.isDisplayed()) ;
		assertEquals("Type d'avancement \"Type d'avancement - Test 1\" enregistré", page_Ressource.enregistrement_confirm.getText()) ;
		assertEquals("Type d'avancement \"Type d'avancement - Test 1\" enregistré", page_Ressource.avancement_cree_tab.getText()) ;
		
		driver.navigate().refresh() ;
		
		assertFalse(page_Ressource.checkbox_active.isEnabled()) ;
		assertFalse(page_Ressource.checkbox_predefini.isEnabled()) ;
		assertTrue(page_Ressource.bouton_operations_modif.isDisplayed()) ;
		assertTrue(page_Ressource.bouton_operations_del.isDisplayed()) ;
		
		assertFalse(page_Ressource.checkbox_active.isSelected()) ;
		assertFalse(page_Ressource.checkbox_predefini.isSelected()) ;
		assertTrue(page_Ressource.bouton_operations_modif.isEnabled()) ;
		assertTrue(page_Ressource.bouton_operations_del.isEnabled()) ;
		
		//2 nd clique sur le bouton creer
		page_Ressource.button_creer.click() ;
		
		//verif elements nécessaires à la suite des actions
		assertTrue(page_Ressource.titre_type_avancement.getText().equals("Créer Type d'avancement")) ;//titre localisation dans la navigation
		
		//Remplissage du tableau
		page_Ressource.champ_nom_unit.sendKeys(nom_test_avanacement_2) ;
		page_Ressource.checkbox_pourcentage_2.click() ;

		//Verif checkbox champ_val_max non modifiable
		assertFalse(page_Ressource.champ_val_max_2.isEnabled()) ;
		
		//Clique sur sauver et continuer
		page_Ressource.bouton_sauver_continuer.click() ;
		
		//Verif message et titre "Modifier Type d'avancement: Type d'avancement - Test 2"
		assertEquals("Type d'avancement \"Type d'avancement - Test 2\" enregistré", page_Ressource.enregistrement_confirm.getText()) ;
		assertEquals("Modifier Type d'avancement: Type d'avancement - Test 2", page_Ressource.titre_type_avancement.getText()) ;
		
		//Clique sur annuler puis controle de titre page en cours
		page_Ressource.bouton_annuler.click() ;
		driver.navigate().refresh() ;
		assertEquals("Types d'avancement Liste", page_Ressource.titre_type_avancement_2.getText()) ;
		
		//controle du contenu du tableau pour test 2
		assertFalse(page_Ressource.checkbox_active_2.isEnabled()) ;
		assertFalse(page_Ressource.checkbox_predefini_2.isEnabled()) ;
		assertTrue(page_Ressource.bouton_operations_modif_2.isDisplayed()) ;
		assertTrue(page_Ressource.bouton_operations_del_2.isDisplayed()) ;
		
		assertTrue(page_Ressource.checkbox_active_2.isSelected()) ;
		assertFalse(page_Ressource.checkbox_predefini_2.isSelected()) ;
		assertTrue(page_Ressource.bouton_operations_modif_2.isEnabled()) ;
		assertTrue(page_Ressource.bouton_operations_del_2.isEnabled()) ;
		
		
		
		
		
	}

}
