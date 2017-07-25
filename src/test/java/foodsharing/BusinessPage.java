package foodsharing;

import selenium.Browser;

public class BusinessPage extends PageObject{

    private static final String title = "foodsharing | Spender-Betriebe | ";
    private static final String name = "not set";
    private static final String scrollbox = "div.field > div.ui-widget.ui-widget-content.corner-bottom.margin-bottom.ui-padding > div.slimScrollDiv";

    BusinessPage(Browser browser) {
        super(browser);
    }

    public String title() {
        return title + name;
    }

    public Object get_open_dates() {
        return null;
    }
}
