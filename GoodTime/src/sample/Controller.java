package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Timer;

public class Controller {
    @FXML
    Label labelEven, labelOdd, labelText;

    Timer timerEvent = new Timer();
    Timer timerOdd = new Timer();

    private int cnt = 0;
    public void pressButton() {
        labelText.setText("");
        if(cnt % 2 == 0) {
            labelOdd.setText("");
            labelEven.setText("Use Time");
        }
        else {
            labelEven.setText("");
            labelOdd.setText("Unuse Time");
        }
        cnt ++;
    }

}

