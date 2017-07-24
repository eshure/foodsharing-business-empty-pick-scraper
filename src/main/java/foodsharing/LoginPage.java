package foodsharing;

import org.openqa.selenium.By;
import selenium.Browser;

class LoginPage extends PageObject {

    private static final By input_email = By.cssSelector("input[name='email_adress'][type='email']");
    private static final String title = "foodsharing | Restlos glücklich!";

    LoginPage(Browser browser) {
        super(browser);
    }

    @Override
    String title() {
        return title;
    }

    static String url() {
        return "https://foodsharing.de/";
    }

    boolean is_itself() {
        return has(input_email);
    }
}