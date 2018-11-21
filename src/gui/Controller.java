package gui;

import Exceptions.InvalidItemException;
import Exceptions.InvalidListException;
import Model.ModelFunctions;
import WebsiteParser.InspirationalQuotes;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import org.json.JSONException;
import ui.Entry;
import ui.EntryManager;
import ui.FileManager;
import ui.RegularEntries;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class Controller {
    public Controller() {
    }

    public TextArea dialog = new TextArea();
    public TextField field = new TextField();
    public Button enter = new Button();
    public MenuItem reg = new MenuItem();


    public void chooseRegList() {
       redirectSystemStreams();
        System.out.println("Welcome to the Regular List");
        System.out.println("Please Select an Option");


    }

    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                dialog.appendText(text);
            }
        });
    }

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
