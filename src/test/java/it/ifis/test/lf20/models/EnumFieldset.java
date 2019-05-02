package it.ifis.test.lf20.models;

/**
 * Enumeration dei fieldset.
 */
public enum EnumFieldset {

	DATI_GENERALI("Dati Generali");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a new EnumFieldset.
	 *
	 * @param name the name
	 */
	private EnumFieldset(String name) {
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
