package it.ifis.test.lf20.ui;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import it.ifis.test.lf20.models.HtmlTag;
import it.ifis.test.lf20.models.Table;
import it.ifis.test.lf20.models.TableFascicoliAffidati;
import net.serenitybdd.core.pages.PageObject;

/**
 * Table.
 */
public class TablePage extends PageObject {

	/** The checkbox page. */
	private CheckboxPage checkboxPage;

	/**
	 * Click a button of the table.
	 *
	 * @param tableName  the table name
	 * @param buttonName the button name to click
	 */
	public void clickButton(Table tableName, Table buttonName) {
		System.out.println("Find table: " + tableName);
		System.out.println("Click button: " + buttonName);

		// recupera la tabella richiesta
		WebElement table = getDriver().findElement(By.cssSelector("*[table-title='" + tableName.getName() + "']"));
		System.out.println("Table found");

		boolean buttonClicked = false;
		// recupera le righe
		List<WebElement> rows = table.findElements(By.tagName(HtmlTag.TR.getName()));
		while (!rows.isEmpty()) {
			int rowCount = 0;

			for (WebElement row : rows) {
				System.out.println("Row: " + rowCount);

				// recupera i bottoni di una riga
				List<WebElement> buttons = row.findElements(By.tagName(HtmlTag.BUTTON.getName()));
				for (WebElement button : buttons) {
					System.out.println("Button: " + button.getAttribute(HtmlTag.ARIA_LABEL.getName()) + " --- enabled: "
							+ button.isEnabled());

					// trova il bottone cliccabile con tooltip richiesto
					if (button.isEnabled() && button.getAttribute(HtmlTag.ARIA_LABEL.getName()) != null
							&& buttonName.getName().equals(button.getAttribute(HtmlTag.ARIA_LABEL.getName()))) {
						System.out.println("Button found");
						button.click();
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

			// se il bottone non è stato trovato, avanza di una pagina e recupera le
			// prossime righe
			rows = getNextRows(table);
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
		System.out.println("Find table: " + Table.TABLE_ELENCO_FASCICOLI_AFFIDATI);
		System.out.println("Click button: " + Table.BUTTON_MODIFICA_FASCICOLO);

		// recupera la tabella "elenco fascicoli affidati"
		WebElement table = getDriver().findElement(
				By.cssSelector("*[table-title='" + Table.TABLE_ELENCO_FASCICOLI_AFFIDATI.getName() + "']"));
		System.out.println("Table found");

		boolean buttonClicked = false;
		// recupera le righe
		List<WebElement> rows = table.findElements(By.tagName(HtmlTag.TR.getName()));
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

				// recupera l'icona "blocco SO"
				WebElement iconBloccoSo = row
						.findElement(By.xpath("child::td[" + TableFascicoliAffidati.INDEX_ICON_BLOCCO_SO + "]"));
				boolean isRapportoAUI = false;
				System.out.println("Icona Blocco SO: " + iconBloccoSo.getText());
				if (HtmlTag.ICON_BLOCK.getName().equals(iconBloccoSo.getText())) {
					isRapportoAUI = true;
				}

				// cerca il bottone solo se non ci sono rapporti AUI ed il "tipo soggetto" è
				// uguale a quello richiesto
				if (!isRapportoAUI && tipoSoggetto.equals(_tipoSoggetto.getText())) {

					// recupera il bottone "Modifica fascicolo"
					WebElement buttonModificaFascicolo = row.findElement(By.xpath(
							"child::td[" + TableFascicoliAffidati.INDEX_BUTTON_PLAY + "]/span/arch-button/button"));
					System.out.println("Button: " + buttonModificaFascicolo.getAttribute(HtmlTag.ARIA_LABEL.getName())
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

			// se il bottone non è stato trovato, avanza di una pagina e recupera le
			// prossime righe
			rows = getNextRows(table);
		}

		// se il bottone non è stato cliccato --> assert FALSE
		if (!buttonClicked) {
			assertTrue(false);
		}
	}

	/**
	 * Select all pratiche in pratiche collegate.
	 */
	public void selectAllPraticheInPraticheCollegate() {
		System.out.println("Find table: " + Table.TABLE_PRATICHE_COLLEGATE);

		// recupera la tabella "pratiche collegate"
		WebElement table = getDriver()
				.findElement(By.cssSelector("*[table-title='" + Table.TABLE_PRATICHE_COLLEGATE.getName() + "']"));
		System.out.println("Table found");

		// recupera le righe
		List<WebElement> rows = table.findElements(By.tagName(HtmlTag.TR.getName()));
		while (!rows.isEmpty()) {
			int rowCount = 0;

			for (WebElement row : rows) {
				System.out.println("Row: " + rowCount);

				// salta l'header
				if (rowCount == 0) {
					rowCount++;
					continue;
				}

				// recupera e clicca la checkbox
				checkboxPage.clickCheckbox(row, null);
//				WebElement checkbox = row.findElement(By.tagName(HtmlTag.MD_CHECKBOX.getName()));
//
//				Actions action = new Actions(getDriver());
//				action.moveToElement(checkbox).click(checkbox).build().perform();

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
		List<WebElement> buttons = table.findElements(By.tagName(HtmlTag.BUTTON.getName()));
		for (WebElement button : buttons) {
			if (HtmlTag.BUTTON_TOOLTIP_NEXT.getName().equals(button.getAttribute(HtmlTag.ARIA_LABEL.getName()))
					&& button.isEnabled()) {
				button.click();
				rows = table.findElements(By.tagName(HtmlTag.TR.getName()));
				break;
			}
		}
		return rows;
	}
}
