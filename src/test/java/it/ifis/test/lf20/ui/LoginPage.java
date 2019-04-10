package it.ifis.test.lf20.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.TemporalUnitConverter;

@DefaultUrl("http://sulboafe01/app/legalfactory/ibaf_login.html")
public class LoginPage extends PageObject {
	

	public void loginAsLegaleInterno() {

		setImplicitTimeout(10, TemporalUnitConverter.fromTimeUnit(TimeUnit.SECONDS));
		Dimension dimension = new Dimension(1600, 900);
		getDriver().manage().window().setSize(dimension);
	    getDriver().findElement(By.name("username")).sendKeys("mraviolo.test");	    
	    getDriver().findElement(By.name("password")).sendKeys("Gennaio2019");
	    WebElement submitButton = getDriver().findElement(By.cssSelector("*[type='submit']"));
	    submitButton.click();
	}
}
