package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    private WebDriver driver;

    void driver(FirefoxDriver driver) {
        this.driver = driver;
    }

    public void quit() {
        driver.quit();
    }

    public String title() {
        return driver.getTitle();
    }

    public WebDriver driver() {
        return driver;
    }

    public void navigate_to(String url) {
        driver.get(url);
    }
}