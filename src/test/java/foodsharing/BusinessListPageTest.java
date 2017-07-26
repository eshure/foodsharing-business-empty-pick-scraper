package foodsharing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selenium.Browser;
import selenium.Firefox;
import user.Esteban;

import static org.junit.Assert.assertEquals;

public class BusinessListPageTest {

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
        browser.quit();
    }

    @Test
    public void given_business_list_when_displaying_page_then_page_one_is_displayed() {
        String page_displayed = business_list.displays_page();
        assertEquals("1", page_displayed);
    }

    @Test
    public void given_business_list_when_click_on_next_page_then_page_two_is_displayed() {
        business_list.click_on_next_page();
        String page_displayed = business_list.displays_page();
        assertEquals("2", page_displayed);
    }

    @Test
    public void given_business_list_when_clicking_to_the_end_then_handle_amount_of_page_minus_one() {
        int amount_of_pages = Integer.parseInt(business_list.displays_amount_of_pages());
        int amount_of_available_pages = business_list.amount_of_available_pages();
        int offset = amount_of_available_pages - amount_of_pages;
        assertEquals(1, offset);
    }

}
