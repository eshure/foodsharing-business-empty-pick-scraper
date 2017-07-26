package foodsharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.Browser;

import java.util.LinkedList;
import java.util.List;

public class BusinessListPage extends PageObject{

    private static final String title = "foodsharing";
    private static final String _coorporating_link = "a.ampel.ampel-gruen";
    private static final String _tbody = "tbody";
    private static final String _tr = "tr";
    private static final String _next ="span.ui-button-icon-primary.ui-icon.ui-icon-circle-arrow-e";
    private static final String page_number = "span.pagedisplay2 > span.seite";
    private static final String amount_of_pages = "span.pagedisplay2 > span.anz";

    public BusinessListPage(Browser browser) {
        super(browser);

    }

    @Override
    String title() {
        return title;
    }

    boolean contains_cooperating_businesses() {
        return has(_coorporating_link);
    }

    List<Business> get_cooperating_businesses() {
        List<Business> cooperating_businesses = new LinkedList<Business>();
        WebElement table = findElement(_tbody);
        List<WebElement> trs = table.findElements(By.tagName(_tr));
        for (WebElement tr : trs) {
            try {
                tr.findElement(By.cssSelector(_coorporating_link)); // throws exception if not existant
                String href = tr.findElement(By.cssSelector("a.linkrow.ui-corner-all")).getAttribute("href");
                cooperating_businesses.add(new Business(href));
            } catch (Exception e) {
                System.out.println(tr.findElement(By.cssSelector("a.linkrow.ui-corner-all")).getAttribute("innerHTML") + " not cooperating.");
            }
        }
        return cooperating_businesses;
    }

    void click_on_next_page() {
        click_on(_next);
    }

    String displays_page() {
        WebElement element = findElement(page_number);
        return element.getAttribute("innerHTML");
    }

    String displays_amount_of_pages() {
        WebElement element = findElement(amount_of_pages);
        return element.getAttribute("innerHTML");
    }

    int amount_of_available_pages() {
        return Integer.parseInt(displays_amount_of_pages()) - 1 ;
    }
}
