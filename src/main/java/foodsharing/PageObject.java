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

    boolean has(By by) {
        wait_for_element(by);
        List<WebElement> elements = findElements(by);
        return ! elements.isEmpty();
    }

    private List<WebElement> findElements(By by) {
        return browser.driver().findElements(by);
    }

    private void wait_for_element(By by) {
        long start_waiting = System.currentTimeMillis();
        wait.until(ExpectedConditions.elementToBeClickable(by));
        System.out.println("Waited for " + by + " " + (System.currentTimeMillis() - start_waiting) + " ms.");
    }

    abstract String title();
}
