package it.ifis.test.lf20.ui;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import it.ifis.test.lf20.models.Popup;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;


/**
 * Popup.
 */
public class PopupPage extends PageObject {
	
	/** The common page. */
	private CommonPage commonPage;
	
	/**
	 * Checks for popup.
	 *
	 * @param popup the popup
	 * @return true, if successful
	 */
	public boolean hasPopup(Popup popup) {
		return commonPage.isElementPresent(By.id(popup.getPopupName())) && isElementVisible(By.id(popup.getPopupName()));
	}

	/**
	 * Close popup with esc.
	 *
	 * @param popup the popup
	 */
	public void closePopupWithEsc(Popup popup) {
		System.out.println("***** closePopupWithEsc 0");
		WebElement popupElement = getDriver().findElement(By.id(popup.getPopupName()));
		System.out.println("***** closePopupWithEsc, " + popup + ": " + popupElement);
		Actions actions = new Actions(getDriver());
		actions.sendKeys(Keys.ESCAPE).perform();

		while(hasPopup(popup)) {
			// wait
		}
		
		System.out.println("***** closePopupWithEsc, " + popup + ": 999" );
	}
}
