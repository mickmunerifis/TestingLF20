package it.ifis.test.lf20.authentication;

import it.ifis.test.lf20.steps.LF20User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

// RUN from GitBash: mvn -Dtest=WhenAuthenticating clean verify
// RUN from Eclipse: just run as Junit test this class


@RunWith(SerenityRunner.class)
public class WhenAuthenticating {
	@Steps
	private LF20User user;
	
	@Managed(driver = "chrome")
    WebDriver browser;
	
	@Test
    public void shouldBeAbleToLoginAsLegaLeInterno() {
		//browser.manage().deleteAllCookies();
		
		user.isOnTheLoginPage();		

        user.logsInAsLegaleInterno();        

        user.shouldBeOnHomePageOrWorkstationListPage();        
    }
}
