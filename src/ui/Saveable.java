package ui;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public interface Saveable {
    public void save(String s,EntryManager em) throws IOException, JSONException;
}
