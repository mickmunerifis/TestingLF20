package it.ifis.test.lf20.models;

/**
 * Enumeration delle checkbox.
 */
public enum EnumCheckbox {

	/** The checkbox fascicolo legalizzato. */
	CHECKBOX_FASCICOLO_LEGALIZZATO("Fascicolo legalizzato");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a new EnumCheckbox.
	 *
	 * @param name the name
	 */
	private EnumCheckbox(String name) {
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
