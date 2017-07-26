package report;

import org.junit.Test;
import selenium.Firefox;
import user.Esteban;

public class ReportOpenDatesTest {


    @Test
    public void given_foodsharing_when_report_open_dates_then_report_open_dates() {
        ReportOpenDates report = new ReportOpenDates(new Firefox(), new Esteban());
        report.read_open_dates_of_all_cooperating_businesses();
        report.print_open_dates_sorted_by_time();
    }
}
