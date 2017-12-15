package Application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sampleApp.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        scene.getStylesheets().add("styles/style.css");
        primaryStage.setTitle("Your Time");
        primaryStage.getIcons().add(new Image("/img/Icon.jpg"));
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return stage;
    }

    private void setPrimaryStage(Stage pStage) {
        Main.stage = pStage;
    }

    @Override
    public void stop() throws IOException {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

