package sample;

import entity.Stopwatch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Timer;

public class Controller {
    @FXML
    Label labelEven, labelOdd, labelText;

    Stopwatch stopwatchEven = new Stopwatch();
    Stopwatch stopwatchOdd = new Stopwatch();

    private int cnt = 0;

    public void pressButton() {
        labelText.setText("");
        if (cnt % 2 == 0) {
            stopwatchEven.start();
            stopwatchOdd.stop();
            labelOdd.setText("");
            labelEven.setText(stopwatchEven.getTimeSec());
        } else {
            stopwatchOdd.start();
            stopwatchEven.stop();
            labelEven.setText("");
            labelOdd.setText(stopwatchOdd.getTimeSec());
        }
        cnt++;
    }

}

