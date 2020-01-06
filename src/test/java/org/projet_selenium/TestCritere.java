package org.projet_selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCritere {
	
	WebDriver driver;
	
	//JDD
	long pause = 2000;
	String username = "admin";
	String pwd = "admin";
	String onglet = "Calendrier";
	String select_type = "PARTICIPANT";
	String nom_button_annuler = "Critère - Test bouton [Annuler]";
	String desc_button_annuler = "Critère - Test bouton [Annuler]";
	String nom_button_enregistrer = "Critère - Test bouton [Enregistrer]";
	String desc_button_enregistrer = "Critère - Test bouton [Enregistrer]";
	String nom_button_sauver_continuer = "Critère - Test bouton [Sauver et continuer]";
	String desc_button_sauver_continuer = "Critère - Test bouton [Sauver et continuer]";
	String nom_button_sauver_continuer_2 = "Critère - Test bouton [Sauver et continuer]2";
	static Logger logger = LoggerFactory.getLogger(TestParticipants.class);
	int ligne;
	
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
		
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		PageAccueil page_Accueil = PageFactory.initElements(driver, PageAccueil.class) ;
		
		//Test pour voir si le login s'est bien déroulé
		wait.until(ExpectedConditions.visibilityOf(page_Accueil.button_logout));
		assertTrue("La page accueil n'est pas affichée", page_Accueil.onglet_calendrier.isDisplayed());
		
		//Mouse-over et accès page critères
		Actions a = new Actions(driver);
		a.moveToElement(page_Accueil.onglet_ressources).build().perform();
		a.moveToElement(page_Accueil.sous_menu_critere).click().build().perform();	
		PageCritere page_Critere = PageFactory.initElements(driver, PageCritere.class);
		
		//Test si on se trouve bien sur la page critères
		assertTrue("La page Critère n'a pas été affiché", page_Critere.text_page_criteres.isDisplayed());
		
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
		
		//Test bouton Annuler, renseigner les champs du formulaire
		OutilTechnique.remplirChamp(page_Critere.input_nom_critere, nom_button_annuler);
		page_Critere.combobox_type.clear();
		page_Critere.combobox_type.sendKeys(select_type);
		OutilTechnique.remplirChamp(page_Critere.input_desc_critere, desc_button_annuler);
		
		//Click sur bouton annuler
		page_Critere.button_annuler.click();
		
		wait.until(ExpectedConditions.visibilityOf(page_Critere.text_page_criteres));
		
		//Vérification de retour et bouton annuler non créé
		assertTrue("La page Critère n'a pas été affiché", page_Critere.text_page_criteres.isDisplayed());
		assertFalse("Le bouton annulé a été créé",OutilTechnique.chercherElement(driver, nom_button_annuler,page_Critere.xpath_tableau));
		
		//Click sur le bouton créer, étape manquante dans le cas de test
		page_Critere.button_creer.click();
		
		//Test bouton Enregistrer, renseigner les champs du formulaire
		OutilTechnique.remplirChamp(page_Critere.input_nom_critere, nom_button_enregistrer);
		page_Critere.combobox_type.clear();
		page_Critere.combobox_type.sendKeys(select_type);
		OutilTechnique.remplirChamp(page_Critere.input_desc_critere, desc_button_enregistrer);
		
		//Click sur bouton enregistrer
		page_Critere.button_enregistrer.click();
		
		wait.until(ExpectedConditions.visibilityOf(page_Critere.text_page_criteres));
		
		//Vérification de retour et bouton enregistrer créé
		assertTrue("La page Critère n'a pas été affiché", page_Critere.text_page_criteres.isDisplayed());
		assertTrue("Le bouton enregistrer n'a pas été créé",OutilTechnique.chercherElement(driver, nom_button_enregistrer,page_Critere.xpath_tableau));
		
		//Click sur le bouton créer, étape manquante dans le cas de test
		page_Critere.button_creer.click();
		
		//Test bouton Enregistrer, renseigner les champs du formulaire
		OutilTechnique.remplirChamp(page_Critere.input_nom_critere, nom_button_sauver_continuer);
		page_Critere.combobox_type.clear();
		page_Critere.combobox_type.sendKeys(select_type);
		OutilTechnique.remplirChamp(page_Critere.input_desc_critere, desc_button_sauver_continuer);
		
		//Click sur bouton sauver et continuer
		page_Critere.button_sauver_continuer.click();
		
		//Test sur message de confirmation et titre page
		assertEquals("Le message de confirmation n'a pas été affiché","Type de critère \"Critère - Test bouton [Sauver et continuer]\" enregistré", page_Critere.text_confirmation_action_sauver_continuer.getText());
		assertEquals("Le titre n'est pas le bon","Modifier Type de critère: Critère - Test bouton [Sauver et continuer]", page_Critere.text_modification_critere.getText());
		
		//Click sur bouton annuler
		page_Critere.button_annuler.click();
		
		wait.until(ExpectedConditions.visibilityOf(page_Critere.text_page_criteres));
		
		//Vérification de retour et bouton sauver et continuer créé
		assertTrue("La page Critère n'a pas été affiché", page_Critere.text_page_criteres.isDisplayed());
		assertTrue("Le bouton sauver et continuer n'a pas été créé",OutilTechnique.chercherElement(driver, nom_button_sauver_continuer,page_Critere.xpath_tableau));
		
		//Click sur le bouton modifier de la colonne opération et de la ligne sauver et continuer
		ligne = OutilTechnique.retournerNumeroDeLigne(driver, nom_button_sauver_continuer, page_Critere.xpath_tableau);
		driver.findElement(By.xpath("//tr["+ligne+"]//img[@src='/libreplan/common/img/ico_editar1.png']")).click();
		
		
		//Vérifier qu'on se trouve bien sur la page de modification de sauver et continuer
		wait.until(ExpectedConditions.visibilityOf(page_Critere.text_modification_critere));
		assertEquals("La page n'est pas la bonne","Modifier Type de critère: Critère - Test bouton [Sauver et continuer]", page_Critere.text_modification_critere.getText());
		
		//Changement du nom de sauver et continuer
		OutilTechnique.remplirChamp(page_Critere.input_nom_critere, nom_button_sauver_continuer_2);
		
		//Click sur annuler
		page_Critere.button_annuler.click();
		
		//Verification retour et non changement du nom de sauver et continuer
		wait.until(ExpectedConditions.visibilityOf(page_Critere.text_page_criteres));
		assertTrue("La page Critère n'a pas été affiché", page_Critere.text_page_criteres.isDisplayed());
		assertEquals("Le titre a été changé","Critère - Test bouton [Sauver et continuer]", page_Critere.nom_button_sauver_continuer.getText());
		
		//Click sur le nom du critere sauver et continuer
		page_Critere.nom_button_sauver_continuer.click();
		
		//Vérifier qu'on se trouve bien sur la page de modification de sauver et continuer
		wait.until(ExpectedConditions.visibilityOf(page_Critere.text_modification_critere));
		assertEquals("La page n'est pas la bonne","Modifier Type de critère: Critère - Test bouton [Sauver et continuer]", page_Critere.text_modification_critere.getText());
		
		//Changement du nom de sauver et continuer
		OutilTechnique.remplirChamp(page_Critere.input_nom_critere, nom_button_sauver_continuer_2);
		
		//Click sur bouton sauver et continuer
		page_Critere.button_sauver_continuer.click();
						
		//Test sur message de confirmation et titre page
		assertEquals("Le message de confirmation n'a pas été affiché","Type de critère \"Critère - Test bouton [Sauver et continuer]2\" enregistré", page_Critere.text_confirmation_action_sauver_continuer.getText());
		assertEquals("Le titre n'est pas le bon","Modifier Type de critère: Critère - Test bouton [Sauver et continuer]2", page_Critere.text_modification_critere.getText());
		
		//Click sur annuler
		page_Critere.button_annuler.click();
		
		//Vérification retour et changement du nom de sauver et continuer
		wait.until(ExpectedConditions.visibilityOf(page_Critere.text_page_criteres));
		assertTrue("La page Critère n'a pas été affiché", page_Critere.text_page_criteres.isDisplayed());
		assertEquals("Le titre n'a pas été changé","Critère - Test bouton [Sauver et continuer]2", page_Critere.nom_button_sauver_continuer.getText());
		
		//Click sur le bouton supprimer de la colonne opération et de la ligne sauver et continuer
		ligne = OutilTechnique.retournerNumeroDeLigne(driver, nom_button_sauver_continuer_2, page_Critere.xpath_tableau);
		driver.findElement(By.xpath("//tr["+ligne+"]//img[@src='/libreplan/common/img/ico_borrar1.png']")).click();
		
		//Vérification message dans la pop up de suppression
		assertEquals("Le message de la pop up de suppression est érronée","Supprimer Type de critère \"Critère - Test bouton [Sauver et continuer]2\". Êtes-vous sûr ?", page_Critere.message_pop_up_suppression.getText());
		assertTrue("Le bouton OK n'est pas affiché", page_Critere.button_ok_pop_up.isDisplayed());
		assertTrue("Le bouton Annuler n'est pas affiché", page_Critere.button_annuler_pop_up.isDisplayed());
		
		//Click sur bouton annuler
		page_Critere.button_annuler_pop_up.click();
		
		//Vérification de retour sur page et non suppression
		wait.until(ExpectedConditions.visibilityOf(page_Critere.text_page_criteres));
		assertTrue("La pop up est toujours présente a l'écran",page_Critere.text_page_criteres.isDisplayed());
		assertTrue("Le bouton sauver et continuer a été supprimé",OutilTechnique.chercherElement(driver, nom_button_sauver_continuer_2,page_Critere.xpath_tableau));
		
		//Click sur la poubelle de la colonne opération et de la ligne sauver et continuer
		ligne = OutilTechnique.retournerNumeroDeLigne(driver, nom_button_sauver_continuer_2, page_Critere.xpath_tableau);
		driver.findElement(By.xpath("//tr["+ligne+"]//img[@src='/libreplan/common/img/ico_borrar1.png']")).click();
		
		//Vérification message dans la pop up de suppression
		assertEquals("Le message de la pop up de suppression est érronée","Supprimer Type de critère \"Critère - Test bouton [Sauver et continuer]2\". Êtes-vous sûr ?", page_Critere.message_pop_up_suppression.getText());
		assertTrue("Le bouton OK n'est pas affiché", page_Critere.button_ok_pop_up.isDisplayed());
		assertTrue("Le bouton Annuler n'est pas affiché", page_Critere.button_annuler_pop_up.isDisplayed());
		
		//Click sur le bouton OK
		page_Critere.button_ok_pop_up.click();
		
		//Vérification message de suppression
		assertTrue("Le message de suppresion n'est pas affiché", page_Critere.text_suppression_critere.isDisplayed());
		assertFalse("Le bouton sauver et continuer 2 n'a pas été éffacé",OutilTechnique.chercherElement(driver, nom_button_sauver_continuer_2,page_Critere.xpath_tableau));
		
		
		Thread.sleep(pause);
		
	}

}
