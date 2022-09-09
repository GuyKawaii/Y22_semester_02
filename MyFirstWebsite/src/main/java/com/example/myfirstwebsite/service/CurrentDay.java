package com.example.myfirstwebsite.service;

import java.time.LocalDate;

public class CurrentDay {
    static LocalDate localDate = LocalDate.now();
    static String weekDay = localDate.getDayOfWeek().toString();
    public static String isFriday() {
        if ("FRIDAY".equals(weekDay)) {
            return """
                    Ja bro det er
                    <<<FRIDAY>>>""";
        } else {
            return """
                    NO BRO der er
                    """ + weekDay;
        }
    }

    public static String getDay() {
        return weekDay;
    }
}
