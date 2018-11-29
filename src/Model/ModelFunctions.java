package Model;

import Exceptions.InvalidItemException;
import ui.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;



public class ModelFunctions {
    public DailyChecklist dailyChecklist = new DailyChecklist();
    public RegularEntries regularEntries = new RegularEntries();
    public Entry e = new Entry();

    //REQUIRES: Non empty list, date must be in format YYYY-MM-DD
//MODIFIES: this
//EFFECTS: Takes the user input and adds it to the TODOList
    public void enter(String name, String date) throws DateTimeParseException {
        LocalDate localDate = LocalDate.parse(date); //this line is referenced from mkyong.com;
        regularEntries.newEntry(name, localDate);
    }


    public void enter(String name) {
        dailyChecklist.newEntry(name);
    }

    //EFFECTS: prints the list of entries
    public void printItems(String choice) {
        if (choice.equals("B")) {
            regularEntries.print();
        }
        if (choice.equals("A")) {
            dailyChecklist.print();
        }
    }

    public void sizeofList(String choice) {
        if (choice.equals("A")) {
            System.out.println("These are the number of items on your Daily CheckList");
            System.out.println(dailyChecklist.listentries.size());
        } else if (choice.equals("B")) {
            System.out.println("These are the number of items on your Normal ToDo List");
            System.out.println(regularEntries.listentries.size());
        }
    }
public void sizeofLists(EntryManager em){
    if (em.getListName().equals(dailyChecklist.getListName())) {
        System.out.println("These are the number of items on your Daily CheckList");
        System.out.println(dailyChecklist.listentries.size());
    } else if (em.getListName().equals(regularEntries.getListName())) {
        System.out.println("These are the number of items on your Normal ToDo List");
        System.out.println(regularEntries.listentries.size());
    }
}


    public boolean onDailyList(String name) {
        for (Entry e : dailyChecklist.listentries) {
            if (e.getName().equals(name)) ;
            this.e = e;
            return true;
        }
        return false;
    }

    public boolean onRegularEntries(String name) {
        for (Entry e : regularEntries.listentries) {
            if (e.getName().equals(name))
                this.e = e;
            return true;
        }
        return false;
    }

    public void moveEntry(String name) throws InvalidItemException {
        if (onDailyList(name)) {
            e.setEntryManager(regularEntries);
            if (e.getStatus().equals(dailyChecklist.getDoneStatus())) {
                regularEntries.checkOffRL(name);
            }
        } else if (onRegularEntries(name)) {
            if (e.getStatus().equals(regularEntries.getDoneStatus())) {
                dailyChecklist.checkOffDL(name);
            } else {
                DateFeatures df = new DateFeatures();
                e.setDueDate(df.today);
                e.setEntryManager(dailyChecklist);
            }
        }
    }
}












