package Date;

public class DateNizek {
    private int day;
    private int month;
    private int year;

    public DateNizek(int day, int month, int year) {
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

    public int differenceInDay() {
        return this.day - java.time.LocalDate.now().getDayOfMonth();
    }
    public int differenceInMonth() {
        return (this.month - java.time.LocalDate.now().getMonthValue()) + 31;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", year,month,day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateNizek dateNizek = (DateNizek) o;
        return day == dateNizek.day && month == dateNizek.month && year == dateNizek.year;
    }

}
