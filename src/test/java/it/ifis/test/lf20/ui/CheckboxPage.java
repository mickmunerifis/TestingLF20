package it.ifis.test.lf20.ui;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import it.ifis.test.lf20.models.Checkbox;
import it.ifis.test.lf20.models.HtmlTag;
import net.serenitybdd.core.pages.PageObject;

/**
 * Checkbox.
 */
public class CheckboxPage extends PageObject {

	/**
	 * Click a checkbox. <br>
	 * Se il webELement viene passato allora il checkboxName verrà ignorato e si
	 * cercherà l'unica checkbox contenuta nel webELement <br>
	 * Se il webELement non viene passato allora si cercheranno tra tutte le
	 * checkbox quella con la label uguale a checkboxName.
	 *
	 * @param webElement   the web element that contains the checkbox
	 * @param checkboxName the checkboxn name to click
	 */
	public void clickCheckbox(WebElement webElement, Checkbox checkboxName) {
		System.out.println("Find checkbox: " + checkboxName);

		boolean checkboxClicked = false;

		// se l'elemento web non è stato passato cerca la checkbox dal driver.
		if (webElement != null) {
			WebElement checkbox = webElement.findElement(By.tagName(HtmlTag.MD_CHECKBOX.getName()));

			// clicca la checkbox
			if (checkbox != null) {
				System.out.println("Checkbox found");

				Actions action = new Actions(getDriver());
				action.moveToElement(checkbox).click(checkbox).build().perform();
				checkboxClicked = true;
			}
		} else {
			checkboxClicked = clickCheckbox(checkboxName,
					getDriver().findElements(By.tagName(HtmlTag.MD_CHECKBOX.getName())));
		}

		// se la checkbox non è stata cliccata --> assert FALSE
		if (!checkboxClicked) {
			assertTrue(false);
		}
	}

	/**
	 * Click checkbox.
	 *
	 * @param checkboxName il nome della checkbox da cliccare
	 * @param checkboxes   la lista di checkbox in cui cercare
	 * @return true, se la checkbox è stata cliccata
	 */
	private boolean clickCheckbox(Checkbox checkboxName, List<WebElement> checkboxes) {
		// trova la checkbox richiesta
		for (WebElement checkbox : checkboxes) {
			System.out.println("Checkbox: " + checkbox.getAttribute(HtmlTag.ARIA_LABEL.getName()));

			if (checkbox.getAttribute(HtmlTag.ARIA_LABEL.getName()) != null
					&& checkboxName.getName().equals(checkbox.getAttribute(HtmlTag.ARIA_LABEL.getName()))) {
				// clicca la checkbox
				System.out.println("Checkbox found");

				Actions action = new Actions(getDriver());
				action.moveToElement(checkbox).click(checkbox).build().perform();
				return true;
			}
		}
		return false;
	}
}
