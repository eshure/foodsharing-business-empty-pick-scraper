package foodsharing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selenium.Browser;
import selenium.Firefox;
import user.Esteban;

import static junit.framework.TestCase.assertEquals;

public class FoodsharingLoginPageTest {

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
//        browser.quit();
    }

    @Test
    public void given_browser_navigate_to_foodsharing_then_expect_login_page_title() {
        assertEquals(login_page.title(), browser.title());
    }

    @Test
    public void given_login_page_when_login_as_esteban_then_expect_dashboard_page_title() {
        DashBoard dashboard = login_page.login_as(new Esteban());
        assertEquals(dashboard.title(), browser.title());
    }
}