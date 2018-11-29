import Exceptions.InvalidItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListEntriesTest{


private RegularEntries reg;
private DailyChecklist dailyChecklist;
private LocalDate localdate = LocalDate.now();
private Entry entry =new Entry();
//private ArrayList<Entry> listentries = new ArrayList<>();

        @BeforeEach
        public void newEntry(){
            entry = new Entry();
            dailyChecklist = new DailyChecklist();
            reg = new RegularEntries();
            reg.setDoneandNotDone();
        }
@Test
public void testAddingoneEntry () {
    reg.newEntry("fun",localdate);
}
@Test
public void testAddingmultipleEntries() {
    reg.newEntry("fair",localdate);
    reg.newEntry("fair2",localdate);
}
@Test
public void testDuplicates () {
    reg.newEntry("fair",localdate);
    assertTrue(reg.checkDuplicates("fair"));
    assertFalse(reg.checkDuplicates("fly"));}
@Test
public void testTakeout() {
    Entry entry1 = new Entry();
    entry1.setName("fair");
    entry1.setStatus("Done");
    entry1.setDaysLeft(0);
    entry1.setDueDate(localdate);
    reg.addEntry(entry1);
    try {
        reg.checkOffRL("fair");
    } catch (InvalidItemException e) {
        System.out.println(e.getMessage());
    }
    assertEquals(reg.listentries.get(0).getName(), reg.listentries.get(0).getName());
    assertEquals(reg.listentries.get(0).getStatus(), reg.listentries.get(0).getStatus());
    assertEquals(reg.listentries.get(0).getDaysLeft(), 0);
    }
@Test
    public void testnumdone() {
    reg.newEntry("fair",localdate);
    try {
        reg.checkOffRL("fair");
    }catch (InvalidItemException e) {
        System.out.println("Failed on fair");
    }
    try {
        reg.checkOffRL("talk");
    } catch (InvalidItemException e) {
        System.out.println("Passed on Talk");
    }
    assertEquals(1,reg.numdone(reg.getDoneStatus()));
}
}

