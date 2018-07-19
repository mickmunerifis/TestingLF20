package it.ifis.test.lf20.ui;

import java.util.List;

import org.openqa.selenium.WebElement;

import it.ifis.test.lf20.models.MenuLink;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class MenuLinkNavigation extends PageObject {
	
	public void selectMenuLink(MenuLink link) {		

		WebElement dropdown = getDriver().findElement(By.id("sub-menu-"));
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        for (WebElement option : options) {        	
        	if (option.getText().indexOf(link.getMenuLinkName()) != -1) {        		
                option.click(); 
                break;
            }        	
        }
    }
	
}
