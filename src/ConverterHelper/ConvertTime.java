package ConverterHelper;

import Date.TimeNizek;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConvertTime {
    public static TimeNizek convertToLocal(TimeNizek timeNizek) {
        ZoneId iranZI = ZoneId.of("Asia/Iran");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(iranZI);
        return new TimeNizek();
    }
}
