package ui;


import Model.StatusUpdater;
import Observer.StatusTracker;

import java.time.LocalDate;

public class RegularEntries extends EntryManager {
    DateFeatures df = new DateFeatures();
    public RegularEntries(){
        addObserver(new StatusTracker());
    }
    private String ListName = "Regular ToDo List";
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
        StatusUpdater statusUpdater = new StatusUpdater(ListName, entry.getName(),df.today);
        notifyObservers(statusUpdater);
        entry.setDaysLeft(0);
        System.out.println("Entry Marked as Done!");
        entry.setEntryManager(this);
    }
}
