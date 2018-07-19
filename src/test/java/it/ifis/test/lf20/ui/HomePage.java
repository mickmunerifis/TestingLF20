package it.ifis.test.lf20.ui;


import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.TemporalUnitConverter;


public class HomePage extends PageObject {
	
	public boolean isElementPresent(org.openqa.selenium.By by) {
	    try {
	        getDriver().findElement(by);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}

	public Boolean isElementVisible(org.openqa.selenium.By by){
	    return getDriver().findElement(by).isDisplayed();
	}
	
    public boolean hasLegalFactoryLabel() {
    	
    	setImplicitTimeout(10, TemporalUnitConverter.fromTimeUnit(TimeUnit.SECONDS));
    	waitForAnyTextToAppear("Legal Factory");    	
    	WebElement labelLF20 = getDriver().findElement(By.cssSelector("*[class='main-title md-truncate ng-binding flex']"));        	
        return labelLF20.getText().trim().indexOf("Legal Factory") != -1;
    }

	public boolean hasSpinner() {
		System.out.println("***** hasSpinner 0");
		return isElementPresent(By.name("arch-loading"));
	}

	public void waitEndOfSpinner() {
		if (hasSpinner())
			waitForRenderedElementsToDisappear(By.tagName("arch-loading"));
	}

	public boolean hasCourtesyPopupTestEnvironment() {
		System.out.println("***** hasCourtesyPopupTestEnvironment 0");
		return isElementPresent(By.id("dialogContent_2")) && isElementVisible(By.id("dialogContent_2"));
	}

	public void closePopupWithEsc() {
		System.out.println("***** closePopupWithEsc 0");
		WebElement popupTestEnv = getDriver().findElement(By.id("dialogContent_2"));
		System.out.println("***** closePopupWithEsc, popupTestEnv: " + popupTestEnv);
		System.out.println("***** closePopupWithEsc, popupTestEnv: 1" );
		WebElement element1 = getDriver().findElement(By.xpath("//html/body/div[3]/md-dialog/md-dialog-content/div/div/div/button[1]"));
		element1.click();
		System.out.println("***** closePopupWithEsc, popupTestEnv: 2" );
		
	}
 
 
}
