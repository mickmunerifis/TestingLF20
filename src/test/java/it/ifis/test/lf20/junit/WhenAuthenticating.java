package it.ifis.test.lf20.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import it.ifis.test.lf20.steps.LF20UserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

// RUN from GitBash: mvn -Dtest=WhenAuthenticating clean verify
// RUN from Eclipse: just run as Junit test this class

/**
 * The Class WhenAuthenticating.
 */
@RunWith(SerenityRunner.class)
public class WhenAuthenticating {

	/** The user. */
	@Steps
	private LF20UserSteps user;

	/** The browser. */
	@Managed(driver = "chrome")
	WebDriver browser;

	/**
	 * Testa la login con un legale interno.
	 */
	@Test
	public void shouldBeAbleToLoginAsLegaleInterno() {
		user.goToHomePage();
	}
}
