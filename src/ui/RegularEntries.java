package ui;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RegularEntries extends Entries {
public void newEntry(String value, LocalDate date)  {
    super.newEntry(value,date,"Not Done");
    super.print();
}
public void takeoutEntries(String value){
        for (Entry i : listentries) {
            if (i.getName().equals(value)) {
                i.setStatus("Done");
                i.setDaysLeft(0);
                System.out.println("Entry Marked as Done!");
            }
        }}
    public void numdone() {
    super.numdone("Done");
    }
    public void printDone() {
    super.printDone("Done");
    }
}