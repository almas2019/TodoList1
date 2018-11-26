package gui;

import Model.ModelFunctions;
import WebsiteParser.InspirationalQuotes;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.JSONException;
import ui.EntryManager;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private InspirationalQuotes iq = new InspirationalQuotes();
    public DatePicker dp = new DatePicker();
    private LocalDate localDate;

    ModelFunctions mf = new ModelFunctions();
    //        public void enterPressed(ActionEvent e) {
//            field.getText();
//            // enter has been pressed in the text field.
//            // take whatever action has been required here.
//        }
//    }
    EntryManager em;
    private String DAILY_CHECKLIST_NAME = "Daily CheckList";
    private String REGULAR_LIST_NAME = "Regular ToDo List";

    public void chooseRegList() {
        chooseList(mf.regularEntries.getListName(), mf.regularEntries);
    }
    //ActionEvent e)
public void getFieldText() {
    enter.setOnAction((ActionEvent event) ->
    new Thread(() -> {
      setText(field.getText());
    }).start());
}
public void showAllItems(){
        if (em.getListName().equals(DAILY_CHECKLIST_NAME)){
            mf.dailyChecklist.print();
    }
    if (em.getListName().equals(REGULAR_LIST_NAME)) {
            mf.regularEntries.print();
    }
}

//public void getFieldText() {
//    enter.setOnAction((ActionEvent event) ->
//            new Thread(() -> {
//                text = field.getText();
//                System.out.println(text);
//            }).start());
//}

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


public void addtoDailyList() {
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
    public void addtoRegularEntries() {
        editListsButton.setVisible(false);
        enter.setOnAction((ActionEvent event) -> {
            System.out.println("Now Please Select the Date it's due");
            setText(field.getText());
            textBoxInVisible();
            dp.setVisible(true);
            field.clear();
        });
        dp.setOnAction((ActionEvent e) -> {
            localDate = dp.getValue();
            mf.regularEntries.newEntry(text, localDate);
            dp.setValue(null);
            listOption.setVisible(true);
            dp.setVisible(false);
        });
    }
//public void
    public void addItems() {
        System.out.println("Please enter the name of the item");
        textBoxVisible();
        if (em.getListName().equals(DAILY_CHECKLIST_NAME)) {
           addtoDailyList();
               }

        else if (em.getListName().equals(REGULAR_LIST_NAME)) {
            addtoRegularEntries();
            System.out.println("Item Added");
        }




//            setText(getFieldText());
//              System.out.println(text);
                // up to here was working but now its not

        }







//            enter.setOnAction(event ->{
//                    text = field.getText();});
//            System.out.println(text);
//            enter.setOnAction(this::textSet);
//                System.out.println(text);

//                String name = text;
//                System.out.println("Please enter the date of the task in DD/MM/YYY");
//              enter.setOnAction(event ->{
//                    text = field.getText();});
//                String date = getText();
//                mf.enter(name, date);





    public void chooseList(String name, EntryManager manager) {
        redirectSystemStreams();
        System.out.println("Welcome to the" + name);
        System.out.println("Please Select an Option");
        em = manager;
        listOption.setVisible(false);
        editListsButton.setVisible(true);
    }

    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                dialog.appendText(text);
            }
        });
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
