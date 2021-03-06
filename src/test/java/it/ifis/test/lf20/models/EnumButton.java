package it.ifis.test.lf20.models;

/**
 * Enumeration dei bottoni.
 */
public enum EnumButton {

	/** The button tooltip next. */
	TOOLTIP_NEXT("Next"),

	/** The button tooltip toggle. */
	TOOLTIP_TOGGLE("Toggle"),

	/** The button label conferma. */
	LABEL_CONFERMA("Conferma"),

	/** The button label crea fascicolo. */
	LABEL_CREA_FASCICOLO("Crea fascicolo"),

	/** The button label conferma. */
	LABEL_SALVA("Salva");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a new EnumButton.
	 *
	 * @param name the name
	 */
	private EnumButton(String name) {
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
