package ui;

import org.json.JSONException;

import java.io.IOException;

public interface Loadable {
    public void load(String s) throws IOException, JSONException;
}
