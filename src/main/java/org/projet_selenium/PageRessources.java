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
	
	//Elements de page apres click creer
	//libellés du tableau
	@FindBy (xpath = "//td[@class='z-caption-l']")
	WebElement titre_type_avancement ;
	
	@FindBy (xpath = "//span[@class='z-tab-text']")
	WebElement tab_modif ;
	
	@FindBy (xpath = "//span[contains(text(),\"Nom d'unité\")]")
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
	
	//Données du tableau à vérifier
	@FindBy (xpath = "//input[@class='focus-element z-textbox z-textbox-focus']")
	WebElement champ_nom_unit ;
	
	@FindBy (xpath = "//tr[@class='z-row z-grid-odd']//input")
	WebElement checkbox_actif ;
	
	@FindBy (xpath = "//tr[@class='z-row']//input[@class='z-decimalbox']")
	WebElement champ_val_max ;
	
	@FindBy (xpath = "//tr[@class='z-row z-grid-odd']//input[@class='z-decimalbox']")
	WebElement champ_precision ;
	
	@FindBy (xpath = "//span[contains(text(),'User')]")
	WebElement champ_type ;
	
	@FindBy (xpath = "//tr[6]//td[2]//div[1]//span//input")
	WebElement checkbox_pourcentage ;
	
	@FindBy (xpath = "//td[contains(text(),'Enregistrer')]")
	WebElement bouton_enregistrer ;
	
	@FindBy (xpath = "//td[contains(text(),'Sauver et continuer')]")
	WebElement bouton_sauver_continuer ;
	
	@FindBy (xpath = "//td[contains(text(),'Annuler')]")
	WebElement bouton_annuler ;
		
	@FindBy (xpath = "//div[contains(text(),\"Types d'avancement Liste\")]")
	WebElement titre_liste_avancement ;
	
	@FindBy (xpath = "//div[@class='message_INFO']")
	WebElement enregistrement_confirm ;
	
	@FindBy (xpath = "//span[contains(text(),\"Type d'avancement - Test 1\")]")
	WebElement avancement_cree_tab ;
	
	//tr[@class='clickable-rows z-row z-grid-odd']//td[2]//div[1]//span[1]//input[1]
	//tr[@class='clickable-rows z-row z-grid-odd']//td[2]//div[1]//span[1]//input[1]
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}