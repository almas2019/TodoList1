import org.junit.jupiter.api.Test;
import ui.Entry;
import ui.ListEntries;
import ui.Loadable;
import ui.Saveable;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class SaveableTest {


private LocalDate localdate = LocalDate.now();
@Test
public void testSave() throws IOException {
    ListEntries ent = new ListEntries();
    ent.newEntry("fair",localdate);
    ent.newEntry("fair2",localdate);
    ent.save("Todo.txt");
    File file = new File("/Users/almas/Desktop/CPSC 210/projectw1_team200/Todo.txt"); //code reference GeeksforGeeks.org
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()){
        System.out.println(scanner.nextLine());}
}
}
