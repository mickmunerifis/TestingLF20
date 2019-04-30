package it.ifis.test.lf20.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import it.ifis.test.lf20.models.EnumPopup;
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
	public boolean hasPopup(EnumPopup popup) {
		boolean hasPopup = commonPage.isElementPresent(By.id(popup.getPopupName()))
				&& isElementVisible(By.id(popup.getPopupName()));
//		System.out.println("hasPopup " + popup + ": " + hasPopup);
		return hasPopup;
	}

	/**
	 * Close popup with esc.
	 *
	 * @param popup the popup
	 */
	public void closePopupWithEsc(EnumPopup popup) {
		WebElement popupElement = getDriver().findElement(By.id(popup.getPopupName()));
		System.out.println("closePopupWithEsc, " + popup + ": " + popupElement);
		Actions actions = new Actions(getDriver());
		actions.sendKeys(Keys.ESCAPE).perform();

//		if (hasPopup(popup))
//			waitForRenderedElementsToDisappear(By.id(popup.getPopupName()));

		while (hasPopup(popup)) {
			// wait
		}

		System.out.println("closePopupWithEsc, " + popup + " - END");
	}

	/**
	 * Wait for spinner and courtesy dialog.
	 */
	public void waitForSpinnerAndCourtesyDialog() {
		if (commonPage.hasSpinner())
			commonPage.waitEndOfSpinner();

		if (hasPopup(EnumPopup.COURTESY_TEST_ENVIRONMENT))
			closePopupWithEsc(EnumPopup.COURTESY_TEST_ENVIRONMENT);
	}
}
