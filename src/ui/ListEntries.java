package ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ListEntries implements Loadable, Saveable {
    public ArrayList<Entry> listentries = new ArrayList<>();

    protected void newEntry(String value, LocalDate date, String s) {
        if (!(checkDuplicates(value))) {
            Entry entry = new Entry();
            DateFeatures date1 = new DateFeatures();
            listentries.add(entry);
            entry.setName(value);
            entry.setStatus(s);
            entry.setDueDate(date);
            entry.setDaysLeft(date1.getDayCount(entry.getDueDate()));
            entry.setListEntries(this);

        }}

    //Effects: returns true if the item is already in the list
    protected boolean checkDuplicates(String value) {
        for (Entry i : listentries) {
            if (i.getName().equals(value))
                return true;
            else return false;
        }
        return false;
    }

    //REQUIRES: Non empty list
    //Modifies: this
    //Effects: changes a user specified entry to done
    public abstract void takeoutEntries(String value);

    //Requires: Non empty list
    // Effects: returns the size of the list of entries that are done
    protected int numdone(String s) {
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
    protected void print() {
        for (Entry entry : listentries) {
            System.out.println("These are the tasks currently on your lists:");
            System.out.println("Name of Task:" + entry.getName());
            System.out.println("Status:" + entry.getStatus());
            System.out.println("Due Date:" + entry.getDueDate());
            System.out.println("Days Left To do Tasks:" + entry.getDaysLeft());
        }
    }

    protected void printDone(String s) {
        for (Entry entry : listentries) {
            if (entry.getStatus().equals(s)) {
                System.out.println("Name of Task:" + entry.getName());
                System.out.println("Status:" + entry.getStatus());
                System.out.println("Due Date:" + entry.getDueDate());
                System.out.println("Days Left To do Tasks:" + entry.getDaysLeft());
            }
        }
    }

    //Eff
    //code reference for save from FileReaderWriter file from 210 repository
    public void save(String s) throws IOException {
        PrintWriter writer = new PrintWriter(s, "UTF-8");
        for (Entry e : listentries) {
            writer.println(e.getName() + "," + e.getStatus() + "," + e.getDueDate() + ",");
        }
        writer.close();
    }

    public void load(String s) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(s));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnComma(line);
            Entry e = new Entry();
            e.setName(partsOfLine.get(0));
            e.setStatus(partsOfLine.get(1));
            String date = partsOfLine.get(2);
            LocalDate localDate = LocalDate.parse(date);
            LocalDate today = LocalDate.now();
            if (!localDate.equals(today) && (e.getStatus().equals("In Progress"))) {
                e.setDueDate(today);
            }
            if (localDate.equals(today) && e.getStatus().equals("Done for Today")) {
                e.setDueDate(today);
                e.setDaysLeft(0);
                e.setStatus("In Progress");
            } else {
                e.setDueDate(localDate);
            }
            DateFeatures date1 = new DateFeatures();
            if (e.getStatus().equals("Not Done"))
                e.setDaysLeft(date1.getDayCount(e.getDueDate()));
            else {
                e.setDaysLeft(0);
            }
            listentries.add(e);
        }
    }


    public static ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }

}

