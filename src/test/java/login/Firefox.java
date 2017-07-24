package login;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends Browser {

    public Firefox() {
        System.setProperty("webdriver.gecko.driver", "/home/sammann/Downloads/foodsharing-business-empty-pick-scraper/src/main/resources/geckodriver");
        driver(new FirefoxDriver());
    }
}
