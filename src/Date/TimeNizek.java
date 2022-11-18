package Date;

import java.sql.Time;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class TimeNizek {
    int minute;
    int hour;


    public TimeNizek() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        this.minute = zonedDateTime.getMinute();
        this.hour = zonedDateTime.getHour();
    }
    public TimeNizek(int hour, int minute) {
        this.minute = minute;
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    public TimeNizek setTime(int hour, int minute) {
        return new TimeNizek(hour, minute);
    }


    @Override
    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }
}
