package sample;

import entity.Stopwatch;
import entity.Updater;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Timer;

public class Controller {
    @FXML
    private Label labelEven, labelOdd, labelText;
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
        labelText.setText("");
        if (cnt % 2 == 0) {
            stopwatchEven.start();
            stopwatchOdd.stop();

        } else {
            stopwatchOdd.start();
            stopwatchEven.stop();
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

