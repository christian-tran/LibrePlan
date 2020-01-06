package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageParticipants extends PageAbstractBandeau {
	
	@FindBy (xpath = "//div[text()='Liste des participants']")
	WebElement text_page_participants;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Surnom']")
	WebElement surnom;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Prénom']")
	WebElement prenom;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='ID']")
	WebElement id;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Code']")
	WebElement code;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='En file']")
	WebElement en_file;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Opérations']")
	WebElement operations;
	
	@FindBy (xpath = "//table//input[@class='z-bandbox-inp'][contains(@style,'width')]")
	WebElement champ_filtre;
	
	@FindBy (xpath = "//table//input[contains(@style,'width')]/following-sibling::i[contains(@class,'z-bandbox-btn')]")
	WebElement icone_loupe;
	
	@FindBy (xpath = "//table//input[@class='z-textbox'][contains(@style,'200')]")
	WebElement champ_details;
	
	@FindBy (xpath = "//table//td[@class='z-caption-l'][contains(., 'options')]")
	WebElement boutton_options;
	
	@FindBy (css = ".z-groupbox-cnt")
	WebElement boutton_options_couleur;
	
	@FindBy (xpath = "//table//td[@class='z-button-cm'][text()='Filtre']")
	WebElement boutton_filtre;
	
	@FindBy (xpath = "//table//span[@class='z-button']//tbody")
	WebElement boutton_filtre_couleur;	
	
	@FindBy (xpath = "//div[contains(@class,'clickable-rows')]/following-sibling::span//td[text()='Créer']")
	WebElement boutton_creer;
	
	@FindBy (xpath = "//td[text()='Créer un participant']")
	WebElement text_page_participants_creer;
	
	@FindBy (xpath = "//span[text()='Données personnelles']")
	WebElement onglet_donnees_perso;
	
	@FindBy (xpath = "//tr[@class='z-row z-grid-odd']//input[contains(@class,'z-textbox')][@style='width:500px;']")
	WebElement input_prenom_participant;
	
	@FindBy (xpath = "//span[text()='Nom']/following::input[@class='z-textbox'][@style='width:500px;']")
	WebElement input_nom_participant;
	
	@FindBy (xpath = "//tbody[@class='z-rows']/tr[@class='z-row z-grid-odd']//span[text()='ID']/ancestor::tr/td[2]//input")
	WebElement input_ID_participant;
	
	@FindBy (xpath = "//input[@type='radio']/following-sibling::label[text()='Créer un nouvel utilisateur']")
	WebElement bouton_radio_creer;
	
	//a revoir
	@FindBy (xpath = "//span[contains(text(), 'utilisateur')]/following::input[@class='z-textbox']")
	WebElement input_nom_user_participant;

}
