package Application;

import entity.Updater;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableApp extends Application{
    
    private Updater updater;
    static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sampleTable.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("TableApp");
        setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

        
    private void setPrimaryStage(Stage pStage) {
        TableApp.stage = pStage;
    }
}
