package ui;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.time.LocalDate;


public class FileManager implements Saveable, Loadable {
    private String DAILY_CHECKLIST_NAME = "Daily CheckList";
    private String REGULAR_LIST_NAME = "Regular ToDo List";
    private DateFeatures df = new DateFeatures();


    //code reference for save from Crunchify JSON writer tutorial and PrintWriter 210 Repository
    public void save(String s, EntryManager em) throws IOException, JSONException {
        JSONArray array = new JSONArray();
        array.put(em.listName);
        for (Entry e : em.listentries) {
            JSONObject obj = new JSONObject();
            obj.put("Entry Name", e.getName());
            obj.put("Status", e.getStatus());
            obj.put("Due Date", e.getDueDate());
            obj.put("Date Done", e.getDateDone());
            array.put(obj);
        }
        PrintWriter writer = new PrintWriter(s+".json", "UTF-8");
        writer.println(array.toString());
        writer.close();
    }

    //Code Reference from sample JSON Parser file from 210 git hub repository
    public void parse(String s, EntryManager em) {
        try {
            InputStream is = new FileInputStream(s+".json");
            String jsonData =  readSource(is);
            loadArray(jsonData,em);
            System.out.println(em.getListName()+" "+"Loaded!");
        } catch (IOException e) {
            System.out.println("Error reading file...");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error parsing JSON data");
            e.printStackTrace();
        }

    }
    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }

    public void loadArray(String jsondata, EntryManager em) throws JSONException {
        JSONArray aTodoList = new JSONArray(jsondata);
        if (aTodoList.get(0).equals(DAILY_CHECKLIST_NAME)) {
            em = (DailyChecklist) em;
        } else if (aTodoList.get(0).equals(REGULAR_LIST_NAME)) {
            em = (RegularEntries) em;
        }
        parseEntry(aTodoList,em);
    }

    private void parseEntry(JSONArray array,EntryManager em) throws JSONException {
        for (int index = 1; index < array.length(); index++) {
            Entry e = new Entry();
            JSONObject entryObject = array.getJSONObject(index);
            String name = entryObject.getString("Entry Name");
            String status = entryObject.getString("Status");
            LocalDate dueDate =LocalDate.parse(entryObject.getString("Due Date"));
            e.setName(name);
            e.setStatus(status);
            e.setDueDate(dueDate);
            if (status.equals(em.getDoneStatus())){
            LocalDate dateUpdated= LocalDate.parse(entryObject.getString("Date Done"));
            e.setDateDone(dateUpdated);
        }
        DLReset(e,em);
            e.setDaysLeft(df.getDayCount(e.getDueDate()));
            addAfterParse(e,em);
    }
    }
    private void addAfterParse(Entry e, EntryManager em){
        if (!(em.checkDuplicates(e.getName()))){
            em.listentries.add(e);
            e.setEntryManager(em);
        }
        }

private void DLReset(Entry e, EntryManager dl) {
        if (dl.getListName().equals(DAILY_CHECKLIST_NAME)) {
            String dt = e.getDueDate().toString();
            String tommorow = df.tomorrow.toString();
            if (e.getStatus().equals(dl.getDoneStatus()) && !(dt.equals(tommorow))) {
                e.setStatus(dl.getNotDoneStatus());
                e.setDueDate(df.today);
            }
            e.setDueDate(df.today);
        }
}
}


