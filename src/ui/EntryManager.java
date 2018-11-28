package ui;

import Exceptions.InvalidItemException;
import Model.StatusUpdater;

import java.time.LocalDate;
import java.util.*;

public abstract class EntryManager extends Observable {
    public ArrayList<Entry> listentries = new ArrayList<>();
    Entry entry = new Entry();
    public String DoneStatus;
    public String NotDoneStatus;
    DateFeatures date1 = new DateFeatures();
    protected String listName;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDoneandNotDone() {
        DoneStatus="";
        NotDoneStatus="";
    }

    protected void newEntry(String value, LocalDate date) {
        if (!(checkDuplicates(value))) {
            Entry entry = new Entry();
            listentries.add(entry);
            entry.setName(value);
            entry.setStatus(NotDoneStatus);
            entry.setDueDate(date);
            entry.setDaysLeft(date1.getDayCount(entry.getDueDate()));
            this.entry =entry;
            entry.setEntryManager(this);

        }
    }
public void whatDone(){
    System.out.println("What task are you done?");
    print();
}
    public void checkOffEntries(String name, long daysLeft, LocalDate dateDue) throws InvalidItemException{
     for (Entry i : listentries) {
        if (i.getName().equals(name)) {
            i.setStatus(DoneStatus);
            i.setDateDone(date1.today);
            setChanged();
            StatusUpdater statusUpdater = new StatusUpdater(getListName(), i.getName(),i.getDateDone());
            notifyObservers(statusUpdater);
            i.setDaysLeft(daysLeft);
            i.setDueDate(dateDue);
            i.setEntryManager(this);
            return; }
        throw new InvalidItemException("To Do List Does Not Contain Item");}}
    public void taskDonePrint(){
        System.out.println("These are the tasks that are done:");
        numdone(DoneStatus);
        printDone();
    }
    //Effects: returns true if the item is already in the list
    public boolean checkDuplicates(String value) {
        for (Entry i : listentries) {
            if (i.getName().equals(value))
                return true;
        }
        return false;
    }

    //REQUIRES: Non empty list
    //Modifies: this
    //Effects: changes a user specified entry to done
//    public  void checkOffRL(String value) throws InvalidItemException {
//        System.out.println("What task are you done?");
//        print();
//        System.out.println("These are the tasks that are done:");
//        numdone(DoneStatus);
//        printDone();
//    }

    //Requires: Non empty list
    // Effects: returns the size of the list of entries that are done
    public int numdone(String s) {
        Integer i = 0;

        for (Entry entry : listentries) {
            if (entry.getStatus().equals(s)) {
                ArrayList<Entry> checkoff = new ArrayList<>();
                checkoff.add(entry);
                return (checkoff.size());
            }
        }
        return i;
    }

    //Effects: Prints all entries in the list
    public void print() {
        for (Entry entry : listentries) {
            System.out.println("These are the tasks currently on your lists:");
            System.out.println("Name of Task:" + entry.getName());
            System.out.println("Status:" + entry.getStatus());
            System.out.println("Due Date:" + entry.getDueDate());
            System.out.println("Days Left To do Tasks:" + entry.getDaysLeft());
        }
    }

    protected void printDone() {
        for (Entry entry : listentries) {
            if (entry.getStatus().equals(DoneStatus)) {
                System.out.println("Name of Task:" + entry.getName());
                System.out.println("Status:" + entry.getStatus());
                System.out.println("Due Date:" + entry.getDueDate());
                System.out.println("Date Updated" + entry.getDateDone());
                System.out.println("Days Left To do Tasks:" + entry.getDaysLeft());
            }
        }
    }



    public void addEntry(Entry e) {
        if (!(listentries.contains(e))) {
            newEntry(e.getName(),e.getDueDate());
        }

    }
    @Override
    public String toString() {
        return
//                "listentries=" + listentries +
                ", entry=" + entry.getName() +
                ", Status='" + DoneStatus + '\'' +
                ", Due Date='"+ entry.getDueDate()+
                +
                '}';
    }
}