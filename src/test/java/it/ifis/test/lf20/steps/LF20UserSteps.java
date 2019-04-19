package it.ifis.test.lf20.steps;

import static org.junit.Assert.assertTrue;

import it.ifis.test.lf20.models.MenuLink;
import it.ifis.test.lf20.models.Popup;
import it.ifis.test.lf20.ui.CommonPage;
import it.ifis.test.lf20.ui.HomePage;
import it.ifis.test.lf20.ui.LoginPage;
import it.ifis.test.lf20.ui.MenuLinkNavigationPage;
import it.ifis.test.lf20.ui.PopupPage;
import it.ifis.test.lf20.ui.TablePage;
import net.thucydides.core.annotations.Step;

/**
 * The Class LF20User.
 */
public class LF20UserSteps {

	/** The common page. */
	private CommonPage commonPage;

	/** The home page. */
	private HomePage homePage;

	/** The login page. */
	private LoginPage loginPage;

	/** The menu link navigation. */
	private MenuLinkNavigationPage menuLinkNavigationPage;

	/** The popup page. */
	private PopupPage popupPage;

	/** The table page. */
	private TablePage tablePage;

	public HomePage getHomePage() {
		return homePage;
	}

	/**
	 * Open login page.
	 */
	@Step
	public void openLoginPage() {
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
		assertTrue(homePage.pageHasLegalFactoryLabel());
	}

	/**
	 * Go to home page.
	 */
	@Step
	public void goToHomePage() {
		openLoginPage();
		logsInAsLegaleInterno();
		shouldBeOnHomePageOrWorkstationListPage();
	}

	/**
	 * Navigates to menu link.
	 *
	 * @param link the link
	 */
	@Step
	public void navigatesToMenuLink(MenuLink link) {
		System.out.println("LF20UserSteps.navigatesToMenuLink: " + link);

		if (commonPage.hasSpinner())
			commonPage.waitEndOfSpinner();

		if (popupPage.hasPopup(Popup.COURTESY_TEST_ENVIRONMENT))
			popupPage.closePopupWithEsc(Popup.COURTESY_TEST_ENVIRONMENT);

		menuLinkNavigationPage.selectMenuLink(link);

		if (commonPage.hasSpinner())
			commonPage.waitEndOfSpinner();
		System.out.println("LF20UserSteps.navigatesToMenuLink - END");
	}

	/**
	 * Click modifica fascicolo.
	 */
	@Step
	public void clickModificaFascicoloSuDebitore() {
		tablePage.clickButtonModificaFascicoloInFascicoliAffidati("Debitore");
	}

}
