package org.projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends PageAbstractBandeau {
	
	@FindBy (xpath = "//input[@name='j_username']")
	WebElement username_field;
	
	@FindBy (xpath = "//input[@name='j_password']")
	WebElement password_field;
	
	@FindBy (xpath = "//input[@name='button']")
	WebElement connect_button;
	
public PageAccueil logIn(WebDriver driver, String username, String password) {
		
	    OutilTechnique.remplirChamp(username_field, username);
	    OutilTechnique.remplirChamp(password_field, password);
	    connect_button.click();
	  return PageFactory.initElements(driver, PageAccueil.class);
	  
	}

}
