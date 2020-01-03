package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCalendrier extends PageAbstractBandeau {
	
@FindBy (xpath = "//*[text() = 'Liste de calendriers']")
	WebElement listecalendrier;
	
}
