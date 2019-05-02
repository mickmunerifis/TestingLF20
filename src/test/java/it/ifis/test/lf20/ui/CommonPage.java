package it.ifis.test.lf20.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import it.ifis.test.lf20.models.EnumButton;
import it.ifis.test.lf20.models.EnumFieldset;
import it.ifis.test.lf20.models.EnumHtmlTag;
import it.ifis.test.lf20.models.EnumInputText;
import net.serenitybdd.core.pages.PageObject;

/**
 * Utilità comuni.
 */
public class CommonPage extends PageObject {

	/** The Constant LEGAL_FACTORY. */
	public static final String LEGAL_FACTORY = "Legal Factory";

	/** The Constant FASCICOLI_PROVVISORI. */
	public static final String FASCICOLI_PROVVISORI = "Fascicoli provvisori";

	/** The Constant TAB_CRUSCOTTO. */
	public static final String TAB_CRUSCOTTO = "CRUSCOTTO";

	/** The Constant CREA_FASCICOLO. */
	public static final String CREA_FASCICOLO = "Crea fascicolo";

	/**
	 * Checks if the element is present.
	 *
	 * @param by the by
	 * @return true, if element is present
	 */
	public boolean isElementPresent(By by) {
		try {
			getDriver().findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if element is visible.
	 *
	 * @param by the by
	 * @return the boolean
	 */
	public Boolean isElementVisible(By by) {
		return getDriver().findElement(by).isDisplayed();
	}

	/**
	 * Checks for spinner.
	 *
	 * @return true, if successful
	 */
	public boolean hasSpinner() {
		boolean hasSpinner = isElementPresent(By.tagName("arch-loading"))
				&& isElementVisible(By.tagName("arch-loading"));
//		System.out.println("hasSpinner: " + hasSpinner);
		return hasSpinner;
	}

	/**
	 * Wait end of spinner.
	 */
	public void waitEndOfSpinner() {
		System.out.println("waitEndOfSpinner - START");
//		if (hasSpinner())
//			waitForRenderedElementsToDisappear(By.tagName("arch-loading"));

		while (hasSpinner()) {
			// wait
		}

		System.out.println("waitEndOfSpinner - END");
	}

	/**
	 * Page has page title.
	 *
	 * @param label the label
	 * @return true, if successful
	 */
	public boolean pageHasPageTitle(String label) {
		WebElement element = getDriver().findElement(By.cssSelector("*[pagetitle='" + label + "']"));

		return element != null;
	}

	/**
	 * Close tab.
	 *
	 * @param tabName the tab name
	 */
	public void closeTab(String tabName) {
		// trova il tab richiesto
		List<WebElement> tabs = getDriver().findElements(By.tagName(EnumHtmlTag.MD_TAB_ITEM.getName()));
		for (WebElement tab : tabs) {
			WebElement _tabName = tab.findElement(By.tagName(EnumHtmlTag.SPAN.getName()));
			if (tabName.equals(_tabName.getText())) {
				// trova la X e cliccala
				WebElement x = tab.findElement(By.tagName(EnumHtmlTag.MD_ICON.getName()));
				Actions action = new Actions(getDriver());
				action.moveToElement(x).click(x).build().perform();
				break;
			}
		}
	}

	/**
	 * Click fieldset button.
	 *
	 * @param fieldset      the fieldset
	 * @param buttonTooltip the button tooltip
	 * @return the fieldset clicked, null otherwise
	 */
	public WebElement clickFieldsetButton(EnumFieldset fieldset, EnumButton buttonTooltip) {
		// trova il fieldset richiesto
		List<WebElement> fieldsets = getDriver().findElements(By.tagName(EnumHtmlTag.ARCH_FIELDSET.getName()));
		for (WebElement _fieldset : fieldsets) {
			if (_fieldset.getAttribute(EnumHtmlTag.LEGEND.getName()) != null
					&& _fieldset.getAttribute(EnumHtmlTag.LEGEND.getName()).startsWith(fieldset.getName())) {
				// trova il pulsante toggle e cliccalo
				List<WebElement> buttons = _fieldset.findElements(By.tagName(EnumHtmlTag.BUTTON.getName()));
				for (WebElement button : buttons) {
					if (buttonTooltip.getName().equals(button.getAttribute(EnumHtmlTag.ARIA_LABEL.getName()))
							&& button.isEnabled()) {
						button.click();
						return _fieldset;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Gets the input text value.
	 *
	 * @param container the container
	 * @param inputText the input text
	 * @return the input text value
	 */
	public String getInputTextValue(WebElement container, EnumInputText inputText) {
		List<WebElement> archInputTexts = container.findElements(By.tagName(EnumHtmlTag.ARCH_INPUT_TEXT.getName()));
		for (WebElement archInputText : archInputTexts) {
			if (inputText.getName().equals(archInputText.getAttribute(EnumHtmlTag.LABEL.getName()))) {
				WebElement input = archInputText.findElement(By.tagName(EnumHtmlTag.INPUT.getName()));
				return input.getAttribute(EnumHtmlTag.VALUE.getName());
			}
		}
		return null;
	}
}
