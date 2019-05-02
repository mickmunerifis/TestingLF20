package it.ifis.test.lf20.ui;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import it.ifis.test.lf20.models.EnumButton;
import it.ifis.test.lf20.models.EnumHtmlTag;
import net.serenitybdd.core.pages.PageObject;

/**
 * Button.
 */
public class ButtonPage extends PageObject {

	/**
	 * Click button (if enabled).
	 *
	 * @param label the button label
	 */
	public void clickButton(EnumButton label) {
		System.out.println("Find button: " + label);

		boolean buttonClicked = false;

		// cerca il bottone tra tutti gli arch-button.
		List<WebElement> archButtons = getDriver().findElements(By.tagName(EnumHtmlTag.ARCH_BUTTON.getName()));
		for (WebElement archButton : archButtons) {
			System.out.println("Button: " + archButton.getAttribute(EnumHtmlTag.LABEL.getName()) + " --- enabled: "
					+ archButton.isEnabled());
			if (label.getName().equals(archButton.getAttribute(EnumHtmlTag.LABEL.getName()))) {
				// clicca il bottone
				System.out.println("Button found");
				WebElement button = archButton.findElement(By.tagName(EnumHtmlTag.BUTTON.getName()));
				if (button.isEnabled()) {
					button.click();
					buttonClicked = true;
					break;
				}
			}
		}

		// se il bottone non è stato cliccato --> assert FALSE
		if (!buttonClicked) {
			assertTrue(false);
		}
	}
}
