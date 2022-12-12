package datetimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeApi {
    private static final int YEAR_INDEX = 0;
    private static final int MONTH_INDEX = 1;
    private static final int DAY_OF_MONTH_INDEX = 2;
    /**
     * Return the current date as a String depending on a query.
     * <p>
     * The query can be passed for the whole date or for it's part:
     * - FULL - current date as a whole: year, month, day of month
     * formatted as `YYYY-MM-DD` (a default return value);
     * - YEAR - current year;
     * - MONTH - name of the current month;
     * - DAY - current day of month;
     * In any other case throw DateTimeException.
     **/
    public String todayDate(DateTimePart datePart) throws DateTimeException {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeException r = new DateTimeException("wrong date");
        if (datePart == DateTimePart.FULL) {
            return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE).toString();
        }
        if (datePart == DateTimePart.YEAR) {
            return localDateTime.format(DateTimeFormatter.ofPattern("yyyy")).toString();
        }
        if (datePart == DateTimePart.MONTH) {
            return localDateTime.format(DateTimeFormatter.ofPattern("LLLL", Locale.ENGLISH)).toString().toUpperCase();
        }
        if (datePart == DateTimePart.DAY) {
            return localDateTime.format(DateTimeFormatter.ofPattern("dd")).toString().toUpperCase();

        } else {
            throw r;
        }
    }

    /**
     * Given an Array of 3 elements, where
     * - 1-st element is a `year`;
     * - 2-nd element is s `month`;
     * - 3-rd element is a `day of month`;
     * <p>
     * Return LocalDate built from these elements. If Array contains more than 3 elements - throw DateTimeException.
     */
    public LocalDate getDate(Integer[] dateParams) {
        if (dateParams.length != 3) {
            throw new DateTimeException("Invalid parameters");
        }
        return LocalDate.of(dateParams[YEAR_INDEX], dateParams[MONTH_INDEX], dateParams[DAY_OF_MONTH_INDEX]);

    }

    /**
     * Given the time and the number of hours to add, return the changed time.
     */
    public LocalTime addHours(LocalTime localTime, Integer hoursToAdd) {
        return localTime.plusHours(hoursToAdd);
    }

    /**
     * Given the time and the number of minutes to add, return the changed time.
     */
    public LocalTime addMinutes(LocalTime localTime, Integer minutesToAdd) {
        return localTime.plusMinutes(minutesToAdd);
    }

    /**
     * Given the time and the number of seconds to add, return the changed time.
     */
    public LocalTime addSeconds(LocalTime localTime, Integer secondsToAdd) {
        return localTime.plusSeconds(secondsToAdd);
    }

    /**
     * Given the date and the number of weeks to add, return the changed date.
     */
    public LocalDate addWeeks(LocalDate localDate, Integer numberOfWeeks) {
        return localDate.plusWeeks(numberOfWeeks);
    }

    /**
     * Given a random `someDate` date, return one of the following Strings:
     * - "`someDate` is after `currentDate`"
     * if `someDate` is in the future relating to the `current date`;
     * - "`someDate` is before `currentDate`"
     * if `someDate` is in the past relating to the `current date`;
     * - "`someDate` is today"
     * if `someDate` is today;
     */
    public String beforeOrAfter(LocalDate someDate) {
        LocalDate today = LocalDate.now();
        return someDate.equals(today) ? someDate + " is today"
                : someDate.isAfter(today) ? someDate + " is after " + today
                : someDate + " is before " + today;
    }

    /**
     * Given a String representation of a date and some timezone,
     * return LocalDateTime in this timezone.
     */
    public LocalDateTime getDateInSpecificTimeZone(String dateInString, String zone) {
        Instant instant = Instant.parse(dateInString);
        ZoneId zoneId = TimeZone.getTimeZone(zone).toZoneId();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * Given some LocalDateTime, return an OffsetDateTime with the local time offset applied
     * (`+02:00` for Ukraine).
     * <p>
     * Example: we receive a LocalDateTime with a value `2019-09-06T13:17`.
     * We should return the OffsetDateTime with a value `2019-09-06T13:17+02:00`,
     * where `+02:00` is the offset for our local timezone.
     * <p>
     * OffsetDateTime is recommended to use for storing date values in a database.
     */
    public OffsetDateTime offsetDateTime(LocalDateTime localTime) {
        ZoneOffset zoneOffset = ZoneOffset.of("+02:00");
        return OffsetDateTime.of(localTime, zoneOffset);
    }

    /**
     * Given a String formatted as `yyyyMMdd`,
     * return LocalDate object built from this String.
     */
    public LocalDate parseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * Given a String formatted as `d MMM yyyy` (MMM - Sep, Oct, etc),
     * return LocalDate object built from this String.
     */
    public LocalDate customParseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH));
    }

    /**
     * Given some LocalDateTime, return a String formatted as
     * `day(2-digit) month(full name in English) year(4-digit) hours(24-hour format):minutes`.
     * <p>
     * Example: "01 January 2000 18:00".
     */
    public String formatDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", Locale.ENGLISH));
    }
}
