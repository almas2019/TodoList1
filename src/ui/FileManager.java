package ui;

import Model.ModelFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager implements Saveable, Loadable {
    public void modelSave(String choice, String fileName, EntryManager em) throws IOException, JSONException {
        if (choice.equals("A")) {
         save(fileName + ".txt", em);
        } else if (choice.equals("B")) {
            save(fileName + ".txt",em);
        }
    }
//    public void save(String s) {
//
//    }

    public void modelLoad(String choice, String loadName) throws IOException {
        if (choice.equals("B")) {
           load(loadName + ".txt");
            System.out.println("ToDo List Loaded");
        } else if (choice.equals("A")) {
            load(loadName + ".txt");
            System.out.println("Daily Checklist Loaded");
        }
    }
    //code reference for save from FileReaderWriter file from 210 repository
    public void save(String s,EntryManager em) throws IOException, JSONException {
        JSONArray array = new JSONArray();
        array.put(em.listName);
        for (Entry e:em.listentries){
            JSONObject obj = new JSONObject();
            obj.put("Entry Name",e.getName());
            obj.put("Status",e.getStatus());
            obj.put("Due Date", e.getDueDate());
            obj.put("Date Done", e.getDateDone());
//            obj.put("Type of Entry Manager", e.getEntryManager());
            array.put(obj);
        }
        PrintWriter writer = new PrintWriter(s, "UTF-8");
       writer.println (array.toString());
//        for (Entry e :em.listentries {
//            writer.println(e.getName() + "," + e.getStatus() + "," + e.getDueDate() + ",");
//        }
        writer.close();
    }

    public void load(String s) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(s));
        for (String line : lines) {
//            ArrayList<String> partsOfLine = splitOnComma(line);
            Entry e = new Entry();
//            e.setName(partsOfLine.get(0));
//            e.setStatus(partsOfLine.get(1));
//            String date = partsOfLine.get(2);
            JSONArray array = new JSONArray();
//            array.getJSONObject(0)
//            LocalDate localDate = LocalDate.parse(date);
//            LocalDate today = LocalDate.now();
//            if (!localDate.equals(today) && (e.getStatus().equals("In Progress"))) {
//                e.setDueDate(today);
//            }
//            if (localDate.equals(today) && e.getStatus().equals("Done for Today")) {
//                e.setDueDate(today);
//                e.setDaysLeft(0);
//                e.setStatus("In Progress");
//            } else {
//                e.setDueDate(localDate);
//            }
            DateFeatures date1 = new DateFeatures();
            if (e.getStatus().equals("Not Done"))
                e.setDaysLeft(date1.getDayCount(e.getDueDate()));
            else {
                e.setDaysLeft(0);
            }
            e.getEntryManager().listentries.add(e);
        }
    }


    public static ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
