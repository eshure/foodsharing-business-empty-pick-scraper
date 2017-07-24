package foodsharing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selenium.Browser;
import selenium.Firefox;
import user.Esteban;

import static junit.framework.TestCase.assertNotNull;

public class DashboardTest {

    private Browser browser;
    private LoginPage login_page;

    @Before
    public void before() {
        browser = new Firefox();
        browser.navigate_to(LoginPage.url());
        login_page = new LoginPage(browser);
    }

    @After
    public void after() {
//         browser.quit();
    }

    @Test
    public void given_dashboard_when_navigating_to_businesses_expect_not_null() {
        DashBoard dashboard = login_page.login_as(new Esteban());
        dashboard.navigate_to_businesses();
        BusinessListPage business_list = new BusinessListPage(dashboard.browser());
        assertNotNull(business_list);
    }
}
