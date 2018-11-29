package ui;

import Model.ModelFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager implements Saveable, Loadable {
    private String DAILY_CHECKLIST_NAME = "Daily CheckList";
    private String REGULAR_LIST_NAME = "Regular ToDo List";

    public void modelSave(String choice, String fileName, EntryManager em) throws IOException, JSONException {
        if (choice.equals("A")) {
            save(fileName + ".txt", em);
        } else if (choice.equals("B")) {
            save(fileName + ".txt", em);
        }
    }
//    public void save(String s) {
//
//    }

    public void modelLoad(String choice, String loadName, EntryManager em) throws IOException, JSONException, ParseException {
        if (choice.equals("B")) {
            load(loadName + ".txt", em);
            System.out.println("ToDo List Loaded");
        } else if (choice.equals("A")) {
            load(loadName + ".txt", em);
            System.out.println("Daily Checklist Loaded");
        }
    }

    //code reference for save from FileReaderWriter file from 210 repository
    public void save(String s, EntryManager em) throws IOException, JSONException {
        JSONArray array = new JSONArray();
        array.put(em.listName);
        for (Entry e : em.listentries) {
            JSONObject obj = new JSONObject();
            obj.put("Entry Name", e.getName());
            obj.put("Status", e.getStatus());
            obj.put("Due Date", e.getDueDate());
            obj.put("Date Done", e.getDateDone());
//            obj.put("Type of Entry Manager", e.getEntryManager());
            array.put(obj);
        }
        PrintWriter writer = new PrintWriter(s, "UTF-8");
        writer.println(array.toString());
//        for (Entry e :em.listentries {
//            writer.println(e.getName() + "," + e.getStatus() + "," + e.getDueDate() + ",");
//        }
        writer.close();
    }

    public void load(String s, EntryManager em) throws IOException, JSONException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("s"));
        if (a.get(0).equals(DAILY_CHECKLIST_NAME)) {
            em = (DailyChecklist) em;
        } else if (a.get(0).equals(REGULAR_LIST_NAME)) {
            em = (RegularEntries) em;
        }

    }

    private void parseEntry(JSONArray array) throws JSONException {
        for (int index = 1; index < array.length(); index++) {
            JSONObject entryObject = array.getJSONObject(index);
            String name = entryObject.getString("Entry Name");

        }
    }
}




//    public static ArrayList<String> splitOnComma(String line) {
//        String[] splits = line.split(",");
//        return new ArrayList<>(Arrays.asList(splits));
//    }
//}
