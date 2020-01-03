package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageRessources
{
	//Elements de page du sous menu "Types d'avancement"
	@FindBy (xpath = "//div[contains(text(),'Nom')]")
	WebElement col_nom ;
	
	@FindBy (xpath = "//div[contains(text(),'Activé')]")
	WebElement col_active ;

	@FindBy (xpath = "//div[contains(text(),'Prédéfini')]")
	WebElement col_predefini ;

	@FindBy (xpath = "//div[contains(text(),'Opérations')]")
	WebElement col_operations ;
	
	@FindBy (xpath = "//td[contains(text(),'Créer')]")
	WebElement button_creer ;
	
	//Element de page apres click creer
	@FindBy (xpath = "//td[@class='z-caption-l']")
	WebElement titre_type_avancement ;
	
	@FindBy (xpath = "//span[@class='z-tab-text']")
	WebElement tab_modif ;
	
	@FindBy (xpath = "//input[@class='focus-element z-textbox z-textbox-focus']")
	WebElement nom_unit ;
	
	@FindBy (xpath = "//span[contains(text(),'Actif')]")
	WebElement actif ;
	
	@FindBy (xpath = "//span[contains(text(),'Valeur maximum par défaut')]")
	WebElement val_max ;
	
	@FindBy (xpath = "//span[contains(text(),'Précision')]")
	WebElement precision ;
	
	@FindBy (xpath = "//span[@class='z-label'][contains(text(),'Type')]")
	WebElement type ;
	
	@FindBy (xpath = "//span[contains(text(),'Pourcentage')]")
	WebElement pourcentage ;
	
	@FindBy (xpath = "")
	WebElement tab_modif1 ;
	
	
	
}