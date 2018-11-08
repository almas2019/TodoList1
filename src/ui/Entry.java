package ui;


import java.time.LocalDate;
import java.util.Objects;

public class Entry {
    private String name;
    private LocalDate dueDate;
    private long daysLeft;
    private String status;

    public EntryManager getEntryManager() {
        return entryManager;
    }

    private EntryManager entryManager;

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(long daysLeft) {
        this.daysLeft = daysLeft;
    }


    public void setEntryManager(EntryManager e) {
        if (!e.equals(entryManager)) {
            if (entryManager != null) {
                entryManager.listentries.remove(this);
            }
            this.entryManager = e;
            if (e instanceof DailyChecklist) {
                DailyChecklist dl = (DailyChecklist) e;
                dl.newEntry(name);
            } else {
                RegularEntries r = (RegularEntries) e;
                r.newEntry(name, dueDate);
            }
        }
    }
}



