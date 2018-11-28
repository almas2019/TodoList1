package gui;

import Exceptions.InvalidItemException;
import Model.ModelFunctions;
import WebsiteParser.InspirationalQuotes;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.JSONException;
import ui.EntryManager;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

public class Controller {
    public Controller() {
    }

    public TextArea dialog = new TextArea();
    @FXML
    public TextField field = new TextField();
    public Button enter = new Button();
    public MenuItem reg = new MenuItem();
    public MenuItem quote = new MenuItem();
    public MenuItem daily = new MenuItem();
    public MenuButton listOption = new MenuButton();
    public MenuItem add = new MenuItem();
    public MenuItem remove = new MenuItem();
    public MenuItem seeAll = new MenuItem();
    public MenuButton editListsButton = new MenuButton();
    private String text = "";
    public Button enter2 = new Button();
    private InspirationalQuotes iq = new InspirationalQuotes();
    public DatePicker dp = new DatePicker();
    private LocalDate localDate;

    ModelFunctions mf = new ModelFunctions();
    EntryManager em;
private String DAILY_CHECKLIST_NAME = mf.dailyChecklist.getListName();
private String REGULAR_LIST_NAME = mf.regularEntries.getListName();
    public void chooseRegList() {
        chooseList(REGULAR_LIST_NAME, mf.regularEntries);
    }
public void showAllItems(){
    Platform.runLater(() ->{
        if (em.getListName().equals(DAILY_CHECKLIST_NAME)){
            mf.dailyChecklist.print();
    }
    if (em.getListName().equals(REGULAR_LIST_NAME)){
            mf.regularEntries.print();
    }
} );
}

public void addInspiration() throws IOException, JSONException {
        iq.inspiration();
}

    public void chooseDailyList() {
        chooseList(mf.dailyChecklist.getListName(), mf.dailyChecklist);

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
    editListsButton.setVisible(false);
    enter.setOnAction((ActionEvent event) -> {
        System.out.println("Item Added");
        String l;
        l = field.getText();
        mf.dailyChecklist.newEntry(l);
        textBoxInVisible();
        field.clear();
        listOption.setVisible(true);

    });
}
    private void addtoRegularEntries() {
        editListsButton.setVisible(false);
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
                                listOption.setVisible(true);
                                dp.setVisible(false);
                                dp.setValue(null);
                        System.out.println("Item Added");
                        enter2.setVisible(false);
                            });
                    });


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
    public void removeItems(){
        System.out.println("Please enter the name of the item");
        textBoxVisible();
        em.whatDone();
        enter.setOnAction((ActionEvent event) -> {
            try {
                if (em.getListName().equals(DAILY_CHECKLIST_NAME)){
                    mf.dailyChecklist.checkOffDL(field.getText());
                }
                else if (em.getListName().equals(REGULAR_LIST_NAME)){
                    mf.regularEntries.checkOffRL(field.getText());
                }
                em.taskDonePrint();
            } catch (InvalidItemException e) {
                System.out.println(e.getMessage());
            }
            textBoxInVisible();
            field.clear();
            listOption.setVisible(true);
            editListsButton.setVisible(false);
        });
    }
    
    private void chooseList(String name, EntryManager manager) {
        redirectSystemStreams();
        System.out.println("Welcome to the" + " "+ name);
        System.out.println("Please Select an Option");
        em = manager;
        listOption.setVisible(false);
        editListsButton.setVisible(true);
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

