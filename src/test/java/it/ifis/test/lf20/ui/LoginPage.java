package it.ifis.test.lf20.ui;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import TestingLF.test.App;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.TemporalUnitConverter;

/**
 * La pagina di login.
 */
@DefaultUrl("http://sulboafe01/app/legalfactory/ibaf_login.html")
public class LoginPage extends PageObject {
	
	/**
	 * Login as legale interno.
	 */
	public void loginAsLegaleInterno(){
		Properties prop = new Properties();
		try {
			prop.load(App.class.getClassLoader().getResourceAsStream("serenity.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setImplicitTimeout(10, TemporalUnitConverter.fromTimeUnit(TimeUnit.SECONDS));
		Dimension dimension = new Dimension(1600, 900);
		getDriver().manage().window().setSize(dimension);
	    getDriver().findElement(By.name("username")).sendKeys(prop.getProperty("legaleinterno.username"));	    
	    getDriver().findElement(By.name("password")).sendKeys(prop.getProperty("legaleinterno.password"));
	    WebElement submitButton = getDriver().findElement(By.cssSelector("*[type='submit']"));
	    submitButton.click();
	}
}
