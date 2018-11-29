package ui;




import Exceptions.InvalidItemException;
import Observer.StatusTracker;

import java.time.LocalDate;

public class DailyChecklist extends EntryManager {
    private String DAILY_CHECKLIST_NAME = "Daily CheckList";

    public DailyChecklist() {
        addObserver(new StatusTracker());
        setListName(DAILY_CHECKLIST_NAME);
        setDoneandNotDone();
    }


    public void setDoneandNotDone() {
        this.DoneStatus = "Done for Today";
        this.NotDoneStatus = "In Progress";
    }


    public void newEntry(String value) {
        super.newEntry(value, date1.today);
    }

    public void checkOffDL(String value) throws InvalidItemException {
        LocalDate tomorrow = date1.tomorrow;
        super.checkOffEntries(value, 1, tomorrow);
    }
}






