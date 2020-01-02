package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageBandeau {
	
	@FindBy (xpath = "//button[contains(.,'Ressources')]")
	WebElement button_ressources;

}
