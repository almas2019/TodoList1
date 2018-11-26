package ui;




import Model.StatusUpdater;
import Observer.StatusTracker;

import java.time.LocalDate;

public class DailyChecklist extends EntryManager {
public DailyChecklist(){
    addObserver(new StatusTracker());
    setListName("Daily CheckList");
    setDoneandNotDone();
}
    private DateFeatures df = new DateFeatures();

   public void setDoneandNotDone() {
   this.DoneStatus= "Done for Today";
   this.NotDoneStatus = "In Progress";}


    public void newEntry(String value)  {
        super.newEntry(value,df.today);
    }

    public void takeoutEntries(String value) {
       setChanged();
       StatusUpdater statusUpdater = new StatusUpdater(listName, entry.getName(),entry.getDateDone());
       notifyObservers(statusUpdater);
            entry.setDaysLeft(1);
            LocalDate tomorrow = df.today.plusDays(1);
        entry.setDueDate(tomorrow);
      }

    }





