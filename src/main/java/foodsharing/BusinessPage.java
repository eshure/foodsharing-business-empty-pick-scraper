package foodsharing;

import selenium.Browser;

public class BusinessPage extends PageObject{

    private static final String title = "foodsharing";
    private static final String coorporating_link = "a.ampel.ampel-gruen";

    public BusinessPage(Browser browser) {
        super(browser);

    }

    @Override
    String title() {
        return title;
    }

    public boolean contains_cooperating_businesses() {
        return has(coorporating_link);
    }
}
