package foodsharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.Browser;

import java.util.LinkedList;
import java.util.List;

public class BusinessPage extends PageObject{

    private static final String title = "foodsharing | Spender-Betriebe | ";
    private static final String name = "not set";
    private static final String _scrollbox = "div.field > div.ui-widget.ui-widget-content.corner-bottom.margin-bottom.ui-padding > div.slimScrollDiv";

    BusinessPage(Browser browser) {
        super(browser);
    }

    public String title() {
        return title + name;
    }

    public List<String> get_open_dates() {
        List<String> openDates = new LinkedList();
        List<WebElement> scrollbox = findElements(_scrollbox);
        List<WebElement> entries = scrollbox.get(0).findElements(By.cssSelector("div.element-wrapper"));
        for (WebElement entry : entries) {
            if (entry.getAttribute("outerHTML").contains("Mich hier eintragen")) {
                openDates.add(entry.findElement(By.tagName("input")).getAttribute("value"));
            }
        }
        return openDates;
    }

    public Business create_business() {
        Business business = new Business(null);
        return null;
    }
}
