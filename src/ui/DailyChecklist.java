package ui;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DailyChecklist extends Entries {
    private LocalDate  today = LocalDate.now();
    public void newEntry(String value)  {
        super.newEntry(value,today, "In Progress");
    }
public void takeoutEntries(String value) {
    for (Entry i : listentries) {
        if (i.getName().equals(value)) {
            i.setStatus("Done for Today");
            i.setDaysLeft(1);
            LocalDate tomorrow = today.plusDays(1);
        i.setDueDate(tomorrow);}}}
            public void numdone(){
    super.numdone("Done for Today");}
    public void printDone() {
    super.printDone("Done for Today");}
}




