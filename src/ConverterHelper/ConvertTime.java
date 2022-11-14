package ConverterHelper;

import Date.DateNizek;
import com.github.eloyzone.jalalicalendar.DateConverter;
import com.github.eloyzone.jalalicalendar.JalaliDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ConvertTime {
    public static String convertToGregorian(DateNizek dateNizek) {
        DateConverter dateConverter = new DateConverter();
        LocalDate localDate = dateConverter.jalaliToGregorian(dateNizek.getYear(), dateNizek.getMonth(), dateNizek.getDay());
        return localDate.toString();
    }
    public static String convertToPersian(String date) {
        DateConverter dateConverter = new DateConverter();
        String[] dateArray = date.split("-");
        String year = dateArray[0];
        String month = dateArray[1];
        String day = dateArray[2];
        JalaliDate jalaliDate2 = dateConverter.gregorianToJalali(
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(day));
        return jalaliDate2.toString();
    }
    public static double findDifferencesInDays(String inputDueDate) {
        double differenceInTime = 0;
        double differenceInDays = 0;
        try {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            String formatedLocalDate = formatter.format(date);
            Date dueDate = formatter.parse(inputDueDate);
            Date localDate = formatter.parse(formatedLocalDate);
            System.out.println(dueDate);
            System.out.println(localDate);
            differenceInTime = dueDate.getTime() - localDate.getTime();
            differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(differenceInDays);
        return differenceInDays;
    }

}
