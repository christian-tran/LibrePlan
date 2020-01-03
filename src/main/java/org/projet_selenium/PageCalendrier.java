package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCalendrier extends PageAbstractBandeau {
	
@FindBy (xpath = "//*[text() = 'Liste de calendriers']")
	WebElement listecalendrier;
	
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
}
