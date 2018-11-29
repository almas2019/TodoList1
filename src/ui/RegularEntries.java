package ui;


import Exceptions.InvalidItemException;
import Observer.StatusTracker;

import java.time.LocalDate;

public class RegularEntries extends EntryManager {
    private String REGULAR_LIST_NAME ="Regular ToDo List";


    public RegularEntries(){
        setListName(REGULAR_LIST_NAME);
        addObserver(new StatusTracker());
        setDoneandNotDone();
    }
    public void newEntry(String value, LocalDate date) {
        super.newEntry(value, date);

    }
    public void setDoneandNotDone() {
        this.DoneStatus= "Done";
        this.NotDoneStatus = "Not Done";}

    public void checkOffRL(String value) throws InvalidItemException {
        super.checkOffEntries(value,0,entry.getDueDate());
    }

}
