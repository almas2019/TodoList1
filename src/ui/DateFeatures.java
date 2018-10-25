package ui;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;



public class DateFeatures {
    private LocalDate today = LocalDate.now();
public DateFeatures() {
}
//REQUIRES: a Date in the format YYYY-MM-DD
// Effects: Returns the differences between today and the dueDate
   public long getDayCount(LocalDate entrydate) {
    long daysBetween = ChronoUnit.DAYS.between(today, entrydate); //code reference stackoverflow user:javaLearner
    return daysBetween;}}
