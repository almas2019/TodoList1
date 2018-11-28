package Observer;

import Model.StatusUpdater;
import ui.DateFeatures;


import java.time.LocalDate;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class StatusTracker implements Observer {
    private int dclTally = 0;
    private int reTally= 0;
    DateFeatures df = new DateFeatures();
    @Override
    public void update(Observable o, Object arg) {
        StatusUpdater su = (StatusUpdater) arg; //Casting changing the apparent type
        //String message = (String) arg
        System.out.println("Number of Entries Checked Off for Today: "+keepNumDone(su));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusTracker that = (StatusTracker) o;
        return Objects.equals(df, that.df);
    }

    @Override
    public int hashCode() {

        return Objects.hash(df);
    }

    public int keepNumDone(StatusUpdater statusUpdater) {
       LocalDate dateUpdtd = statusUpdater.getDateUpdated();
            if (statusUpdater.getNameofList().equals("Daily CheckList") && dateUpdtd.equals(df.today)){
              dclTally++;
              return dclTally;

            } else if (statusUpdater.getNameofList().equals("Regular ToDo List") && dateUpdtd.equals(df.today)) {
              reTally++;
              return reTally;

            }

        return 0;
    }
}
