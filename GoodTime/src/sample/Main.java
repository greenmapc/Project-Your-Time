package sample;

import entity.StoreOfDays;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene); 
        primaryStage.setResizable(false);
        scene.getStylesheets().add("styles/style.css");
        primaryStage.setTitle("Your Time");
        primaryStage.getIcons().add(new Image("/img/Icon.jpg"));
        primaryStage.show();
        
    }

    @Override
    public void stop() throws IOException {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

