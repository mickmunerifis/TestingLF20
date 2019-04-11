package it.ifis.test.lf20.models;

/**
 * Enumeration dei popup.
 */
public enum Popup {
	
	/** The Courtesy test environment. */
	COURTESY_TEST_ENVIRONMENT("dialogContent_2");
	
	/** The popup name. */
	private String popupName;

	/**
	 * Instantiates a new popup enum.
	 *
	 * @param popupName the popup name
	 */
	private Popup(String popupName) {
		this.popupName = popupName;
	}

	/**
	 * Gets the popup name.
	 *
	 * @return the popup name
	 */
	public String getPopupName() {
		return popupName;
	}
}
