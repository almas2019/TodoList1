import Exceptions.InvalidItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Entries;
import ui.ModelFunctions;

import static org.junit.jupiter.api.Assertions.*;

public class InvalidItemsTest {
    ModelFunctions mf;
    @BeforeEach
    public void load() {
        mf = new ModelFunctions();
    }
    @Test
    public void removeInvalidItemRegularEntries() {
        mf.enter("Radio","2018-02-02");
        try {
            mf.remove("B","Great");
        } catch (InvalidItemException e) {
            System.out.println("Item not There!!!!");
        }
    }
@Test
public void removeValidItemRegularEntries() {
    mf.enter("Radio","2018-02-02");
    try {
        mf.remove("B","Radio");
    } catch (InvalidItemException e) {
        fail("Item not There!!!!");
    }}
    @Test
    public void removeInvalidItemDailyChecklist() {
        mf.enter("Radio");
        try {
            mf.remove("A","Great");
        } catch (InvalidItemException e) {
            System.out.println("Item not There!!!!");
        }
    }
    @Test
    public void removeValidDailyCheckList() {
        mf.enter("Radio");
        try {
            mf.remove("A","Radio");
        } catch (InvalidItemException e) {
            fail("Item not There!!!!");
        }
}


}
