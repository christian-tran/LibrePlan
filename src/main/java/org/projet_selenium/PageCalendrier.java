package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageCalendrier extends PageAbstractBandeau {
	
@FindBy (xpath = "//*[text() = 'Liste de calendriers']")
WebElement listecalendrier;

@FindBy (xpath = "//td[contains(.,'Créer Calendrier')]")
WebElement creerCalendrier;
	
@FindBy (xpath = "//table//div[@class='z-treecol-cnt'][text()='Nom']")
WebElement nom;

@FindBy (xpath = "//table//div[@class='z-treecol-cnt'][text()='Hérité de la date']")
WebElement herite;

@FindBy (xpath = "//table//div[@class='z-treecol-cnt'][text()='Héritages à jour']")
WebElement heritages;

@FindBy (xpath = "//table//div[@class='z-treecol-cnt'][text()='Opérations']")
WebElement operations;

@FindBy (xpath = "//table[@style='width:100%;height:100%']//td[text()='Créer']")
WebElement btn_creer;

@FindBy (xpath = "//*[text() = 'Créer Calendrier']")
WebElement creercalendrier;

@FindBy (xpath = "//span[@class='z-tab-text'][text() = 'Données de calendrier']")
WebElement donneescalendrier;

@FindBy (xpath = "//table//td[text()='Enregistrer']")
WebElement btn_enr;

@FindBy (xpath = "//table//td[text()='Enregistrer et continuer']")
WebElement btn_enretcon;

@FindBy (xpath = "//table//td[text()='Annuler']")
WebElement btn_annuler;

@FindBy (xpath = "//input[@class='z-textbox']")
WebElement champ_nom;

@FindBy (xpath = "//input[@class='z-textbox z-textbox-text-invalid']")
WebElement champ_nom1;

@FindBy (xpath = "//span[@class='z-checkbox']/label[text()='Générer le code']/preceding::input[@type='checkbox']")
WebElement checkbox_gencode;

@FindBy (xpath = "//span[@class='z-label'][text()='Calendrier - Test 1']")
WebElement calendriertest1;

String xpath_tableau1 = "//div[@class='z-dottree-body']//table//tbody[@class='z-treechildren']//tr[@class='z-treerow']";

@FindBy (xpath = "//span[@class='z-label'][text()='Dérivé du calendrier Calendrier - Test 1']")
WebElement champ_type;

@FindBy (xpath = "//span[@class='z-label'][text() = 'Calendrier - Test 1 existe déjà']")
WebElement msg_cal_existant;

@FindBy (xpath = "//*[text() = 'Créer Calendrier: Calendrier - Test Calendrier Derive']")
WebElement creercalendrierderive;

@FindBy (xpath = "//*[text() = 'Calendrier de base \"Calendrier - Test Calendrier Derive\" enregistré']")
WebElement msg_cal_derive;

}

