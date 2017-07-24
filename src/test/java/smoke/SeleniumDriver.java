package smoke;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SeleniumDriver {

    @Test
    public void given_selenium_when_creating_driver_then_expect_not_null() {
        System.setProperty("webdriver.gecko.driver", "/home/sammann/Downloads/foodsharing-business-empty-pick-scraper/src/main/resources/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        assertNotNull(driver);
    }

    @Test
    public void given_internet_when_accessing_google_then_expect_page_title() {
        System.setProperty("webdriver.gecko.driver", "/home/sammann/Downloads/foodsharing-business-empty-pick-scraper/src/main/resources/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
        assertEquals("Google", driver.getTitle());
        driver.quit();
    }
}