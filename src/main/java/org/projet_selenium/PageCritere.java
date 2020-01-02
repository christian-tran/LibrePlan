package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCritere extends PageAbstractBandeau {
	
	@FindBy (xpath = "//div[text()='Type']")
	WebElement type;

}
