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

public class TestCal1 {

	WebDriver driver;
	
	//JDD
	String username = "admin";
	String pwd = "admin";
	String onglet = "Calendrier";
	long pause = 5000;
	String nom_calendrier = "Calendrier - Test 1";
	String nom_calendrier1 = "Calendrier - Test Calendrier Derive";
	String nom_calendrier2 = "Créer Calendrier: Calendrier - Test Calendrier Derive";
	String btn_derive = "Calendrier - Test bouton [dérive]2";
	int ligne;
	
	@Before
	public void setUp() throws InterruptedException {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		OutilTechnique.connexion();
			}
	
	//@After
	public void tearDown() {
		
		driver.quit();
			}
	
	@Test

	public void cal1() throws InterruptedException {
	//Connection au site et login
			driver.get("http://localhost:8090/libreplan/");
	
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			PageAccueil page_Accueil = PageFactory.initElements(driver, PageAccueil.class) ;
			
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
			
			assertTrue("Le tableau n'est pas bien affiché, la colonne Nom est manquante", page_Calendrier.nom.isDisplayed());
			assertTrue("Le tableau n'est pas bien affiché, la colonne Hérité de la date est manquante", page_Calendrier.herite.isDisplayed());
			assertTrue("Le tableau n'est pas bien affiché, la colonne Héritages à jour est manquante",  page_Calendrier.heritages.isDisplayed());
			assertTrue("Le tableau n'est pas bien affiché, la colonne Opérations est manquante",  page_Calendrier.operations.isDisplayed());
			
			//Test si le bouton 'Créer' est présent
			
			assertTrue("Le bouton 'créer' est manquant", page_Calendrier.btn_creer.isDisplayed());
			
			//Cliquer sur le bouton 'créer'
			
			page_Calendrier.btn_creer.click();
			
			//Test pour voir si on arrive bien sur Créer Calendrier
			assertTrue(page_Calendrier.creercalendrier.isDisplayed());
			
			//Test pour voir s'il existe bien un formulaire de saisie des caractéristiques du calendrier dans un onglet "Données de calendrier"
			assertTrue(page_Calendrier.donneescalendrier.isDisplayed());
			
			//Test pour voir si les boutons "Enregistrer" "Enregistrer et continuer" et "Annuler" sont affichés. 
			assertTrue("Le bouton 'Enregristrer' est manquant", page_Calendrier.btn_enr.isDisplayed());
			assertTrue("Le bouton 'Enregristrer et continuer' est manquant", page_Calendrier.btn_enretcon.isDisplayed());
			assertTrue("Le bouton 'Annuler' est manquant", page_Calendrier.btn_annuler.isDisplayed());
			
			OutilTechnique.remplirChamp(page_Calendrier.champ_nom, nom_calendrier);
			assertTrue("La checkbox 'Générer le code n'est pas cochée'", page_Calendrier.checkbox_gencode.isSelected());
				
			page_Calendrier.btn_enr.click();
			
			// Attente temps de chargement de la page
			wait.until(ExpectedConditions.visibilityOf(page_Calendrier.listecalendrier));
			
			//Test pour voir si on arrive bien sur la page Liste des calendriers
			assertTrue("On ne retourne pas sur la Liste de Calendriers", page_Calendrier.listecalendrier.isDisplayed());
			//Vérifie la présence du calendrier Test 1 créé
			assertTrue(page_Calendrier.calendriertest1.isDisplayed());
			
			// Cliquer sur créer une dérive  dans la colonne opération pour le calendrier "Calendrier - Test 1"
			ligne = OutilTechnique.retournerNumeroDeLigne(driver, nom_calendrier, page_Calendrier.xpath_tableau1);
			driver.findElement(By.xpath("//tr["+ligne+"]//img[@src='/libreplan/common/img/ico_derived1.png']")).click();
			
			//Test pour voir si on arrive bien sur Créer Calendrier	
			assertTrue(page_Calendrier.creercalendrier.isDisplayed());
			
			//Vérifier le contenu des champs Nom/Type dans la création dérive
			assertEquals("", page_Calendrier.champ_nom.getText());
			assertEquals("Dérivé du calendrier Calendrier - Test 1", page_Calendrier.champ_type.getText());
			
			//Remplir le champ nom, vérifier que la box soit bien checkée
			OutilTechnique.remplirChamp(page_Calendrier.champ_nom, nom_calendrier);
			assertTrue("La checkbox 'Générer le code n'est pas cochée'", page_Calendrier.checkbox_gencode.isSelected());
			//Cliquer sur le bouton Enregistrer et continuer
			page_Calendrier.btn_enretcon.click();
			
			// Attente temps de chargement de la page
			//wait.until(ExpectedConditions.visibilityOf(page_Calendrier.listecalendrier));
			
			assertTrue("Le message d'erreur est absent", page_Calendrier.msg_cal_existant.isDisplayed());
			
			wait.until(ExpectedConditions.visibilityOf(page_Calendrier.creerCalendrier));
			
			//Remplir le champ nom, vérifier que la box soit bien checkée (le champ nom change de xpath quand on supprime son contenu)
			 
			page_Calendrier.champ_nom.clear();
			page_Calendrier.champ_nom1.sendKeys(nom_calendrier1);
			
			assertTrue("La checkbox 'Générer le code n'est pas cochée'", page_Calendrier.checkbox_gencode.isSelected());
			//Cliquer sur le bouton Enregistrer et continuer
			page_Calendrier.btn_enretcon.click();	
			
			//Test pour voir si on arrive bien sur Créer Calendrier	
			assertTrue(page_Calendrier.creercalendrierderive.isDisplayed());
			assertTrue (page_Calendrier.msg_cal_derive.isDisplayed());
			
			assertTrue(page_Calendrier.btn_annuler1.isDisplayed());
			page_Calendrier.creercalendrierderive.click();
			PageFactory.initElements(driver, PageCalendrier.class);
			
			wait.until(ExpectedConditions.elementToBeClickable(page_Calendrier.btn_annuler1));
			
			b.moveToElement(page_Calendrier.btn_annuler1).build().perform();
			b.moveToElement(page_Calendrier.btn_annuler1).click().build().perform();	
								
			page_Calendrier.btn_annuler1.click();
			
			
			// Pour cliquer sur btn_annuler1 test ok mais ne fonctionne pas
						
			Thread.sleep(pause);
}
}