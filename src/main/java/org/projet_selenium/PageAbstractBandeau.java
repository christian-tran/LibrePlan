package org.projet_selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageAbstractBandeau {
	
	@FindBy (xpath = "//button[contains(.,'Ressources')]")
	WebElement onglet_ressources;
	
	@FindBy (xpath = "//button[contains(.,'Calendrier')]")
	WebElement onglet_calendrier;
	
	@FindBy (xpath = "//a[@href='/libreplan/resources/criterions/criterions.zul']")
	WebElement sous_menu_critere;
	
	@FindBy (xpath = "//a[@href='/libreplan/calendars/calendars.zul']")
	WebElement sous_menu_calendrier;
	
	@FindBy (xpath = "//a[@href='/libreplan/resources/worker/worker.zul']")
	WebElement sous_menu_participants;

	@FindBy (xpath = "button[contains(text(),'Coût')]")
	WebElement onglet_cout;

	@FindBy (xpath = "//button[contains(text(),'Configuration')]")
	WebElement onglet_configutation;

	@FindBy (xpath = "//button[contains(text(),'Communications')]") 
	WebElement onglet_communication;

	@FindBy (xpath = "//button[contains(text(),'Rapports')]") 
	WebElement onglet_rapports;

	@FindBy (xpath = "//button[contains(text(),'Zone personnelle')]") 
	WebElement onglet_zoneperso;

	@FindBy (xpath = "//a[@class='z-menu-item-cnt'][contains(text(),\"Types d'avancement\")]") 
	WebElement sous_menu_types_avancement;
	
	@FindBy (xpath = "//a[text()='[Déconnexion]']") 
	WebElement button_logout;









}
