import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.DateFeatures;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateFeaturesTest {
    DateFeatures date = new DateFeatures();
    String date2 = "2018-10-27";
LocalDate localDate = LocalDate.parse(date2);

@Test
public void testDaysBetween() {
assertEquals(date.getDayCount(localDate), 23);
}}
