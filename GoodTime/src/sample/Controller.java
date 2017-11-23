package sample;

<<<<<<< master
=======
import entity.Stopwatch;
import entity.Updater;
>>>>>>> master
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Timer;

public class Controller {
    @FXML
<<<<<<< master
    Label labelEven, labelOdd, labelStartText;
    @FXML
    Button button;
    
    Timer timerEvent = new Timer();
    Timer timerOdd = new Timer();
=======
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
>>>>>>> master

    public void pressButton() {
<<<<<<< master
        labelStartText.setText("");
        if(cnt % 2 == 0) {
            labelOdd.setText("");
            labelEven.setText("Use Time");
             button.setId("buttonUnUseTime");
        }
        else {
            labelEven.setText("");
            labelOdd.setText("Unuse Time");
            button.setId("buttonUseTime");
=======
        labelText.setText("");
        if (cnt % 2 == 0) {
            stopwatchEven.start();
            stopwatchOdd.stop();

        } else {
            stopwatchOdd.start();
            stopwatchEven.stop();
>>>>>>> master
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

