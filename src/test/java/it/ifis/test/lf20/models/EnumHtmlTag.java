/*
 * 
 */
package it.ifis.test.lf20.models;

/**
 * Enumeration dei tag HTML.
 */
public enum EnumHtmlTag {

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

	/** The arch button. */
	ARCH_BUTTON("arch-button"),

	/** The arch fieldset. */
	ARCH_FIELDSET("arch-fieldset"),

	/** The md tab item. */
	MD_TAB_ITEM("md-tab-item"),

	/** The span. */
	SPAN("span"),

	/** The legend. */
	LEGEND("legend"),

	/** The aria label. */
	ARIA_LABEL("aria-label"),

	/** The label. */
	LABEL("label"),

	/** The value. */
	VALUE("value"),

	/** The arch input text. */
	ARCH_INPUT_TEXT("arch-input-text"),

	/** The input. */
	INPUT("input"),

	/** The icon block. */
	ICON_BLOCK("block");

	/** The popup name. */
	private String name;

	/**
	 * Instantiates a EnumHtmlTag.
	 *
	 * @param name the name
	 */
	private EnumHtmlTag(String name) {
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
