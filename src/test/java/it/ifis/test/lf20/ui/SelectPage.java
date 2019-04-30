package it.ifis.test.lf20.ui;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import it.ifis.test.lf20.models.HtmlTag;
import it.ifis.test.lf20.models.Select;
import net.serenitybdd.core.pages.PageObject;

/**
 * Select.
 */
public class SelectPage extends PageObject {

	/**
	 * Clicca un'option di una select.
	 *
	 * @param select the select
	 * @param option the option
	 */
	public void selectOption(Select select, Select option) {
		System.out.println("Find select: " + select);
		System.out.println("Click option: " + option);

		boolean optionClicked = false;

		// trova la select richiesta
		List<WebElement> selects = getDriver().findElements(By.tagName(HtmlTag.ARCH_SELECT.getName()));
		for (WebElement _select : selects) {
			System.out.println("Select: " + _select.getAttribute(HtmlTag.LABEL.getName()));

			if (_select.getAttribute(HtmlTag.LABEL.getName()) != null
					&& select.getName().equals(_select.getAttribute(HtmlTag.LABEL.getName()))) {
				// clicca la select
				System.out.println("Select found");
				_select.findElement(By.tagName(HtmlTag.MD_SELECT.getName())).click();

				// trova la option richiesta
				WebElement optionContainer = getDriver().findElement(
						By.cssSelector("*[class='md-select-menu-container md-default-theme md-active md-clickable']"));
				List<WebElement> options = optionContainer.findElements(By.tagName(HtmlTag.MD_OPTION.getName()));
				for (WebElement _option : options) {
					System.out.println("Option: " + _option.getAttribute(HtmlTag.VALUE.getName()));

					if (_option.getAttribute(HtmlTag.VALUE.getName()) != null
							&& option.getName().equals(_option.getAttribute(HtmlTag.VALUE.getName()))) {
						// clicca l'option
						System.out.println("Option found");
						Actions action = new Actions(getDriver());
						action.moveToElement(_option).click(_option).build().perform();
						optionClicked = true;
						break;
					}
				}
			}

			// se l'option è stata cliccata --> esci dal FOR
			if (optionClicked) {
				break;
			}
		}

		// se la option non è stata cliccata --> assert FALSE
		if (!optionClicked) {
			assertTrue(false);
		}
	}
}
