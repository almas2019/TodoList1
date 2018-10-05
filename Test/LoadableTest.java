import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Entry;
import ui.ListEntries;
import ui.Loadable;
import ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class LoadableTest {
    @Test
    public void testLoad() throws IOException {
        Loadable loadable = new ListEntries();
        loadable.load("Test.txt");
        ListEntries list = (ListEntries) loadable; //this typecasts the loadable to ListEntries aka promotes it, talked to TA Pray about type casting
        Entry e = list.listentries.get(0);
        assertEquals(e.getName(), "fine");
        assertEquals(e.getStatus(), "Done");
        LocalDate l = LocalDate.parse("2018-10-10");
        assertEquals(e.getDueDate(), l);
        Entry ent = list.listentries.get(1);
        assertEquals(ent.getName(), "great");
        assertEquals(ent.getStatus(), "Not Done");
        assertEquals(ent.getDueDate(), l);}}


