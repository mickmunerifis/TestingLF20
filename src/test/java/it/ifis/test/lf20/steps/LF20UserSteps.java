/*
 * 
 */
package it.ifis.test.lf20.steps;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import it.ifis.test.lf20.models.EnumButton;
import it.ifis.test.lf20.models.EnumCheckbox;
import it.ifis.test.lf20.models.EnumFieldset;
import it.ifis.test.lf20.models.EnumInputText;
import it.ifis.test.lf20.models.EnumMenuLink;
import it.ifis.test.lf20.models.EnumSelect;
import it.ifis.test.lf20.ui.ButtonPage;
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

	/** The button page. */
	private ButtonPage buttonPage;

	/** The select page. */
	private SelectPage selectPage;

	/** The Constant CREA_FASCICOLO_NDG. */
	public static final String HEADER_CREA_FASCICOLO_NDG = "CREA_FASCICOLO_NDG";

	/** The headers. */
	private Map<String, Object> headers = new HashMap<String, Object>();

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public Map<String, Object> getHeaders() {
		return headers;
	}

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
	public void navigatesToMenuLink(EnumMenuLink link) {
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
		// salva l'NDG del soggetto del fascicolo (servirà per verificare che il fascicolo sia stato creato correttamente).
		getNdgForCreaFascicolo();

		// Clicca "fascicolo legalizzato".
		checkboxPage.clickCheckbox(null, EnumCheckbox.CHECKBOX_FASCICOLO_LEGALIZZATO);

		// Seleziona fase legalizzata "Ordinanza di Assegnazione".
		selectPage.selectOption(EnumSelect.SELECT_FASE, EnumSelect.OPTION_FASE_ORDINANZA_ASSEGNAZIONE);

		// Seleziona attività legalizzata "Gestione".
		selectPage.selectOption(EnumSelect.SELECT_ATTIVITA, EnumSelect.OPTION_ATTIVITA_GESTIONE);

		// Conferma tutte le pratiche.
		tablePage.selectAllPraticheInPraticheCollegate();

		// Crea il fascicolo
		buttonPage.clickButton(EnumButton.LABEL_CREA_FASCICOLO);
	}

	/**
	 * Verifica che nella tabella "Elenco fascicoli creati" ci sia un fascicolo creato oggi per l'ndg richiesto.
	 *
	 * @param ndg the ndg
	 * @return true, if successful
	 */
	@Step
	public boolean verificaFascicoloCreato(String ndg) {
		return tablePage.verificaNdgInElencoFascicoliCreati(ndg);
	}

	/**
	 * Gets the ndg for crea fascicolo.
	 *
	 * @return the ndg for crea fascicolo
	 */
	private void getNdgForCreaFascicolo() {
		WebElement fieldset = commonPage.clickFieldsetButton(EnumFieldset.DATI_GENERALI, EnumButton.TOOLTIP_TOGGLE);
		String ndg = commonPage.getInputTextValue(fieldset, EnumInputText.NDG);
		headers.put(HEADER_CREA_FASCICOLO_NDG, ndg);
	}

}
