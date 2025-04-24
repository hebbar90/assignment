package com.wisdomleaf.clock.service;

import com.wisdomleaf.clock.exception.InvalidTimeFormatException;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    private static final String[] HOURS = {
        "midnight", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten", "eleven", "midday", "one", "two", "three",
        "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"
    };

    private static final String[] MINUTES = {
        "o'clock", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
        "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty",
        "thirty one", "thirty two", "thirty three", "thirty four", "thirty five",
        "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty",
        "forty one", "forty two", "forty three", "forty four", "forty five",
        "forty six", "forty seven", "forty eight", "forty nine", "fifty",
        "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
        "fifty six", "fifty seven", "fifty eight", "fifty nine"
    };

    public String convertTimeToWords(String time) {
        if (!time.matches("^([01]\\d|2[0-3]):[0-5]\\d$")) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour == 0 && minute == 0) return "It's Midnight";
        if (hour == 12 && minute == 0) return "It's Midday";

        return String.format("It's %s %s", HOURS[hour], MINUTES[minute]);
    }
}
