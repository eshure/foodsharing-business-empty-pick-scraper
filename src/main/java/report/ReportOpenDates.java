package report;

import foodsharing.*;
import selenium.Browser;
import user.User;

import java.util.List;

public class ReportOpenDates {

    private final Browser browser;
    private final User user;
    private List<Business> businesses;

    ReportOpenDates(Browser browser, User user) {
        this.browser = browser;
        this.user = user;

    }

    void read_open_dates_of_all_cooperating_businesses() {
        navigate_to_business_list();
        read_all_cooperating_businesses_paths();
        read_all_cooperating_businesses_from_path();
    }

    private void navigate_to_business_list() {
        new LoginPage(browser.navigate_to(LoginPage.url()))
                .login_as(user)
                .navigate_to_businesses();
    }

    private void read_all_cooperating_businesses_paths() {
        BusinessListPage business_list_page = new BusinessListPage(browser);
        businesses = business_list_page.get_cooperating_businesses_from_all_pages();
    }

    private void read_all_cooperating_businesses_from_path() {
        for (Business business : businesses) {
            read_cooperation_information_for(business);
        }
    }

    private void read_cooperation_information_for(Business business) {
        browser.navigate_to(business.path());
        BusinessPage business_page = new BusinessPage(browser);
        business.name(business_page.name());
        business.open_dates(business_page.displays_open_dates());
    }
}
