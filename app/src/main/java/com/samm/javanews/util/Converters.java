package com.samm.javanews.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Converters {

    public static String formatDate(String dateString) throws ParseException {
        // Parse the input string into a Date object
        SimpleDateFormat inputFormat =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = inputFormat.parse(dateString);

        // Format the Date object into the desired string format
        SimpleDateFormat outputFormat =
                new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US);
        assert date != null;
        return outputFormat.format(date);
    }
}
