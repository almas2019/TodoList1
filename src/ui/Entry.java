package ui;


import java.time.LocalDate;

public class Entry {
    private String name;
    private LocalDate dueDate;
    private long daysLeft;
    private String status;


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
       return daysLeft;}

    public void setDaysLeft(long daysLeft) {
       this.daysLeft = daysLeft;} }



