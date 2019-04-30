package it.ifis.test.lf20.models;

/**
 * Enumeration delle voci di menu.
 */
public enum EnumMenuLink {
	
	/** Creazione fascicolo. */
	CREAZIONE_FASCICOLO("Creazione fascicolo"),
	
	/** Cruscotto. */
	CRUSCOTTO("Cruscotto"),	
	
	/** Opposizioni. */
	OPPOSIZIONI("Opposizioni"),
	
	/** Richiesta atti intervento. */
	RICHIESTA_ATTI_INTERVENTO("Richiesta atti intervento");
	
	/** The menu link name. */
	private String menuLinkName;

	/**
	 * Instantiates a new menu link enum.
	 *
	 * @param menuLinkName the menu link name
	 */
	private EnumMenuLink(String menuLinkName) {
		this.menuLinkName = menuLinkName;
	}

	/**
	 * Gets the menu link name.
	 *
	 * @return the menu link name
	 */
	public String getMenuLinkName() {
		return menuLinkName;
	}
}
