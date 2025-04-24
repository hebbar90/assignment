package com.wisdomleaf.clock;

import com.wisdomleaf.clock.exception.InvalidTimeFormatException;
import com.wisdomleaf.clock.service.TimeService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeServiceTest {

    private TimeService timeService = new TimeService();

    @Test
    public void testMidnight() {
        assertEquals("It's Midnight", timeService.convertTimeToWords("00:00"));
    }

    @Test
    public void testMidday() {
        assertEquals("It's Midday", timeService.convertTimeToWords("12:00"));
    }

    @Test
    public void testRegularTime() {
        assertEquals("It's eight thirty four", timeService.convertTimeToWords("08:34"));
    }

    @Test(expected = InvalidTimeFormatException.class)
    public void testInvalidTime() {
        timeService.convertTimeToWords("25:61");
    }
}
