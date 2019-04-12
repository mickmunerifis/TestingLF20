package it.ifis.test.lf20.junit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import it.ifis.test.lf20.models.MenuLink;
import it.ifis.test.lf20.steps.LF20UserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

// RUN from GitBash: mvn -Dtest=WhenNavigatingToCreazioneFascicolo clean verify
// RUN from Eclipse: just run as Junit test this class

/**
 * The Class WhenNavigatingToCreazioneFascicolo.
 */
@RunWith(SerenityRunner.class)
public class WhenNavigatingToCreazioneFascicolo {
	
	/** The user. */
	@Steps
    private LF20UserSteps user;
	
    /** The browser. */
    @Managed(driver = "chrome")
    WebDriver browser;
    
    /**
     * Go to home page.
     */
    @Before
    public void goToHomePage() {
      user.goToHomePage();
   }
    
    /**
     * Testa la creazione di un fascicolo.
     */
    @Test
    public void shouldBeAbleToCreateFascicolo() {
        user.navigatesToMenuLink(MenuLink.CREAZIONE_FASCICOLO);
    }
}
