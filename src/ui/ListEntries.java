package ui;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class ListEntries implements Loadable,Saveable {
    public ArrayList<Entry> listentries = new ArrayList<>();

//Code reference: Logging Calculator
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
            System.out.println("Days Left To do Tasks:"+entry.getDaysLeft());}}

            public void save(String s) throws IOException {
                File file = new File("/Users/almas/Desktop/CPSC 210/projectw1_team200/"+s);
                if (!file.exists()) {
                    PrintWriter writer = new PrintWriter(s,"UTF-8");
                    for (Entry e: listentries) {
                        writer.println(e.getName());
                        writer.println(e.getStatus());
                        writer.println(e.getDueDate());}
                    writer.close();}
                PrintWriter writer = new PrintWriter(s,"UTF-8");
                for (Entry e: listentries) {
                    writer.println(e.getName());
                    writer.println(e.getStatus());
                    writer.println(e.getDueDate()); }
                writer.close();}
    public void load(String s) throws IOException{
        File file = new File("/Users/almas/Desktop/CPSC 210/projectw1_team200/"+s);//this part referenced GeeksforGeeks.org
        Scanner sc = new Scanner(file,"UTF-8");
        while(sc.hasNextLine()) {
            Entry e = new Entry();
            DateFeatures date1 = new DateFeatures();
            String name = sc.nextLine();
            e.setName(name);
            String status = sc.nextLine();
            e.setStatus(status);
            String date = sc.nextLine();
            LocalDate  localDate = LocalDate.parse(date);
            e.setDueDate(localDate);
            if (e.getStatus().equals("Not Done"))
            e.setDaysLeft(date1.getDayCount(e.getDueDate()));
            else {e.setDaysLeft(0);}
            listentries.add(e);
        }



    }}