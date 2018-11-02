package ui;


import java.time.LocalDate;

public class RegularListEntries extends ListEntries {
public void newEntry(String value, LocalDate date)  {
    super.newEntry(value,date,"Not Done");

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