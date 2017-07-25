package foodsharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.Browser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class BusinessPage extends PageObject{

    private static final String title = "foodsharing | Spender-Betriebe | ";
    private static final String name = "not set";
    private static final String _scrollbox = "div.field > div.ui-widget.ui-widget-content.corner-bottom.margin-bottom.ui-padding > div.slimScrollDiv";
    private static final SimpleDateFormat date_format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss", Locale.getDefault());


    BusinessPage(Browser browser) {
        super(browser);
    }

    public String title() {
        return browser().title();
    }

    public List<Calendar> get_open_dates() {
        List<Calendar> openDates = new LinkedList();
        List<WebElement> scrollbox = findElements(_scrollbox);
        List<WebElement> entries = scrollbox.get(0).findElements(By.cssSelector("div.element-wrapper"));
        for (WebElement entry : entries) {
            if (entry.getAttribute("outerHTML").contains("Mich hier eintragen")) {
                String timestamp = entry.findElement(By.tagName("input")).getAttribute("value");
                try {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date_format.parse(timestamp));// all done
                    openDates.add(calendar);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return openDates;
    }

    public Business create_business() {
        Business business = new Business(get_current_url());
        business.name(name());
        business.open_dates(get_open_dates());
        return business;
    }

    private String name() {
        return title().replace("foodsharing | Spender-Betriebe | ", "");
    }
}
