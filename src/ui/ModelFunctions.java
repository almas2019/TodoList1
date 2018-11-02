package ui;

import Exceptions.InvalidItemException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class ModelFunctions {
    DailyChecklist dailyChecklist = new DailyChecklist();
    RegularListEntries regularEntries = new RegularListEntries();
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

    //REQUIRES: non empty list, task already in listofentries
    //MODIFIES: this
//EFFECTS: Removes the value
    public void remove(String choice, String name) throws InvalidItemException {
        System.out.println("What task are you done?");
        if (choice.equals("B")) {
            regularEntries.print();
            for (Entry e : regularEntries.listentries) {
                if (e.getName().equals(name)) {
                    regularEntries.takeoutEntries(name);
                    System.out.println("These are the tasks that are done:");
                    regularEntries.numdone();
                    regularEntries.printDone();
                    return;
                }
            }
            throw new InvalidItemException("To Do List Does Not Contain Item");
        }


        if (choice.equals("A")) {
            dailyChecklist.print();
            for (Entry e : dailyChecklist.listentries) {
                if (e.getName().equals(name)) {
                    dailyChecklist.takeoutEntries(name);
                    System.out.println("These are the tasks that you no longer need to worry about for today");
                    dailyChecklist.printDone();
                    dailyChecklist.numdone();
                    return;
                }
            }

            throw new InvalidItemException("To Do List Does Not Contain Item");
        }
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

    public void modelSave(String choice, String fileName) throws IOException {
        if (choice.equals("B")) {
            regularEntries.save(fileName + ".txt");
        } else if (choice.equals("A")) {
            dailyChecklist.save(fileName + ".txt");
        }
    }

    public void modelLoad(String choice, String loadName) throws IOException {
        if (choice.equals("B")) {
            regularEntries.load(loadName + ".txt");
            System.out.println("ToDo List Loaded");
        } else if (choice.equals("A")) {
            dailyChecklist.load(loadName + ".txt");
            System.out.println("Daily Checklist Loaded");
        }
    }

    public boolean onDailyList(String name) {
     for (Entry e : dailyChecklist.listentries) {
         if (e.getName().equals(name));
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
    public void moveEntry(String name) {
        if (onDailyList(name)){
           e.setListEntries(regularEntries);
        }
        if (onRegularEntries(name)){
           e.setListEntries(dailyChecklist);
        }

    }
}









