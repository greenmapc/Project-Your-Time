package sample;

import entity.Stopwatch;
import entity.Updater;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.Timer;

public class Controller {
    @FXML
    private Label labelEven, labelOdd, labelStartText;
    @FXML
    private Button button;

    private Stopwatch stopwatchEven = new Stopwatch();
    private Stopwatch stopwatchOdd = new Stopwatch();
    private int cnt = 0;
    private Updater updater = new Updater(this);
    Timer timer = new Timer();

    @FXML
    public void initialize() {
        timer.schedule(updater, 0, 1000);
    }

    public void pressButton() {
        if (cnt % 2 == 0) {
            stopwatchEven.start();
            stopwatchOdd.stop();
            button.setId("buttonUnUseTime");
            labelEven.setStyle("-fx-text-fill:white");
            labelOdd.setStyle("-fx-text-fill:#ffffffc4;");
            

        } else {
            stopwatchOdd.start();
            stopwatchEven.stop();
            button.setId("buttonUseTime");
            labelOdd.setStyle("-fx-text-fill:white");
            labelEven.setStyle("-fx-text-fill:#ffffffc4;");
            
            
        }
        cnt++;
    }

    public void setTextOdd() {
        labelEven.setText(stopwatchEven.getTimeSec());
        labelOdd.setText(stopwatchOdd.getTimeSec());
    }

    public void setTextEven() {
        labelEven.setText(stopwatchEven.getTimeSec());
        labelOdd.setText(stopwatchOdd.getTimeSec());
    }

    public int getCnt() {
        return cnt;
    }

}

