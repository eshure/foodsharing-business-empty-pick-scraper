package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    private static WebDriver driver;

    public void navigate_to(String url) {
        driver.get(url);
    }

    public void driver(FirefoxDriver driver) {
        this.driver = driver;
    }

    public void quit() {
        driver.quit();
    }
}