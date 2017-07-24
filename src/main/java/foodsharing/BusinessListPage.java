package foodsharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.Browser;

import java.util.LinkedList;
import java.util.List;

public class BusinessListPage extends PageObject{

    private static final String title = "foodsharing";
    private static final String coorporating_link = "a.ampel.ampel-gruen";
    private static final String tbody = "tbody";
    private static final String tr = "tr";

    public BusinessListPage(Browser browser) {
        super(browser);

    }

    @Override
    String title() {
        return title;
    }

    public boolean contains_cooperating_businesses() {
        return has(coorporating_link);
    }

    public List<Business> get_cooperating_businesses() {
        List<Business> cooperating_businesses = new LinkedList<Business>();
        WebElement table = findElement(tbody);
        List<WebElement> trs = table.findElements(By.tagName(tr));
        for (WebElement tr : trs) {
            try {
                tr.findElement(By.cssSelector(coorporating_link)); // throws exception if not existant
                String href = tr.findElement(By.cssSelector("a.linkrow.ui-corner-all")).getAttribute("href");
                cooperating_businesses.add(new Business(href));
            } catch (Exception e) {
                System.out.println(tr.findElement(By.cssSelector("a.linkrow.ui-corner-all")).getAttribute("innerHTML") + " not cooperating.");
            }
        }
        return cooperating_businesses;
    }
}
