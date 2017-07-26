package usecase;

import foodsharing.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selenium.Browser;
import selenium.Firefox;
import user.Esteban;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

public class ExtractAllOpenDatesFromAllBusinesses {

    private Browser browser;
    private BusinessListPage business_list;

    @Before
    public void before() {
        browser = new Firefox();
        browser.navigate_to(LoginPage.url());
        LoginPage login_page = new LoginPage(browser);
        DashBoard dashboard = login_page.login_as(new Esteban());
        dashboard.navigate_to_businesses();
        business_list = new BusinessListPage(dashboard.browser());
    }

    @After
    public void after() {
        browser.quit();
    }

    @Test
    public void given_business_path_when_navigating_to_then_extract_all_open_dates() {
        Business business = new Business("https://foodsharing.de/?page=fsbetrieb&id=15922");
        browser.navigate_to(business.path());
        BusinessPage business_page = new BusinessPage(browser);
        business.name(business_page.name());
        business.open_dates(business_page.displays_open_dates());
        assertNotNull(business);
        System.out.println(business);
    }

    @Test
    public void given_foodsharing_when_extracting_all_open_dates_from_all_businesses_then_list_open_dates_by_businesses() {
        List<Business> businesses = business_list.get_cooperating_businesses_from_all_pages();
        for (Business business : businesses) {
            browser.navigate_to(business.path());
            BusinessPage business_page = new BusinessPage(browser);
            business.name(business_page.name());
            business.open_dates(business_page.displays_open_dates());
        }
        assertFalse(businesses.isEmpty());
    }
}
