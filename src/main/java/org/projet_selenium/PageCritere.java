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
	
	@FindBy (xpath = "//table//div[@class='z-column-cnt'][text()='Opérations']")
	WebElement button_creer;

}
