package it.ifis.test.lf20.models;

public enum MenuLink {
	CreazioneFascicolo("Creazione fascicolo"),
	Cruscotto("Cruscotto");
	
	private String menuLinkName;

	private MenuLink(String menuLinkName) {
		this.menuLinkName = menuLinkName;
	}

	public String getMenuLinkName() {
		return menuLinkName;
	}
		
	
}
