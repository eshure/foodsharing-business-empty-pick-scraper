package foodsharing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selenium.Browser;
import selenium.Firefox;
import user.Esteban;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class BusinessPageTest {

    private Browser browser;
    private LoginPage login_page;
    private BusinessListPage business_list;

    @Before
    public void before() {
        browser = new Firefox();
        browser.navigate_to(LoginPage.url());
        login_page = new LoginPage(browser);
        DashBoard dashboard = login_page.login_as(new Esteban());
        dashboard.navigate_to_businesses();
        business_list = new BusinessListPage(dashboard.browser());
    }

    @After
    public void after() {
//         browser.quit();
    }

    @Test
    public void given_businesspage_when_contains_green_businesses_then_contains_cooperating_businesses() {
        assertTrue(business_list.contains_cooperating_businesses());
    }

    @Test
    public void given_businesspage_when_contains_green_businesses_then_extract_all() {
        List<Business> cooperating_businesses = business_list.get_cooperating_businesses();
        assertTrue( ! cooperating_businesses.isEmpty());
    }

    @Test
    public void given_businesspage_when_cooperating_businesses_exist_then_navigat_to_first_found() {
        List<Business> cooperating_businesses = business_list.get_cooperating_businesses();
        browser.navigate_to(cooperating_businesses.get(0).path());
        BusinessPage business_page = new BusinessPage(browser);
        assertTrue(business_page.title().startsWith("foodsharing | Spender-Betriebe |"));
    }
}