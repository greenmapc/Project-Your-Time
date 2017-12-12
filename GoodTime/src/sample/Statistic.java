package sample;

import entity.Day;
import entity.Updater;
import java.io.IOException;
import java.util.Timer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Statistic extends Application{

    private Updater updater;
    static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Statistic");
        setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws IOException {
        stage.close();
    }

    private void setPrimaryStage(Stage pStage) {
        Statistic.stage = pStage;
    }
}
