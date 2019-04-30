/*
 * 
 */
package it.ifis.test.lf20.steps;

import static org.junit.Assert.assertTrue;

import it.ifis.test.lf20.models.Checkbox;
import it.ifis.test.lf20.models.MenuLink;
import it.ifis.test.lf20.models.Select;
import it.ifis.test.lf20.ui.CheckboxPage;
import it.ifis.test.lf20.ui.CommonPage;
import it.ifis.test.lf20.ui.HomePage;
import it.ifis.test.lf20.ui.LoginPage;
import it.ifis.test.lf20.ui.MenuLinkNavigationPage;
import it.ifis.test.lf20.ui.PopupPage;
import it.ifis.test.lf20.ui.SelectPage;
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

	/** The table page. */
	private TablePage tablePage;

	/** The popup page. */
	private PopupPage popupPage;

	/** The checkbox page. */
	private CheckboxPage checkboxPage;

	/** The select page. */
	private SelectPage selectPage;

	/**
	 * Gets the common page.
	 *
	 * @return the common page
	 */
	public CommonPage getCommonPage() {
		return commonPage;
	}

	/**
	 * Gets the popup page.
	 *
	 * @return the popup page
	 */
	public PopupPage getPopupPage() {
		return popupPage;
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

	/**
	 * Crea fascicolo legalizzato in oda.
	 */
	@Step
	public void creaFascicoloLegalizzatoInOda() {
		checkboxPage.clickCheckbox(null, Checkbox.CHECKBOX_FASCICOLO_LEGALIZZATO);
		selectPage.selectOption(Select.SELECT_FASE, Select.OPTION_FASE_ORDINANZA_ASSEGNAZIONE);
		selectPage.selectOption(Select.SELECT_ATTIVITA, Select.OPTION_ATTIVITA_GESTIONE);
		tablePage.selectAllPraticheInPraticheCollegate();
	}

}
