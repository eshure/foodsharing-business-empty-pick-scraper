package foodsharing;

import selenium.Browser;

public class BusinessPage extends PageObject{

    private static final String title = "foodsharing | Spender-Betriebe | ";
    private static final String name = "not set";

    BusinessPage(Browser browser) {
        super(browser);
    }

    public String title() {
        return title + name;
    }
}
