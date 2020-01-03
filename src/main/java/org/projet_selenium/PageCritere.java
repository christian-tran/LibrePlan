package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCritere extends PageAbstractBandeau {
	
	@FindBy (xpath = "//div[text()='Types de critères Liste']")
	WebElement text_page_criteres;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Nom']")
	WebElement nom;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Code']")
	WebElement code;
	
	@FindBy (xpath = "//table//div[text()='Type']")
	WebElement type;
	
	@FindBy (xpath = "//table//div[text()='Activé']")
	WebElement active;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Opérations']")
	WebElement operations;
	
	@FindBy (xpath = "//td[@class='z-button-cm'][text()='Créer']")
	WebElement button_creer;
	
	@FindBy (xpath = "//td[text()='Créer Type de critère']")
	WebElement text_page_criteres_creer;
	
	@FindBy (xpath = "//span[text()='Modifier']")
	WebElement onglet_modifier;
	
	@FindBy (xpath = "//td[text()='Enregistrer']")
	WebElement button_enregistrer;
	
	@FindBy (xpath = "//td[text()='Sauver et continuer']")
	WebElement button_sauver_continuer;
	
	@FindBy (xpath = "//td[text()='Annuler']")
	WebElement button_annuler;

}
