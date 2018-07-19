package it.ifis.test.lf20.navigation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import it.ifis.test.lf20.models.MenuLink;
import it.ifis.test.lf20.steps.LF20User;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

//RUN from GitBash: mvn -Dtest=WhenNavigatingToCreazioneFascicolo clean verify
//RUN from Eclipse: just run as Junit test this class

@RunWith(SerenityRunner.class)
public class WhenNavigatingToCreazioneFascicolo {
	@Steps
    private LF20User user;
 
    @Managed(driver = "chrome")
    WebDriver browser;
    
    @Test
    public void shouldBeAbleToCreateFascicolo() {
        user.isOnTheLoginPage();
        user.logsInAsLegaleInterno();
        user.shouldBeOnHomePageOrWorkstationListPage();  
        
        user.navigatesToMenuLink(MenuLink.CreazioneFascicolo);
        
        //user.shouldSeePageTitleContaining("Project Overlord");
    }
}
