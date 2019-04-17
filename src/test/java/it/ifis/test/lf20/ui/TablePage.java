package it.ifis.test.lf20.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import it.ifis.test.lf20.models.Table;
import net.serenitybdd.core.pages.PageObject;

/**
 * Table.
 */
public class TablePage extends PageObject {

	/** The common page. */
	private CommonPage commonPage;

	/**
	 * Click a button of the table.
	 *
	 * @param tableName  the table name
	 * @param buttonName the button name to click
	 */
	public void clickButton(Table tableName, Table buttonName) {
		System.out.println("Find table: " + tableName);
		System.out.println("Click button: " + buttonName);
		WebElement table = commonPage.getElement(By.cssSelector("*[table-title='" + tableName.getName() + "']"));
		System.out.println("Table found");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowCount = 0;
		for (WebElement row : rows) {
			System.out.println("Row: " + rowCount);
			List<WebElement> buttons = row.findElements(By.tagName("button"));
			for (WebElement button : buttons) {
				System.out.println(
						"Button: " + button.getAttribute("aria-label") + " --- enabled: " + button.isEnabled());
				if (button.isEnabled() && button.getAttribute("aria-label") != null
						&& buttonName.getName().equals(button.getAttribute("aria-label"))) {
					System.out.println("Button found");
					button.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
			}
			rowCount++;
		}
	}
}
