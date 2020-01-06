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
	
	@FindBy (xpath = "//div[@class='z-row-cnt z-overflow-hidden']//input[@class='z-textbox']")
	WebElement input_nom_critere;
	
	@FindBy (xpath = "//textarea[@class='z-textbox']")
	WebElement input_desc_critere;
	
	@FindBy (xpath = "//i[@class='z-combobox']/input")
	WebElement combobox_type;
	
	@FindBy (xpath = "//img[@class='tick']/following-sibling::span[contains(.,'continuer')]")
	WebElement text_confirmation_action_sauver_continuer;
	
	@FindBy (xpath = "//td[@class='z-caption-l']")
	WebElement text_modification_critere;
	
	@FindBy (xpath = "//span[@title='Critère - Test bouton [Sauver et continuer]']")
	WebElement nom_button_sauver_continuer;
	
	@FindBy (xpath = "//div[@class='z-messagebox']//span[@class='z-label']")
	WebElement message_pop_up_suppression;
	
	@FindBy (xpath = "//td[text()='OK']")
	WebElement button_ok_pop_up;
	
	@FindBy (xpath = "//div[@class='z-window-modal-cm']//td[text()='Annuler']")
	WebElement button_annuler_pop_up;
	
	@FindBy (xpath = "//div[@class='z-window-modal-header z-window-modal-header-move']")
	WebElement pop_up_supprimer;
	
	@FindBy (xpath = "//span[contains(.,'[Sauver et continuer]2\" supprimé')]")
	WebElement text_suppression_critere;
	
	
	String xpath_tableau = "//div[@class='clickable-rows z-grid']//table//tbody[@class='z-rows']/tr";

}
