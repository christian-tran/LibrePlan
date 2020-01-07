package org.projet_selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.poi.sl.draw.geom.Outline;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestParticipants {
	
	WebDriver driver;
	
	//JDD
	String onglet = "Calendrier";
	long pause = 1000;
	String prenom = "Jean";
	String nom = "DU";
	String id = "jdu";
	String pwd = "$jdumdp1";
	
	static Logger logger = LoggerFactory.getLogger(TestParticipants.class);
	
	@Before
	public void setUp() throws Exception {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		OutilTechnique.connexion();		
	}
	
	//@After
	public void tearDown() throws Exception {
		
		driver.quit();
		
		//Nettoyage BDD
				BDDConnexionJavaSql.modifBDD("src/test/JDD/Sauvegarde_user_table.sql");
				BDDConnexionJavaSql.modifBDD("src/test/JDD/Sauvegarde_worker.sql");
				BDDConnexionJavaSql.modifBDD("src/test/JDD/Sauvegarde_resource.sql");
				BDDConnexionJavaSql.modifBDD("src/test/JDD/Sauvegarde_resource_calendar.sql");
				BDDConnexionJavaSql.modifBDD("src/test/JDD/Sauvegarde_base_calendar.sql");
				BDDConnexionJavaSql.modifBDD("src/test/JDD/Sauvegarde_calendar_availability.sql");
				BDDConnexionJavaSql.modifBDD("src/test/JDD/Sauvegarde_calendar_data.sql");				
	}
	
	@Test
	public void gre01() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
	//Pas de test 1
		PageAccueil page_Accueil = PageFactory.initElements(driver, PageAccueil.class) ;
		
		//Test pour voir si le login s'est bien déroulé
		assertTrue(page_Accueil.onglet_calendrier.isDisplayed());
		
		OutilTechnique.takeSnapShot(driver, ".\\src\\test\\snapshots\\GRE_01_01.png");
		
	//Pas de test 2
		
		//Mouse-over et accès page Participants
		Actions a = new Actions(driver);
		a.moveToElement(page_Accueil.onglet_ressources).build().perform();
		a.moveToElement(page_Accueil.sous_menu_participants).click().build().perform();	
		PageParticipants page_Participants = PageFactory.initElements(driver, PageParticipants.class);
		
		//Création des 15 personnes
		
		/*for (int i=1;i<=15;i++) {
			page_Participants.boutton_creer.click();
			wait.until(ExpectedConditions.elementToBeClickable(page_Participants.input_prenom_participant));
			OutilTechnique.remplirChamp(page_Participants.input_prenom_participant, "Prénom"+i);
			OutilTechnique.remplirChamp(page_Participants.input_nom_participant, "Nom"+i);
			OutilTechnique.remplirChamp(page_Participants.input_ID_participant, "pno"+i);
			
			page_Participants.boutton_enregistrer.click();
			wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
		}*/
		
		OutilTechnique.takeSnapShot(driver, ".\\src\\test\\snapshots\\GRE_01_02.png");
		
		//Test si on se trouve bien sur la page Participants
		assertEquals("La page Participants n'a pas été affiché", "Liste des participants", page_Participants.text_page_participants.getText());
		
		//Tests sur les noms des colonnes
		assertEquals("Le tableau n'est pas bien affiché, la colonne Surnom est différente", "Surnom", page_Participants.surnom.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Prénom est différente", "Prénom", page_Participants.prenom.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne ID est différente", "ID", page_Participants.id.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Code est différente", "Code", page_Participants.code.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne En file est différente", "En file", page_Participants.en_file.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Opérations est différente", "Opérations", page_Participants.operations.getText());
		
		assertTrue("Le tableau n'est pas bien affiché, la colonne Surnom n'est pas affiché", page_Participants.surnom.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne Prénom n'est pas affiché", page_Participants.prenom.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne ID n'est pas affiché", page_Participants.id.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne Code n'est pas affiché", page_Participants.code.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne En file n'est pas affiché", page_Participants.en_file.isDisplayed());
		assertTrue("Le tableau n'est pas bien affiché, la colonne Opérations n'est pas affiché", page_Participants.operations.isDisplayed());
		
		 //Tests champ de recherche "Filtré par"
		
		assertTrue("Le champ de recherche 'Filtré par' n'est pas affiché", page_Participants.champ_filtre.isDisplayed());
		assertTrue("L'icône loupe n'est pas affichée", page_Participants.icone_loupe.isDisplayed());
			
		//Test champ de recherche "Détails personnels"
		assertTrue("Le champ de recherche 'Détails personnels' n'est pas affiché", page_Participants.champ_details.isDisplayed());
		
		//Tests si un bouton bleu [Plus d'options] est présent
		assertTrue("Le bouton 'Plus d'options' n'est pas affiché", page_Participants.boutton_options.isDisplayed());
//		System.out.println(page_Participants.boutton_options_couleur.getCssValue("background-color"));
		if(OutilTechnique.navigateur==("Firefox")) {
			assertEquals("Le bouton 'Plus d'options' n'est pas bleu", "rgb(240, 250, 255)", page_Participants.boutton_options_couleur.getCssValue("background-color"));
		}
		else if (OutilTechnique.navigateur==("Chrome")) {
			assertEquals("Le bouton 'Plus d'options' n'est pas bleu", "rgba(240, 250, 255, 1)", page_Participants.boutton_options_couleur.getCssValue("background-color"));
		}
		
		//Tests si un bouton vert [Filtre] est présent
		assertTrue("Le bouton 'Filtre' n'est pas affiché", page_Participants.boutton_filtre.isDisplayed());
//		System.out.println(page_Participants.boutton_filtre_couleur.getCssValue("background-color"));
		if(OutilTechnique.navigateur==("Firefox")) {
			assertEquals("Le bouton 'Filtre' n'est pas vert", "rgb(228, 243, 217)", page_Participants.boutton_filtre_couleur.getCssValue("background-color"));
		}
		else if (OutilTechnique.navigateur==("Chrome")) {
			assertEquals("Le bouton 'Filtre' n'est pas vert", "rgba(228, 243, 217, 1)", page_Participants.boutton_filtre_couleur.getCssValue("background-color"));
		}
				
		//Test si le bouton créer est présent
		assertTrue("Le bouton créer n'est pas affiché", page_Participants.boutton_creer.isDisplayed());
			
	//Pas de test 3
		
		//Clic sur le bouton créer
		page_Participants.boutton_creer.click();
		
		OutilTechnique.takeSnapShot(driver, ".\\src\\test\\snapshots\\GRE_01_03.png");
		
		//Test si on se trouve bien sur la page de création de participants
		assertEquals("La page de création de participants n'a pas été affiché","Créer un participant",page_Participants.text_page_participants_creer.getText());
		
		//Test si l'onglet affiché par défaut est "Données personnelles"
		assertTrue("L'onglet affiché par défaut n'est pas Données personnelles", page_Participants.onglet_donnees_perso.isEnabled());

	//Pas de test 5
		
		//Test renseigner les champs du formulaire Données personnelles
				wait.until(ExpectedConditions.elementToBeClickable(page_Participants.input_prenom_participant));
				OutilTechnique.remplirChamp(page_Participants.input_prenom_participant, prenom);
				wait.until(ExpectedConditions.elementToBeClickable(page_Participants.input_nom_participant));
				OutilTechnique.remplirChamp(page_Participants.input_nom_participant, nom);
				wait.until(ExpectedConditions.elementToBeClickable(page_Participants.input_ID_participant));
				OutilTechnique.remplirChamp(page_Participants.input_ID_participant, id);
				
				page_Participants.bouton_radio_creer.click();
				
				OutilTechnique.remplirChamp(page_Participants.input_nom_user_participant, id);
				OutilTechnique.remplirChamp(page_Participants.input_mdp_participant, pwd);
				OutilTechnique.remplirChamp(page_Participants.input_mdp_confirm_participant, pwd);
				
		//Clic sur bouton enregistrer		
				page_Participants.boutton_enregistrer.click();
				
				OutilTechnique.takeSnapShot(driver, ".\\src\\test\\snapshots\\GRE_01_05.png");
		
		//Test si le message "Participant enregistré" est affiché et utilisateur créé
				assertEquals("Le message n'est pas affiché","Participant enregistré",page_Participants.message_enregistrement_participant.getText());
				assertTrue("L'utilisateur n'a pas été créé",page_Participants.nom_utilisateur_DU.isDisplayed());
				
		//Remplissage champ détail personnel
				OutilTechnique.remplirChamp(page_Participants.champ_detail_personnel, prenom);
				page_Participants.boutton_filtre.click();
				
		//Test utilisateur Jean affiché
				assertTrue("L'utilisateur n'a pas été créé",page_Participants.prenom_utilisateur_Jean.isDisplayed());
				
		//Clic sur plus d'option
				page_Participants.boutton_options.click();
				
		//Test option affiché
				assertTrue("Le champs de début d'activité n'est pas affiché",page_Participants.champ_periode_active_debut.isDisplayed());
				assertTrue("Le champs de fin d'activité n'est pas affiché",page_Participants.champ_periode_active_fin.isDisplayed());
				assertTrue("Le champs de fin d'activité n'est pas affiché",page_Participants.liste_type.isDisplayed());
		
		//Element manquant du test
				page_Participants.champ_detail_personnel.clear();
				page_Participants.boutton_filtre.click();
				
				
		//Clic sur boutton >
				Thread.sleep(pause);
				wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
				page_Participants.boutton_suivant.click();
				
		//Vérification sur la page
				wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
				assertEquals("La page indiqué est éronné","1",page_Participants.page_participant.getAttribute("value"));
		
		//Clic sur boutton <
				Thread.sleep(pause);
				wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
				page_Participants.boutton_precedent.click();
		
		//Vérification sur la page
				Thread.sleep(pause);
				wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
				assertEquals("La page indiqué est éronné","1",page_Participants.page_participant.getAttribute("value"));
		
		//Clic sur boutton >|
				Thread.sleep(pause);
				wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
				page_Participants.boutton_dernier.click();
		
		//Vérification sur la page
				wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
				assertEquals("La page indiqué est éronné","1",page_Participants.page_participant.getAttribute("value"));
				
		//Clic sur boutton |<
				Thread.sleep(pause);
				wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
				page_Participants.boutton_premier.click();
		
		//Vérification sur la page
				wait.until(ExpectedConditions.visibilityOf(page_Participants.text_page_participants));
				assertEquals("La page indiqué est éronné","2",page_Participants.page_participant.getAttribute("value"));
				
		//Déconnexion et reconnexion en tant que jdu
				Thread.sleep(pause);
				page_Participants.button_logout.click();
				PageLogin page_Login = PageFactory.initElements(driver, PageLogin.class);
				wait.until(ExpectedConditions.visibilityOf(page_Login.username_field));
				OutilTechnique.remplirChamp(page_Login.username_field, id);
				OutilTechnique.remplirChamp(page_Login.password_field, pwd);
				page_Login.connect_button.click();
				
		//Vérification de la page tableau de bord
				PageDashBoard page_DashBoard = PageFactory.initElements(driver, PageDashBoard.class);
				wait.until(ExpectedConditions.visibilityOf(page_DashBoard.text_page_dashboard));
				assertTrue("Le user n'a pas reussi à se connecter",page_DashBoard.text_page_dashboard.isDisplayed());
				
				
		Thread.sleep(pause);
		
	}

}
