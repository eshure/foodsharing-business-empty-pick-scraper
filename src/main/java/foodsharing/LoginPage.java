package foodsharing;

import org.openqa.selenium.By;
import selenium.Browser;
import user.User;

class LoginPage extends PageObject {

    private static final String title = "foodsharing | Restlos glücklich!";
    private static final By input_email = By.cssSelector("input[name='email_adress'][type='email']");
    private static final By input_password = By.cssSelector("input[name='password'][type='password']");
    private static final By submit = By.cssSelector("input[type='submit']");

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

    DashBoard login_as(User user) {
        System.out.println(user);
        enter_email_adress_to(user.email());
        enter_password(user.password());
        click_on(submit);
        return new DashBoard(browser());
    }

    private void enter_email_adress_to(String email) {
        into(input_email).sendKeys(email);
    }

    private void enter_password(String password) {
        into(input_password).sendKeys(password);
    }
}