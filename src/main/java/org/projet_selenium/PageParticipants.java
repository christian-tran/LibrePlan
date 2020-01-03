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
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Opérations']")
	WebElement button_creer;

}
