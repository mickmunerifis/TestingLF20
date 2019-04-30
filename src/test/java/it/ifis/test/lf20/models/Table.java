package it.ifis.test.lf20.models;

/**
 * Enumeration delle tabelle.
 */
public enum Table {

	/** The elenco fascicoli affidati. */
	TABLE_ELENCO_FASCICOLI_AFFIDATI("Elenco fascicoli affidati"),

	/** The table pratiche collegate. */
	TABLE_PRATICHE_COLLEGATE("Pratiche collegate"),

	/** The button modifica fascicolo. */
	BUTTON_MODIFICA_FASCICOLO("Modifica fascicolo");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a new Table.
	 *
	 * @param name the name
	 */
	private Table(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
