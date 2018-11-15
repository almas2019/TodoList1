package ui;




import Model.StatusUpdater;
import Observer.StatusTracker;

import java.time.LocalDate;

public class DailyChecklist extends EntryManager {
public DailyChecklist(){
    addObserver(new StatusTracker());
}
    private DateFeatures df = new DateFeatures();
private String ListName = "Daily Checklist";
   public void setDoneandNotDone() {
   this.DoneStatus= "Done for Today";
   this.NotDoneStatus = "In Progress";}


    public void newEntry(String value)  {
       setDoneandNotDone();
        super.newEntry(value,df.today);
    }

    public void takeoutEntries(String value) {
       setDoneandNotDone();
       entry.setStatus(DoneStatus);
       setChanged();
       StatusUpdater statusUpdater = new StatusUpdater(ListName, entry.getName(),df.today);
       notifyObservers(statusUpdater);
            entry.setDaysLeft(1);
            LocalDate tomorrow = df.today.plusDays(1);
        entry.setDueDate(tomorrow);
      }

    }





