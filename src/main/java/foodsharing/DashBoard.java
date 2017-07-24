package foodsharing;

import selenium.Browser;

public class DashBoard extends PageObject {

    private static final String title = "foodsharing | Dashboard";
    private static final String url_to_businesses = "https://foodsharing.de/?page=betrieb&bid=139";

    DashBoard(Browser browser) {
        super(browser);
    }

    @Override
    String title() {
        return title;
    }

    public void navigate_to_businesses() {
        navigate_to(url_to_businesses);
    }
}
