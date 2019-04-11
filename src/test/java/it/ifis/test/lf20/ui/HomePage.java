package it.ifis.test.lf20.ui;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.TemporalUnitConverter;


/**
 * La home page.
 */
public class HomePage extends PageObject {
	
	private CommonPage commonPage;
	

    /**
     * Checks for legal factory label.
     *
     * @return true, if successful
     */
    public boolean hasLegalFactoryLabel() {
    	setImplicitTimeout(10, TemporalUnitConverter.fromTimeUnit(TimeUnit.SECONDS));
    	waitForAnyTextToAppear("Legal Factory");    	
    	WebElement labelLF20 = getDriver().findElement(By.cssSelector("*[class='main-title md-truncate ng-binding flex']"));        	
        return labelLF20.getText().trim().indexOf("Legal Factory") != -1;
    }

	/**
	 * Checks for spinner.
	 *
	 * @return true, if successful
	 */
	public boolean hasSpinner() {
		System.out.println("***** hasSpinner 0");
		return commonPage.isElementPresent(By.name("arch-loading"));
	}

	/**
	 * Wait end of spinner.
	 */
	public void waitEndOfSpinner() {
		if (hasSpinner())
			waitForRenderedElementsToDisappear(By.tagName("arch-loading"));
	}
}
