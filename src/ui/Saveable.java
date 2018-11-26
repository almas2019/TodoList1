package ui;

import org.json.JSONException;

import java.io.IOException;

public interface Saveable {
    public void save(String s) throws IOException, JSONException;
}
