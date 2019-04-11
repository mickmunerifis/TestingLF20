package it.ifis.test.lf20.ui;

import net.serenitybdd.core.pages.PageObject;

/**
 * Utilità comuni.
 */
public class CommonPage extends PageObject {
	
	/**
	 * Checks if the element is present.
	 *
	 * @param by the by
	 * @return true, if element is present
	 */
	public boolean isElementPresent(org.openqa.selenium.By by) {
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
	public Boolean isElementVisible(org.openqa.selenium.By by){
	    return getDriver().findElement(by).isDisplayed();
	}
}
