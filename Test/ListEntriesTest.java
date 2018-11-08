import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//public class ListEntriesTest
//
//
////private EntryManager ent = new RegularEntries();
////private LocalDate localdate = LocalDate.now();
////private Entry entry =new Entry();
////private ArrayList<Entry> listentries = new ArrayList<>();
////
////@Test
////public void testAddingoneEntry () {
////    ent.newEntry("fun",localdate);
////}
////@Test
////public void testAddingmultipleEntries() {
////    ent.newEntry("fair",localdate);
////    ent.newEntry("fair2",localdate);
////}
////@Test
////public void testDuplicates () {
////    ent.newEntry("fair",localdate);
////    assertTrue(ent.checkDuplicates("fair"));
////    assertFalse(ent.checkDuplicates("fly"));}
////@Test
////public void testTakeout() {
////    Entry entry1 = new Entry();
////    entry1.setName("fair");
////    entry1.setStatus("Done");
////    entry1.setDaysLeft(0);
////    entry1.setDueDate(localdate);
////    listentries.add(entry1);
////    ent.newEntry("fair",localdate);
////   ent.takeoutEntries("fair");
////   assertEquals(listentries.get(0).getName(),ent.listentries.get(0).getName());
////    assertEquals(listentries.get(0).getStatus(), ent.listentries.get(0).getStatus());
////    assertEquals(ent.listentries.get(0).getDaysLeft(), 0);
////    }
////@Test
////    public void testnumdone() {
////    ent.newEntry("fair",localdate);
////    ent.takeoutEntries("fair");
////    ent.takeoutEntries("talk");
////    assertEquals(1,ent.numdone());
////}
////}
////
