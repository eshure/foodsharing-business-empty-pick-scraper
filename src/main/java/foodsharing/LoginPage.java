package foodsharing;

import selenium.Browser;
import user.User;

public class LoginPage extends PageObject {

    private static final String title = "foodsharing | Restlos glücklich!";
    private static final String input_email = "input[name='email_adress'][type='email']";
    private static final String input_password = "input[name='password'][type='password']";
    private static final String submit = "input[type='submit']";

    public LoginPage(Browser browser) {
        super(browser);
    }

    @Override
    String title() {
        return title;
    }

    public static String url() {
        return "https://foodsharing.de/";
    }

    public DashBoard login_as(User user) {
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