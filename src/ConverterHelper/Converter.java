package ConverterHelper;

public class Converter {
    private final String DATE_FORMAT_PERSIAN = "yyyy-MM-dd HH:mm:ss";
    private final String DATE_FORMAT_UTC = "yyyy-dd-MM HH:mm:ss";

    public static Double convertToDouble(String text) {
        return Double.parseDouble(text);
    }
    public static String convertToString(Double file) {
        return String.valueOf(file);
    }


}
