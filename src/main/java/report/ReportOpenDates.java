package report;

import foodsharing.*;
import selenium.Browser;
import user.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class ReportOpenDates {

    private final Browser browser;
    private final User user;
    private List<Business> businesses;
    private final HashMap<Calendar, LinkedList<Business>> open_date_and_business;

    public ReportOpenDates(Browser browser, User user) {
        this.browser = browser;
        this.user = user;
        this.open_date_and_business = new HashMap<>();
    }

    public void read_open_dates_of_all_cooperating_businesses() {
        navigate_to_business_list();
        read_all_cooperating_businesses_paths();
        read_all_cooperating_businesses_from_path();
    }

    private void navigate_to_business_list() {
        new LoginPage(browser.navigate_to(LoginPage.url()))
                .login_as(user)
                .navigate_to_businesses();
    }

    private void read_all_cooperating_businesses_paths() {
        BusinessListPage business_list_page = new BusinessListPage(browser);
        businesses = business_list_page.get_cooperating_businesses_from_all_pages();
    }

    private void read_all_cooperating_businesses_from_path() {
        for (Business business : businesses) {
            read_cooperation_information_for(business);
        }
    }

    private void read_cooperation_information_for(Business business) {
        browser.navigate_to(business.path());
        BusinessPage business_page = new BusinessPage(browser);
        business.name(business_page.name());
        business.open_dates(business_page.displays_open_dates());
    }

    public String open_dates_sorted_chronologically() {
        create_open_date_and_business_dictionary();
        return open_dates_sorted_chronologically_to_string();
    }

    private void create_open_date_and_business_dictionary() {
        for (Business business : businesses) {
            for (Calendar calendar : business.open_dates()) {
                LinkedList<Business> add_to_businesses = open_date_and_business.get(calendar);
                if (add_to_businesses == null) { add_to_businesses = new LinkedList<>(); }
                add_to_businesses.add(business);
                open_date_and_business.put(calendar, add_to_businesses);
            }
        }
    }

    private String open_dates_sorted_chronologically_to_string() {
        SortedSet<Calendar> open_dates = new TreeSet<>(open_date_and_business.keySet());
        StringBuilder builder = new StringBuilder();
        for(Calendar open_date : open_dates) {
            builder
                    .append(format(open_date) + ": ")
                    .append(businesses_with_open_dates_on(open_date))
                    .append("\n");
        }
        return builder.toString();
    }

    private String format(Calendar open_date) {
        Date date = open_date.getTime();
        SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format_date.format(date);
    }

    private String businesses_with_open_dates_on(Calendar open_date) {
        List<Business> businesses = open_date_and_business.get(open_date);
        StringBuilder builder = new StringBuilder();
        for (Business business : businesses) {
            builder.append(business.name() + " ");
        }
        return builder.toString();
    }
}
