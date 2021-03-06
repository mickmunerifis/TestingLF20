package it.ifis.test.lf20.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import it.ifis.test.lf20.models.EnumHtmlTag;
import it.ifis.test.lf20.models.EnumMenuLink;
import net.serenitybdd.core.pages.PageObject;

/**
 * Navigazione di un link del menu.
 */
public class MenuLinkNavigationPage extends PageObject {

	/**
	 * Select menu link.
	 *
	 * @param link the link
	 */
	public void selectMenuLink(EnumMenuLink link) {
		WebElement dropdown = getDriver().findElement(By.id("sub-menu-"));
		List<WebElement> options = dropdown.findElements(By.tagName(EnumHtmlTag.LI.getName()));
		for (WebElement option : options) {
			if (option.getText().indexOf(link.getMenuLinkName()) != -1) {
				option.click();
				break;
			}
		}
	}
}
