package foodsharing;

import selenium.Browser;

public class BusinessPage extends PageObject{

    private static final String title = "foodsharing";

    public BusinessPage(Browser browser) {
        super(browser);

    }

    @Override
    String title() {
        return title;
    }

    public boolean contains_cooperating_businesses() {
        return false;
    }
}
