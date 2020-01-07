package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageDashBoard extends PageAbstractBandeau{
	
	@FindBy (xpath = "//div[text()='Mon tableau de bord']")
	WebElement text_page_dashboard;

}
