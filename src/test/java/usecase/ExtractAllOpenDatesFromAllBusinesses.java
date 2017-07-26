package usecase;

import foodsharing.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import report.ReportOpenDates;
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
    public void given_foodsharing_when_extracting_all_open_dates_from_all_businesses_then_list_open_dates_by_businesses() {
        ReportOpenDates report = new ReportOpenDates(new Firefox(), new Esteban());
        report.read_open_dates_of_all_cooperating_businesses();
        System.out.println(report.open_dates_sorted_chronologically());
    }
}
