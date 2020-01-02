package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageAbstractBandeau {
	
	@FindBy (xpath = "//button[contains(.,'Ressources')]")
	WebElement onglet_ressources;
	
	@FindBy (xpath = "//button[contains(.,'Calendrier')]")
	WebElement onglet_calendrier;
	
	@FindBy (xpath = "//a[@href='/libreplan/resources/criterions/criterions.zul']")
	WebElement onglet_critere;

}
