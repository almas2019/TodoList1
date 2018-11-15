package Model;

import java.time.LocalDate;

public class StatusUpdater {
    private String name;
    private String nameofList;
    private LocalDate dateUpdated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameofList() {
        return nameofList;
    }

    public void setNameofList(String nameofList) {
        this.nameofList = nameofList;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public StatusUpdater(String listName,String name, LocalDate dateUpdated){
    setName(name);
    setNameofList(listName);
    setDateUpdated(dateUpdated);
    }

}

