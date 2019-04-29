package it.ifis.test.lf20.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import it.ifis.test.lf20.models.HtmlTag;
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
		List<WebElement> tabs = getDriver().findElements(By.tagName(HtmlTag.MD_TAB_ITEM.getName()));
		for (WebElement tab : tabs) {
			WebElement _tabName = tab.findElement(By.tagName(HtmlTag.SPAN.getName()));
			if (tabName.equals(_tabName.getText())) {
				WebElement x = tab.findElement(By.tagName(HtmlTag.MD_ICON.getName()));
				Actions action = new Actions(getDriver());
				action.moveToElement(x).click(x).build().perform();
			}
		}
	}
}
