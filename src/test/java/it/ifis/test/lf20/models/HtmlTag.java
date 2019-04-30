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

	/** The md option. */
	MD_OPTION("md-option"),

	/** The md select. */
	MD_SELECT("md-select"),

	/** The md checkbox. */
	MD_CHECKBOX("md-checkbox"),

	/** The arch select. */
	ARCH_SELECT("arch-select"),

	/** The md tab item. */
	MD_TAB_ITEM("md-tab-item"),

	/** The span. */
	SPAN("span"),

	/** The aria label. */
	ARIA_LABEL("aria-label"),

	/** The label. */
	LABEL("label"),

	/** The value. */
	VALUE("value"),

	/** The icon block. */
	ICON_BLOCK("block"),

	/** The button tooltip next. */
	BUTTON_TOOLTIP_NEXT("Next");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a HtmlTag.
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
