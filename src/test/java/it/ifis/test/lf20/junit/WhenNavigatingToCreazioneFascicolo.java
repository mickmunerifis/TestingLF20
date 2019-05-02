package it.ifis.test.lf20.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import it.ifis.test.lf20.models.EnumMenuLink;
import it.ifis.test.lf20.steps.LF20UserSteps;
import it.ifis.test.lf20.ui.CommonPage;
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
	 * Testa la creazione di un fascicolo legalizzato in OdA.
	 */
	@Test
	public void shouldBeAbleToCreateFascicoloLegalizzatoInOda() {
		// aspetta la chiusura dello spinner.
		user.getPopupPage().waitForSpinnerAndCourtesyDialog();

		// clicca la voce di menu "Creazione fascicolo" e verifica di essere atterrato nella pagina corretta.
		user.navigatesToMenuLink(EnumMenuLink.CREAZIONE_FASCICOLO);
		assertTrue(user.getCommonPage().pageHasPageTitle(CommonPage.FASCICOLI_PROVVISORI));

		// chiudi il tab "Cruscotto".
		user.getCommonPage().closeTab(CommonPage.TAB_CRUSCOTTO);

		// clicca "Modifica fascicolo" sulla prima riga della tabella "Elenco fascicoli affidati" che non ha il "blocco SO" , che sia di un "debitore" e che abbia il campo "legale esterno popolato".
		// aspetta la chiusura dello spinner.
		// verifica di essere atterrato sulla pagina "Crea fascicolo".
		user.clickModificaFascicoloSuDebitore();
		user.getPopupPage().waitForSpinnerAndCourtesyDialog();
		assertTrue(user.getCommonPage().pageHasPageTitle(CommonPage.CREA_FASCICOLO));

		// crea il fascicolo legalizzato in OdA.
		// aspetta la chiusura dello spinner.
		// verifica di essere atterrato sulla pagina "Fascicoli provvisori".
		user.creaFascicoloLegalizzatoInOda();
		user.getPopupPage().waitForSpinnerAndCourtesyDialog();
		assertTrue(user.getCommonPage().pageHasPageTitle(CommonPage.FASCICOLI_PROVVISORI));

		// controlla che nella tabella "Elenco fascicoli creati" ci sia il fascicolo appena creato.
		assertTrue(
				user.verificaFascicoloCreato((String) user.getHeaders().get(LF20UserSteps.HEADER_CREA_FASCICOLO_NDG)));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
