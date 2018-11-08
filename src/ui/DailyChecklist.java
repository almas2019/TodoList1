package ui;


import java.time.LocalDate;

public class DailyChecklist extends EntryManager {
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
        i.setDueDate(tomorrow);
        entry.setEntryManager(this);}}}
            public void numdone(){
    super.numdone("Done for Today");}
    public void printDone() {
    super.printDone("Done for Today");}
}




