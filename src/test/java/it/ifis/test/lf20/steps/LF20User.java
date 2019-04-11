package it.ifis.test.lf20.steps;

import static org.junit.Assert.assertTrue;

import it.ifis.test.lf20.models.MenuLink;
import it.ifis.test.lf20.models.Popup;
import it.ifis.test.lf20.ui.HomePage;
import it.ifis.test.lf20.ui.LoginPage;
import it.ifis.test.lf20.ui.MenuLinkNavigation;
import it.ifis.test.lf20.ui.PopupPage;
import net.thucydides.core.annotations.Step;

/**
 * The Class LF20User.
 */
public class LF20User {
	
	/** The home page. */
	private HomePage homePage;
	
	/** The login page. */
	private LoginPage loginPage;
	
	/** The menu link navigation. */
	private MenuLinkNavigation menuLinkNavigation;
	
	/** The popup page. */
	private PopupPage popupPage;
	
	/**
	 * Checks if is on the login page.
	 */
	@Step
	public void isOnTheLoginPage() {
        loginPage.open();
    }

	/**
	 * Logs in as legale interno.
	 */
	@Step("Autenticazione come Legale Interno")
    public void logsInAsLegaleInterno() {
        loginPage.loginAsLegaleInterno();
    }
	
	/**
	 * Should be on home page or workstation list page.
	 */
	@Step
    public void shouldBeOnHomePageOrWorkstationListPage() {
		// TODO: atterraggio in pagina con lista workstation non ancora gestita
		assertTrue(homePage.hasLegalFactoryLabel());
    }

	/**
	 * Navigates to menu link.
	 *
	 * @param link the link
	 */
	@Step
	public void navigatesToMenuLink(MenuLink link) {
		if (homePage.hasSpinner())
			homePage.waitEndOfSpinner();
		
		if (popupPage.hasPopup(Popup.COURTESY_TEST_ENVIRONMENT))
			popupPage.closePopupWithEsc(Popup.COURTESY_TEST_ENVIRONMENT);
		
		System.out.println("***** navigatesToMenuLink 1");
		menuLinkNavigation.selectMenuLink(link);
		System.out.println("***** navigatesToMenuLink 999");
	}
}
