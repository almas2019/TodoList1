package ui;


import Model.StatusUpdater;
import Observer.StatusTracker;

import java.time.LocalDate;

public class RegularEntries extends EntryManager {
    DateFeatures df = new DateFeatures();
    public RegularEntries(){
        setListName("Regular ToDo List");
        addObserver(new StatusTracker());
    }
    public void newEntry(String value, LocalDate date) {
        setDoneandNotDone();
        super.newEntry(value, date);

    }

    public void setDoneandNotDone() {
        this.DoneStatus= "Done";
        this.NotDoneStatus = "Not Done";}

    public void takeoutEntries(String value) {
        setDoneandNotDone();
        entry.setStatus(DoneStatus);
        setChanged();
        StatusUpdater statusUpdater = new StatusUpdater(listName, entry.getName(),entry.getDateDone());
        notifyObservers(statusUpdater);
        entry.setDaysLeft(0);
        System.out.println("Entry Marked as Done!");
        entry.setEntryManager(this);
    }
}
