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
}
