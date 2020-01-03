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
	long pause = 7000;
	
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
		
		//Mouse-over et accès page critères
		Actions a = new Actions(driver);
		a.moveToElement(page_Accueil.onglet_ressources).build().perform();
		a.moveToElement(page_Accueil.sous_menu_critere).click().build().perform();	
		PageCritere page_Critere = PageFactory.initElements(driver, PageCritere.class);
		
		//Test si on se trouve bien dans la page criteres
		assertEquals("La page Critère n'a pas été affiché", "Types de critères Liste", page_Critere.text_page_criteres.getText());
		
		//Tests sur les noms des colonnes
		assertEquals("Le tableau n'est pas bien affiché, la colonne Nom est manquante", "Nom", page_Critere.nom.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Code est manquante", "Code", page_Critere.code.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Type est manquante", "Type", page_Critere.type.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Activé est manquante", "Activé", page_Critere.active.getText());
		assertEquals("Le tableau n'est pas bien affiché, la colonne Opérations est manquante", "Opérations", page_Critere.operations.getText());
		
		//Test si le bouton créé est présent
		
		Thread.sleep(pause);
		
	}

}
