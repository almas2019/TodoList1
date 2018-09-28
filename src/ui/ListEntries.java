package ui;


import java.util.ArrayList;
import java.time.LocalDate;

public class ListEntries {
    public ArrayList<Entry> listentries = new ArrayList<>();


//REQUIRES: A non empty list,
//MODIFIES: this
//Effects: adds a new Entry to the TodoList

    public void newEntry(String value, LocalDate date)  {
        if (checkDuplicates(value))
            System.out.println("List already contains the value");
        else {
            Entry entry = new Entry();
            DateFeatures date1 = new DateFeatures();
            listentries.add(entry);
            entry.setName(value);
            entry.setStatus("Not Done");
            entry.setDueDate(date);
            entry.setDaysLeft(date1.getDayCount(entry.getDueDate()));
        }}
//Effects: returns true if the item is already in the list
public boolean checkDuplicates(String value) {
    for (Entry i : listentries) {
        if (i.getName().equals(value))
            return true;
        else return false;}
    return false;}

//REQUIRES: Non empty list
//Modifies: this
//Effects: changes a user specified entry to done
    public void takeoutEntries (String value){
        for (Entry i : listentries) {
            if (i.getName().equals(value)) {
                i.setStatus("Done");
                i.setDaysLeft(0);
                System.out.println("Entry Marked as Done!");
            }
        }}
        //Requires: Non empty list
    // Effects: returns the size of the list of entries that are done
        public int numdone() {
            Integer i = 0;

        for (Entry entry:listentries) {
            if (entry.getStatus().equals("Done")) {
                ArrayList<Entry> checkoff = new ArrayList<>();
                checkoff.add(entry);
                return (checkoff.size());
        }
        }return i;}
//Effects: Prints all entries in the list
        public void print () {
        for(Entry entry:listentries) {
            System.out.println("These are the tasks currently on your lists:");
            System.out.println("Name of Task:" + entry.getName());
            System.out.println("Status:"+ entry.getStatus());
            System.out.println("Due Date:"+entry.getDueDate());
            System.out.println("Days Left To do Tasks:"+entry.getDaysLeft());
        }



    }}