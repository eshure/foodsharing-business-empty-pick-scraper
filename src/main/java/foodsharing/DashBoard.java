package foodsharing;

import selenium.Browser;

public class DashBoard extends PageObject {

    private static final String title = "foodsharing | Dashboard";

    DashBoard(Browser browser) {
        super(browser);
    }

    @Override
    String title() {
        return title;
    }
}
