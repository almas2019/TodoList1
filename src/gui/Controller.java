package gui;

import Exceptions.InvalidItemException;
import Model.ModelFunctions;
import WebsiteParser.InspirationalQuotes;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.JSONException;
import ui.Entry;
import ui.EntryManager;
import ui.FileManager;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

public class Controller {
    public Controller () {
    }

    public TextArea dialog = new TextArea();
    @FXML
    public TextField field = new TextField();
    public Button enter = new Button();
    public MenuItem reg = new MenuItem();
    public Button quote = new Button();
    public MenuItem daily = new MenuItem();
    public MenuButton chooseList = new MenuButton();
    public MenuItem add = new MenuItem();
    public MenuItem markDoneButton = new MenuItem();
    public MenuItem remove = new MenuItem();
    public MenuItem seeAll = new MenuItem();
    public MenuItem move = new MenuItem();
    public MenuButton listOptions = new MenuButton();
    private String text = "";
    public Button enter2 = new Button();
    private InspirationalQuotes iq = new InspirationalQuotes();
    public DatePicker dp = new DatePicker();
    public MenuItem saveRL = new MenuItem();
    public MenuItem saveDL = new MenuItem();
    public MenuItem loadRL = new MenuItem();
    public MenuItem loadDL = new MenuItem();
    public MenuItem about = new MenuItem();
    private LocalDate localDate;
    @FXML
    public ListView<Entry> listView;
private ObservableList<Entry> obsList = FXCollections.observableArrayList();

ModelFunctions mf = new ModelFunctions();
    EntryManager em;
    FileManager fileManager = new FileManager();
    @FXML
    private void aboutLists(){
        redirectSystemStreams();
        System.out.println("This application was created by Almas Khan in Winter of 2018");
        System.out.println("The Daily Check List is for repeating everyday tasks like chores");
        System.out.println("The Regular To Do List is for all other tasks");
    }
private void ListSave(EntryManager em) throws IOException, JSONException {
    redirectSystemStreams();
        textBoxVisible();
        System.out.println("Please enter the name of the file");
        enter.setOnAction((ActionEvent event) -> {
            text = field.getText();
            try {
                fileManager.save(text, em);
                System.out.println(em.getListName() + " " + "Saved!");
                textBoxInVisible();
            } catch (IOException e) {
                System.out.println("IO Exception Thrown");
                e.printStackTrace();
            } catch (JSONException e) {
                System.out.println("JSON Exception Thrown");
                e.printStackTrace();
            }
        });

    }
    public void saveDailyList() throws IOException, JSONException {
    ListSave(mf.dailyChecklist);
    }
    public void saveRegularList() throws IOException, JSONException {
        ListSave(mf.regularEntries);
    }
    private void ListLoad(EntryManager em) throws IOException, JSONException {
        redirectSystemStreams();
        textBoxVisible();
        System.out.println("Please enter the name of the file with the list you want to loadArray");
        ;
        enter.setOnAction((ActionEvent event) -> {
            text = field.getText();
                fileManager.parse(text, em);
                textBoxInVisible();
            System.out.println("These are all the items on this List");
                setListView(em);

            });
    }
    public void loadDailyList() throws IOException, JSONException {
    ListLoad(mf.dailyChecklist);
    }
    public void loadRegularList()throws IOException, JSONException {
        ListLoad(mf.regularEntries);
    }

private String DAILY_CHECKLIST_NAME = mf.dailyChecklist.getListName();
private String REGULAR_LIST_NAME = mf.regularEntries.getListName();
    private void chooseList(String name, EntryManager manager) {
        redirectSystemStreams();
        System.out.println("Welcome to the" + " "+ name);
        System.out.println("Please Select an Option");
        em = manager;
        chooseList.setVisible(false);
        listOptions.setVisible(true);
        mf.sizeofLists(em);
        System.out.println("These are the items that are currently"+" "+em.getNotDoneStatus()+" on your List");
        setListView(em.createListonStatus(em.getNotDoneStatus()));
    }
    public void chooseRegList() {
        chooseList(REGULAR_LIST_NAME, mf.regularEntries);
    }
    public void chooseDailyList() {
        chooseList(mf.dailyChecklist.getListName(), mf.dailyChecklist);

    }
public void showAllItems(){
        setListView(em.listentries);
    listOptions.setVisible(false);
    chooseList.setVisible(true);}
@FXML
public void addInspiration() throws IOException, JSONException {
        redirectSystemStreams();
        iq.inspiration();
}


    public void setText(String t) {
this.text = t;
    }

    public void textBoxVisible() {
        field.setVisible(true);
        enter.setVisible(true);
    }
    public void textBoxInVisible() {
        field.setVisible(false);
        enter.setVisible(false);
    }


private void addtoDailyList() {
    listOptions.setVisible(false);
    enter.setOnAction((ActionEvent event) -> {
        System.out.println("Item Added");
        mf.dailyChecklist.newEntry(field.getText());
        textBoxInVisible();
        field.clear();
        chooseList.setVisible(true);
     notDoneListView();
    });
}

private void setListView(EntryManager em){
    obsList = FXCollections.observableArrayList(em.listentries);
    listView.toString();
    listView.setItems(obsList);
}

    @FXML
private void setListView(List<Entry> e){
//           obsList = FXCollections.observableArrayList(em.listentries);
        obsList = FXCollections.observableArrayList(e);
        listView.toString();
       listView.setItems(obsList);}

private String getSelectedItemName() {
 return (listView.getSelectionModel().getSelectedItem().getName());
    }


    private void addtoRegularEntries() {
        listOptions.setVisible(false);
            enter.setOnAction((ActionEvent event) -> {

                    System.out.println("Now Please Select the Date it's due");
                    setText(field.getText());
                    textBoxInVisible();
                    dp.setVisible(true);
                    field.clear();
                    enter2.setVisible(true);
                    enter2.setOnAction((ActionEvent e) -> {
                                localDate = dp.getValue();
                                mf.regularEntries.newEntry(text, localDate);
                                chooseList.setVisible(true);
                                dp.setVisible(false);
                                dp.setValue(null);
                        System.out.println("Item Added");
                        enter2.setVisible(false);
                       notDoneListView();
                            });
                    });


    }
    private void notDoneListView(){
        System.out.println("The number of tasks not done"+em.createListonStatus(em.getNotDoneStatus()).size());
        System.out.println("These are the tasks you are currently"+em.getNotDoneStatus());
        setListView(em.createListonStatus(em.getNotDoneStatus()));
    }
    public void addItems() {
        System.out.println("Please enter the name of the item");
        textBoxVisible();
        if (em.getListName().equals(DAILY_CHECKLIST_NAME)) {
           addtoDailyList();
        } else if (em.getListName().equals(REGULAR_LIST_NAME)) {
            addtoRegularEntries();



        }
    }
    public void removeItems() {
        listOptions.setVisible(false);
        if(!checkIfEmpty()) {
            System.out.println("Please select the item you wish to remove and press enter");
            enter.setVisible(true);
            setListView(em.listentries);
            enter.setOnAction((ActionEvent event) -> {
                em.listentries.remove(listView.getSelectionModel().getSelectedItem());
                listView.refresh();
                System.out.println("Item Removed!");
                mf.sizeofLists(em);
                enter.setVisible(false);
                chooseList.setVisible(true);
                setListView(em.listentries);
            });
        }
    }
private boolean checkIfEmpty(){
    if (em.listentries.isEmpty()) {
        System.out.println("There are no items on this List");
        chooseList.setVisible(true);
        listOptions.setVisible(false);
        return true;
    }
    return false;
}


    public void markDone(){
        if (!checkIfEmpty()) {
            System.out.println("Please select the item in the list below that is done and press enter");
            enter.setVisible(true);
            listOptions.setVisible(false);
            enter.setOnAction((ActionEvent event) -> {
                try {
                    if (em.getListName().equals(DAILY_CHECKLIST_NAME)) {
                        mf.dailyChecklist.markDoneDL(getSelectedItemName());
                       ListViewnotDone();
                    } else if (em.getListName().equals(REGULAR_LIST_NAME)) {
                        mf.regularEntries.markDoneRL(getSelectedItemName());
                        ListViewnotDone();
                    }
                } catch (InvalidItemException e) {
                    System.out.println(e.getMessage());
                }
                enter.setVisible(false);
                chooseList.setVisible(true);
                listOptions.setVisible(false);
                listView.refresh();
            });
        }
    }
    private void ListViewnotDone(){
        System.out.println("These are the items that are"+" "+em.getDoneStatus());
        setListView(em.createListonStatus(em.getDoneStatus()));
        listView.refresh();
    }
    public void moveItems() {
        if (!checkIfEmpty()) {
            System.out.println("What would you like to move?");
            listOptions.setVisible(false);
           enter.setVisible(true);
            enter.setOnAction((ActionEvent event) -> {
                try {
                    mf.moveEntry(getSelectedItemName());
                    System.out.println("Item Moved!");
                } catch (InvalidItemException e) {
                    System.out.println(e.getMessage());
                }
                textBoxInVisible();
                field.clear();
                chooseList.setVisible(true);
                setListView(em.listentries);
                listView.refresh();

            });
        }
    }
    private void updateTextArea(final String text) {
        Platform.runLater(() -> dialog.appendText(text));
    }

    //Code from Hung Hyun CodeSmart Blog
    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }
}

