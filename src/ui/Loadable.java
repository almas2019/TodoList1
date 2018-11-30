package ui;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface Loadable {
    public void loadArray(String s, EntryManager em) throws IOException, JSONException;
}
