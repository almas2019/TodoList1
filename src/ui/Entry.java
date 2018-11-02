package ui;


import java.time.LocalDate;

public class Entry {
    private String name;
    private LocalDate dueDate;
    private long daysLeft;
    private String status;

    public ListEntries getListEntries() {
        return listEntries;
    }

    private ListEntries listEntries;

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


    public void setListEntries(ListEntries e) {
        if (!e.equals(listEntries)) {
            if (listEntries != null) {
                listEntries.listentries.remove(this);
            }
            this.listEntries = e;
            if (e instanceof DailyChecklist) {
                DailyChecklist dl = (DailyChecklist) e;
                dl.newEntry(name);
            } else {
                RegularListEntries r = (RegularListEntries) e;
                r.newEntry(name, dueDate);
            }
        }
    }
}



