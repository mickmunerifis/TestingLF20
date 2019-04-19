package it.ifis.test.lf20.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.TemporalUnitConverter;

/**
 * La home page.
 */
public class HomePage extends PageObject {

	/**
	 * Page has legal factory label.
	 *
	 * @return true, if successful
	 */
	public boolean pageHasLegalFactoryLabel() {
		setImplicitTimeout(10, TemporalUnitConverter.fromTimeUnit(TimeUnit.SECONDS));
		waitForAnyTextToAppear("Legal Factory");
		WebElement labelLF20 = getDriver()
				.findElement(By.cssSelector("*[class='main-title md-truncate ng-binding flex']"));

		return labelLF20.getText().trim().indexOf("Legal Factory") != -1;
	}
}
