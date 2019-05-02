package it.ifis.test.lf20.ui;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import it.ifis.test.lf20.models.EnumButton;
import it.ifis.test.lf20.models.EnumHtmlTag;
import it.ifis.test.lf20.models.EnumTable;
import it.ifis.test.lf20.models.TableFascicoliAffidati;
import it.ifis.test.lf20.models.TableFascicoliCreati;
import net.serenitybdd.core.pages.PageObject;

/**
 * Table.
 */
public class TablePage extends PageObject {

	/** The checkbox page. */
	private CheckboxPage checkboxPage;

	/** The button page. */
	private ButtonPage buttonPage;

	/**
	 * Click a button of the table.
	 *
	 * @param table  the table that contains the button
	 * @param button the button to click
	 */
	public void clickButton(EnumTable table, EnumTable button) {
		System.out.println("Find table: " + table);
		System.out.println("Click button: " + button);

		// recupera la tabella richiesta
		WebElement _table = getDriver().findElement(By.cssSelector("*[table-title='" + table.getName() + "']"));
		System.out.println("Table found");

		boolean buttonClicked = false;
		// recupera le righe
		List<WebElement> rows = _table.findElements(By.tagName(EnumHtmlTag.TR.getName()));
		while (!rows.isEmpty()) {
			int rowCount = 0;

			for (WebElement row : rows) {
				System.out.println("Row: " + rowCount);

				// recupera i bottoni di una riga
				List<WebElement> buttons = row.findElements(By.tagName(EnumHtmlTag.BUTTON.getName()));
				for (WebElement _button : buttons) {
					System.out.println("Button: " + _button.getAttribute(EnumHtmlTag.ARIA_LABEL.getName())
							+ " --- enabled: " + _button.isEnabled());

					// trova il bottone cliccabile con tooltip richiesto
					if (_button.isEnabled()
							&& button.getName().equals(_button.getAttribute(EnumHtmlTag.ARIA_LABEL.getName()))) {
						System.out.println("Button found");
						_button.click();
						buttonClicked = true;
						break;
					}
				}

				// se il bottone è stato premuto esci dal FOR
				if (buttonClicked) {
					break;
				}

				rowCount++;
			}

			// se il bottone è stato premuto esci dal WHILE
			if (buttonClicked) {
				break;
			}

			// se il bottone non è stato trovato, avanza di una pagina e recupera le prossime righe
			rows = getNextRows(_table);
		}

		// se il bottone non è stato cliccato --> assert FALSE
		if (!buttonClicked) {
			assertTrue(false);
		}
	}

	/**
	 * Click button modifica fascicolo in fascicoli affidati.
	 *
	 * @param tipoSoggetto the tipo soggetto
	 */
	public void clickButtonModificaFascicoloInFascicoliAffidati(String tipoSoggetto) {
		System.out.println("Find table: " + EnumTable.TABLE_ELENCO_FASCICOLI_AFFIDATI);
		System.out.println("Click button: " + EnumTable.BUTTON_MODIFICA_FASCICOLO);

		// recupera la tabella "elenco fascicoli affidati"
		WebElement table = getDriver().findElement(
				By.cssSelector("*[table-title='" + EnumTable.TABLE_ELENCO_FASCICOLI_AFFIDATI.getName() + "']"));
		System.out.println("Table found");

		boolean buttonClicked = false;
		// recupera le righe
		List<WebElement> rows = table.findElements(By.tagName(EnumHtmlTag.TR.getName()));
		while (!rows.isEmpty()) {
			int rowCount = 0;

			for (WebElement row : rows) {
				System.out.println("Row: " + rowCount);

				// salta l'header
				if (rowCount == 0) {
					rowCount++;
					continue;
				}

				// recupera il contenuto della cella "tipo soggetto"
				WebElement _tipoSoggetto = row
						.findElement(By.xpath("child::td[" + TableFascicoliAffidati.INDEX_TIPO_SOGGETTO + "]"));
				System.out.println("Tipo soggetto: " + _tipoSoggetto.getText());

				// recupera il contenuto della cella "legale esterno"
				WebElement _legaleEsterno = row
						.findElement(By.xpath("child::td[" + TableFascicoliAffidati.INDEX_LEGALE_ESTERNO + "]"));
				System.out.println("Legale esterno: " + _legaleEsterno.getText());

				// recupera l'icona "blocco SO"
				WebElement iconBloccoSo = row
						.findElement(By.xpath("child::td[" + TableFascicoliAffidati.INDEX_ICON_BLOCCO_SO + "]"));
				boolean isRapportoAUI = false;
				System.out.println("Icona Blocco SO: " + iconBloccoSo.getText());
				if (EnumHtmlTag.ICON_BLOCK.getName().equals(iconBloccoSo.getText())) {
					isRapportoAUI = true;
				}

				// cerca il bottone solo se non ci sono rapporti AUI , il "tipo soggetto" è uguale a quello richiesto e il legale esterno è popolato.
				if (!isRapportoAUI && tipoSoggetto.equals(_tipoSoggetto.getText())
						&& !"".equals(_legaleEsterno.getText())) {

					// recupera il bottone "Modifica fascicolo"
					WebElement buttonModificaFascicolo = row.findElement(By.xpath(
							"child::td[" + TableFascicoliAffidati.INDEX_BUTTON_PLAY + "]/span/arch-button/button"));
					System.out
							.println("Button: " + buttonModificaFascicolo.getAttribute(EnumHtmlTag.ARIA_LABEL.getName())
									+ " --- enabled: " + buttonModificaFascicolo.isEnabled());

					// se il bottone è cliccabile --> clicca
					if (buttonModificaFascicolo.isEnabled()) {
						System.out.println("Button found");
						buttonModificaFascicolo.click();
						buttonClicked = true;
						break;
					}
				}

				// se il bottone è stato premuto esci dal FOR
				if (buttonClicked) {
					break;
				}

				rowCount++;
			}

			// se il bottone è stato premuto esci dal WHILE
			if (buttonClicked) {
				break;
			}

			// se il bottone non è stato trovato, avanza di una pagina e recupera le prossime righe
			rows = getNextRows(table);
		}

		// se il bottone non è stato cliccato --> assert FALSE
		if (!buttonClicked) {
			assertTrue(false);
		}
	}

	/**
	 * Verifica che nella tabella "Elenco fascicoli creati" ci sia un fascicolo creato oggi per l'ndg richiesto.
	 *
	 * @param ndg the ndg
	 * @return true, if successful
	 */
	public boolean verificaNdgInElencoFascicoliCreati(String ndg) {
		System.out.println("Find table: " + EnumTable.TABLE_ELENCO_FASCICOLI_CREATI);

		// recupera la tabella "elenco fascicoli creati"
		WebElement table = getDriver().findElement(
				By.cssSelector("*[table-title='" + EnumTable.TABLE_ELENCO_FASCICOLI_CREATI.getName() + "']"));
		System.out.println("Table found");

		// recupera le righe
		List<WebElement> rows = table.findElements(By.tagName(EnumHtmlTag.TR.getName()));
		while (!rows.isEmpty()) {
			int rowCount = 0;

			for (WebElement row : rows) {
				System.out.println("Row: " + rowCount);

				// salta l'header
				if (rowCount == 0) {
					rowCount++;
					continue;
				}

				// recupera il contenuto della cella "Ndg"
				WebElement _ndg = row.findElement(By.xpath("child::td[" + TableFascicoliCreati.INDEX_NDG + "]"));
				System.out.println("Ndg: " + _ndg.getText());

				// recupera il contenuto della cella "Data creazione"
				WebElement _dataCreazione = row
						.findElement(By.xpath("child::td[" + TableFascicoliCreati.INDEX_DATA_CREAZIONE + "]"));
				System.out.println("Data creazione: " + _dataCreazione.getText());

				// verifica che l'ndg sia uaguale a quello richiesto e che la data sia uguale a quella odierna
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				if (ndg.equals(_ndg.getText()) && dateFormat.format(new Date()).equals(_dataCreazione.getText())) {
					return true;
				}

				rowCount++;
			}

			// se il bottone non è stato trovato, avanza di una pagina e recupera le prossime righe
			rows = getNextRows(table);
		}

		return false;
	}

	/**
	 * Select all pratiche in pratiche collegate.
	 */
	public void selectAllPraticheInPraticheCollegate() {
		System.out.println("Find table: " + EnumTable.TABLE_PRATICHE_COLLEGATE);

		// recupera la tabella "pratiche collegate"
		WebElement table = getDriver()
				.findElement(By.cssSelector("*[table-title='" + EnumTable.TABLE_PRATICHE_COLLEGATE.getName() + "']"));
		System.out.println("Table found");

		// recupera le righe
		List<WebElement> rows = table.findElements(By.tagName(EnumHtmlTag.TR.getName()));
		while (!rows.isEmpty()) {
			int rowCount = 0;

			for (WebElement row : rows) {
				System.out.println("Row: " + rowCount);

				// salta l'header
				if (rowCount == 0) {
					rowCount++;
					continue;
				}

				// clicca la checkbox
				checkboxPage.clickCheckbox(row, null);

				// clicca il bottone "CONFERMA"
				buttonPage.clickButton(EnumButton.LABEL_CONFERMA);

				rowCount++;
			}

			// recupera le righe della prossima pagina (se presente)
			rows = getNextRows(table);
		}
	}

	/**
	 * Gets the next rows.
	 *
	 * @param table the table
	 * @return the next rows
	 */
	private List<WebElement> getNextRows(WebElement table) {
		List<WebElement> rows = new ArrayList<WebElement>();
		List<WebElement> buttons = table.findElements(By.tagName(EnumHtmlTag.BUTTON.getName()));
		for (WebElement button : buttons) {
			if (EnumButton.TOOLTIP_NEXT.getName().equals(button.getAttribute(EnumHtmlTag.ARIA_LABEL.getName()))
					&& button.isEnabled()) {
				button.click();
				rows = table.findElements(By.tagName(EnumHtmlTag.TR.getName()));
				break;
			}
		}
		return rows;
	}
}
