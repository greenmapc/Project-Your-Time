package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LineChartApp extends Application {
    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Your Time Graphic");
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sampleChart.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles/style.css");
        setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setPrimaryStage(Stage stage) {
        LineChartApp.stage = stage;
    }


}

