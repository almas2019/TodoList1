package ui;




import java.time.LocalDate;

public class DailyChecklist extends EntryManager {
    private LocalDate  today = LocalDate.now();
   public void setDoneandNotDone() {
   this.DoneStatus= "Done for Today";
   this.NotDoneStatus = "In Progress";}


    public void newEntry(String value)  {
       setDoneandNotDone();
        super.newEntry(value,today);
    }
public void takeoutEntries(String value) {
       setDoneandNotDone();
            entry.setStatus(DoneStatus);
            entry.setDaysLeft(1);
            LocalDate tomorrow = today.plusDays(1);
        entry.setDueDate(tomorrow);
      }

    }





