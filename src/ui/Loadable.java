package ui;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface Loadable {
    public void load(String s,EntryManager em) throws IOException, JSONException, ParseException;
}
