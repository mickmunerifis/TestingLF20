package it.ifis.test.lf20.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

/**
 * Utilità comuni.
 */
public class CommonPage extends PageObject {

	/**
	 * Gets the element.
	 *
	 * @param by the by
	 * @return the element
	 */
	public WebElement getElement(By by) {
		return getDriver().findElement(by);
	}

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
}
