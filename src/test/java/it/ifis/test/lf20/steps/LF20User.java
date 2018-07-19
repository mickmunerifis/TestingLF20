package it.ifis.test.lf20.steps;

import static org.junit.Assert.assertTrue;

import it.ifis.test.lf20.models.MenuLink;
import it.ifis.test.lf20.ui.HomePage;
import it.ifis.test.lf20.ui.LoginPage;
import it.ifis.test.lf20.ui.MenuLinkNavigation;
import net.thucydides.core.annotations.Step;

public class LF20User {
	
	private HomePage homePage;
	private LoginPage loginPage;
	private MenuLinkNavigation menuLinkNavigation;
	
	@Step
	public void isOnTheLoginPage() {
        loginPage.open();
    }

	@Step("Autenticazione come Legale Interno")
    public void logsInAsLegaleInterno() {
        loginPage.loginAsLegaleInterno();
    }
	
	@Step
    public void shouldBeOnHomePageOrWorkstationListPage() {
		// attenzione: atterraggio in pagina con lista woirkstation non ancora gestita
		assertTrue(homePage.hasLegalFactoryLabel());
    }

	@Step
	public void navigatesToMenuLink(MenuLink link) {
		if (homePage.hasSpinner())
			homePage.waitEndOfSpinner();
		
		if (homePage.hasCourtesyPopupTestEnvironment())
			homePage.closePopupWithEsc();
		
		System.out.println("***** navigatesToMenuLink 1");
		menuLinkNavigation.selectMenuLink(link);
		System.out.println("***** navigatesToMenuLink 2");
	}
}
