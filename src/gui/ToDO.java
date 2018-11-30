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
    //Scene Builder recommended by a TA in 210 lab (Mukund I think)
    //GUI partly created using Gluon SceneBuilder
// Learned about Gluon Scene builder as well as setting the stage and fxml DocPath from the following websites:
//https://code.makery.ch/library/javafx-tutorial/part1/
//https://docs.oracle.com/javase/8/scene-builder-2/get-started-tutorial/jfxsb-get_started.htm --> This is oracle Docs on Scenebuilder
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
