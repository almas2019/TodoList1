package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ToDO extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //GUI partly created using Gluon SceneBuilder
    @Override
    public void start(Stage stage) throws IOException {
FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "/Users/almas/Desktop/CPSC 210/projectw1_team200/src/gui/Todo.fxml" ;
      FileInputStream fileInputStream = new FileInputStream(fxmlDocPath);
        AnchorPane wow = (AnchorPane) loader.load(fileInputStream);
        Scene scene = new Scene(wow);
        stage.setScene(scene);
        stage.setTitle("To Do List");
        stage.show();


    }


}
