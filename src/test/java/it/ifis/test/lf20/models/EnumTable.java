package it.ifis.test.lf20.models;

/**
 * Enumeration delle tabelle.
 */
public enum EnumTable {

	/** The elenco fascicoli affidati. */
	TABLE_ELENCO_FASCICOLI_AFFIDATI("Elenco fascicoli affidati"),

	/** The table elenco fascicoli creati. */
	TABLE_ELENCO_FASCICOLI_CREATI("Elenco fascicoli creati"),

	/** The table pratiche collegate. */
	TABLE_PRATICHE_COLLEGATE("Pratiche collegate"),

	/** The button modifica fascicolo. */
	BUTTON_MODIFICA_FASCICOLO("Modifica fascicolo");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a new EnumTable.
	 *
	 * @param name the name
	 */
	private EnumTable(String name) {
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
