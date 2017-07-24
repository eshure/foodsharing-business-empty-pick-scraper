package foodsharing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selenium.Browser;
import selenium.Firefox;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FoodsharingLoginPageTest {

    private Browser browser;

    @Before
    public void before() {
        browser = new Firefox();
    }

    @After
    public void after() {
        browser.quit();
    }

    @Test
    public void given_browser_navigate_to_foodsharing_then_expect_login_page_title() {
        browser.navigate_to(LoginPage.url());
        LoginPage login_page = new LoginPage(browser);
        assertEquals(login_page.title(), browser.title());
    }

    @Test
    public void given_login_page_when_entering_credentials_then_expect_successful_login() {

    }
}
