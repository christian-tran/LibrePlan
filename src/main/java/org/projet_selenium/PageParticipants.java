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
	
	@FindBy (xpath = "//table//td[@class='z-button-cm'][text()='Filtre']")
	WebElement boutton_filtre;
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Opérations']")
	WebElement button_creer;

}
