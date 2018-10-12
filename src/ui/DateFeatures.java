package ui;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;



public class DateFeatures {
    private Calendar cal = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    private LocalDate today = LocalDate.now();
public DateFeatures() {
   weeklaterNow(); }
//REQUIRES: A Date in the format YYYY/MM/DD
//Modifies: this
//Effects: returns a date 7 days from the date specified
    public LocalDate weeklaterNow() {
        LocalDate weeklater = today.plusDays(7); //code reference stackoverflow and Java manual
return weeklater;}
//REQUIRES: a Date in the format YYYY-MM-DD
// Effects: Returns the differences between today and the dueDate
   public long getDayCount(LocalDate entrydate) {
    long daysBetween = ChronoUnit.DAYS.between(today, entrydate); //code reference stackoverflow user:javaLearner
    return daysBetween;}
public String datetoString(LocalDate l) {
    DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    String format_1=(l).format(formatter_1); //code reference: javabrahman.com and stackoverflow user Basil Borque
    return format_1;
    }}
