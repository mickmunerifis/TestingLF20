package it.ifis.test.lf20.models;

/**
 * Enumeration dei tag HTML.
 */
public enum HtmlTag {

	/** The tr. */
	TR("tr"),

	/** The li. */
	LI("li"),

	/** The button. */
	BUTTON("button"),

	/** The md icon. */
	MD_ICON("md-icon"),

	/** The md tab item. */
	MD_TAB_ITEM("md-tab-item"),

	SPAN("span"),

	/** The aria label. */
	ARIA_LABEL("aria-label"),

	/** The icon block. */
	ICON_BLOCK("block"),

	BUTTON_TOOLTIP_NEXT("Next");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a new table.
	 *
	 * @param name the name
	 */
	private HtmlTag(String name) {
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
