package Date;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    // TEST THESE VALIDATIONS!
    public void setDay(int day) {
        if (day <= 0 || day > 31) {
            return;
        }
        if (this.month <= 6) {
            if (day <= 31) {
                this.day = day;
            }
        } else if (this.month > 6) {
            if (day <= 30) {
                this.day = day;
            }
        }
    }
    public void setMonth(int month) {
        if (month <= 0 || month > 12) {
            return;
        }
        if (month <= 12) {
            this.month = month;
        }
    }

    public void setYear(int year) {
        if (year <= 0 || year > 1500) {
            return;
        }
        if (year > 1300) {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", year,month,day);
    }
}
