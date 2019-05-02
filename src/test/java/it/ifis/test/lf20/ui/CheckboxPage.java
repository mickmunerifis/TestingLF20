package it.ifis.test.lf20.ui;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import it.ifis.test.lf20.models.EnumCheckbox;
import it.ifis.test.lf20.models.EnumHtmlTag;
import net.serenitybdd.core.pages.PageObject;

/**
 * Checkbox.
 */
public class CheckboxPage extends PageObject {

	/**
	 * Click a checkbox. <br>
	 * Se il webELement viene passato allora il parametro checkbox verrà ignorato e si cercherà l'unica checkbox contenuta nel webELement <br>
	 * Se il webELement non viene passato allora si cercheranno tra tutte le checkbox quella con la label uguale al parametro checkbox.
	 *
	 * @param webElement the web element that contains the checkbox
	 * @param checkbox   the checkbox to click
	 */
	public void clickCheckbox(WebElement webElement, EnumCheckbox checkbox) {
		System.out.println("Find checkbox: " + checkbox);

		boolean checkboxClicked = false;

		// se l'elemento web non è stato passato cerca la checkbox dal driver.
		if (webElement != null) {
			WebElement _checkbox = webElement.findElement(By.tagName(EnumHtmlTag.MD_CHECKBOX.getName()));

			// clicca la checkbox
			if (_checkbox != null) {
				System.out.println("Checkbox found");

				Actions action = new Actions(getDriver());
				action.moveToElement(_checkbox).click(_checkbox).build().perform();
				checkboxClicked = true;
			}
		} else {
			checkboxClicked = clickCheckbox(checkbox,
					getDriver().findElements(By.tagName(EnumHtmlTag.MD_CHECKBOX.getName())));
		}

		// se la checkbox non è stata cliccata --> assert FALSE
		if (!checkboxClicked) {
			assertTrue(false);
		}
	}

	/**
	 * Click checkbox.
	 *
	 * @param checkbox   la checkbox da cliccare
	 * @param checkboxes la lista di checkbox in cui cercare
	 * @return true, se la checkbox è stata cliccata
	 */
	private boolean clickCheckbox(EnumCheckbox checkbox, List<WebElement> checkboxes) {
		// trova la checkbox richiesta
		for (WebElement _checkbox : checkboxes) {
			System.out.println("Checkbox: " + _checkbox.getAttribute(EnumHtmlTag.ARIA_LABEL.getName()));

			if (checkbox.getName().equals(_checkbox.getAttribute(EnumHtmlTag.ARIA_LABEL.getName()))) {
				// clicca la checkbox
				System.out.println("Checkbox found");

				Actions action = new Actions(getDriver());
				action.moveToElement(_checkbox).click(_checkbox).build().perform();
				return true;
			}
		}
		return false;
	}
}
