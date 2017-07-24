package foodsharing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.Browser;

import java.util.List;

abstract class PageObject {

    private static final long timeout_in_seconds = 10;

    private final Browser browser;

    private WebDriverWait wait = null;

    PageObject(Browser browser) {
        this.browser = browser;
        wait = new WebDriverWait(browser.driver(), timeout_in_seconds);
    }

    Browser browser() {
        return browser;
    }

    boolean has(String cssSelector) {
        wait_for_element(cssSelector);
        List<WebElement> elements = findElements(cssSelector);
        return ! elements.isEmpty();
    }

    List<WebElement> findElements(String cssSelector) {
        wait_for_element(cssSelector);
        return browser.driver().findElements(By.cssSelector(cssSelector));
    }

    WebElement findElement(String cssSelector) {
        return findElements(cssSelector).get(0);
    }

    private void wait_for_element(String cssSelector) {
        By by = By.cssSelector(cssSelector);
        long start_waiting = System.currentTimeMillis();
        wait.until(ExpectedConditions.elementToBeClickable(by));
        System.out.println("Waited for " + by + " " + (System.currentTimeMillis() - start_waiting) + " ms.");
    }


    WebElement into(String css_selector) {
        return findElement(css_selector);
    }

    void click_on(String css_selector) {
        findElement(css_selector).click();
    }

    abstract String title();

    public void navigate_to(String url) {
        browser.navigate_to(url);
    }
}
