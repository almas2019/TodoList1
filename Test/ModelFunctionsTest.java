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
    RegularListEntries regularEntries;
    @BeforeEach
    public void newEntry(){
        entry = new Entry();
        mf = new ModelFunctions();
        dailyChecklist = new DailyChecklist();
        regularEntries = new RegularListEntries();
        }
    @Test
    public void moveListTest() throws InvalidItemException {
    mf.enter("Hello");
    mf.moveEntry("Hello");
    mf.remove("A","Hello");
    mf.sizeofList("A");
    mf.sizeofList("B");
    mf.printItems("A");
    mf.printItems("B");
    }

}
