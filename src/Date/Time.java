package Date;

public class Time {
    int minute;
    int hour;

    public Time() {
        this.minute = java.time.LocalTime.now().getMinute();
        this.hour = java.time.LocalTime.now().getHour();
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

    @Override
    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }
}
