package it.ifis.test.lf20.models;

/**
 * Enumeration delle input text.
 */
public enum EnumInputText {

	/** The ndg. */
	NDG("Ndg");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a new EnumInputText.
	 *
	 * @param name the name
	 */
	private EnumInputText(String name) {
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
