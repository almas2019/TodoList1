import org.json.JSONException;
import org.junit.jupiter.api.Test;
import ui.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;

public class LoadableTest {
    @Test
    public void testLoad() throws IOException, JSONException {
//        Loadable loadable = new RegularEntries();
        Loadable loadable = new FileManager();
//        loadable.loadArray("Test.txt");
        EntryManager list = (EntryManager) loadable; //this typecasts the loadable to EntryManager aka promotes it, talked to TA Pray about type casting
        Entry e = list.listentries.get(0);
        assertEquals(e.getName(), "fine");
        assertEquals(e.getStatus(), "Done");
        LocalDate l = LocalDate.parse("2018-10-10");
        assertEquals(e.getDueDate(), l);
        Entry ent = list.listentries.get(1);
        assertEquals(ent.getName(), "great");
        assertEquals(ent.getStatus(), "Not Done");
        assertEquals(ent.getDueDate(), l);}}


