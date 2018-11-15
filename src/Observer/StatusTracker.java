package Observer;

import Model.StatusUpdater;
import ui.DateFeatures;


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
    public int keepNumDone(StatusUpdater statusUpdater) {
            if (statusUpdater.getNameofList().equals("Daily Checklist") && statusUpdater.getDateUpdated().equals(df.today)) {
              dclTally++;
              return dclTally;

            } else if (statusUpdater.getNameofList().equals("Regular ToDo List") && statusUpdater.getDateUpdated().equals(df.today)) {
              reTally++;
              return reTally;

            }

        return 0;
    }
}
