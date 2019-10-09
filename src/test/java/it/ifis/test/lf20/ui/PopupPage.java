package it.ifis.test.lf20.ui;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import TestingLF.test.App;
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

		WebElement dialogContainer = getDriver().findElement(By.cssSelector("*[class='md-dialog-container ng-scope']"));
		dialogContainer.click();
		dialogContainer.sendKeys(Keys.ESCAPE);

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

		Properties prop = new Properties();
		try {
			prop.load(App.class.getClassLoader().getResourceAsStream("serenity.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		EnumPopup popup = EnumPopup.COURTESY_TEST_ENVIRONMENT;
		if (hasPopup(popup))
			closePopupWithEsc(popup);
	}
}
