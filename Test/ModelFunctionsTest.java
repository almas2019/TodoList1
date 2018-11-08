import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Exceptions.InvalidItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.*;

public class ModelFunctionsTest {
    Entry entry;
    ModelFunctions mf;
 DailyChecklist dailyChecklist;
    RegularEntries regularEntries;
    @BeforeEach
    public void newEntry(){
        entry = new Entry();
        mf = new ModelFunctions();
        dailyChecklist = new DailyChecklist();
        regularEntries = new RegularEntries();
        }
    @Test
    public void moveListTest() throws InvalidItemException {
    mf.enter("Hello", "2018-02-02");
    mf.moveEntry("Hello");
    mf.moveEntry("Hello");
    mf.remove();
    mf.sizeofList("A");
    mf.sizeofList("B");
    mf.printItems("A");
    mf.printItems("B");
    }

}
