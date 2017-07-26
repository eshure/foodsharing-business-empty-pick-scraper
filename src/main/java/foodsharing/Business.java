package foodsharing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Business {
    private String path;
    private List<Calendar> open_dates;
    private String name;

    public Business(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }

    public void open_dates(List<Calendar> open_dates) {
        this.open_dates = open_dates;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(name)
                .append("\n")
                .append(path())
                .append("\n")
                .append(open_dates_to_string());
        return builder.toString();
    }

    private String open_dates_to_string() {
        SimpleDateFormat yyyy_mm_dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder builder = new StringBuilder();
        for (Calendar calendar : open_dates) {
            builder
                    .append(calendar.getTime().toString())
                    .append("\n");
        }
        return builder.toString();
    }

    public void name(String name) {
        this.name = name;
    }
}
