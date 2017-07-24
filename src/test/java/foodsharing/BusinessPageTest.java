package foodsharing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selenium.Browser;
import selenium.Firefox;
import user.Esteban;

import static junit.framework.TestCase.assertNotNull;

public class BusinessPageTest {

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
    public void given_businesspage_when_contains_green_businesses_then_expect_more_than_extract_first() {
        DashBoard dashboard = login_page.login_as(new Esteban());
        dashboard.navigate_to_businesses();
        BusinessPage business_page = new BusinessPage(dashboard.browser());
    }
}
