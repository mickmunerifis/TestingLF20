package it.ifis.test.lf20.models;

public enum MenuLink {
	CreazioneFascicolo("Creazione fascicolo"),
	Cruscotto("Cruscotto"),	
	Opposizioni("Opposizioni"),
	RichiestaAttiIntervento("Richiesta atti intervento");
	
	private String menuLinkName;

	private MenuLink(String menuLinkName) {
		this.menuLinkName = menuLinkName;
	}

	public String getMenuLinkName() {
		return menuLinkName;
	}
		
	
}
