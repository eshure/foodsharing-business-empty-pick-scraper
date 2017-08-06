package usecase;

import org.junit.Test;
import report.ReportOpenDates;
import selenium.Firefox;
import user.Esteban;

public class ExtractAllOpenDatesFromAllBusinesses {

    @Test
    public void given_foodsharing_when_extracting_all_open_dates_from_all_businesses_then_list_open_dates_by_businesses() {
        ReportOpenDates report = new ReportOpenDates(new Firefox(), new Esteban());
        String printme = report
                .read_open_dates_of_all_cooperating_businesses()
                .quit_browser()
                .open_dates_sorted_chronologically();
        System.out.println(printme);
    }

    @Test
    public void given_foodsharing_when_extracting_all_open_dates_from_all_businesses_then_list_open_dates_by_businesses_after_now() {
        ReportOpenDates report = new ReportOpenDates(new Firefox(), new Esteban());
        String printme = report
                .read_open_dates_of_all_cooperating_businesses()
                .quit_browser()
                .open_dates_sorted_chronologically_after_now();
        System.out.print(printme);
    }
}
