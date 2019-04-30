package it.ifis.test.lf20.models;

/**
 * Enumeration delle select.
 */
public enum Select {

	/** The select fase. */
	SELECT_FASE("Fase"),

	/** The option fase ordinanza assegnazione. */
	OPTION_FASE_ORDINANZA_ASSEGNAZIONE("5"),

	/** The select attivita. */
	SELECT_ATTIVITA("Attività"),

	/** The option attivita gestione. */
	OPTION_ATTIVITA_GESTIONE("501");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a new Select.
	 *
	 * @param name the name
	 */
	private Select(String name) {
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
