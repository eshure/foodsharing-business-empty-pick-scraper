package login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FoodsharingLoginPageTest {

    private Firefox firefox;

    @Before
    public void before() {
        firefox = new Firefox();
    }

    @After
    public void after() {
        firefox.quit();
    }

    @Test
    public void given_browser_navigate_to_foodsharing_expect_login_page() {
        firefox.navigate_to(Page.url());
    }
}
