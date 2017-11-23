package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Timer;

public class Controller {
    @FXML
    Label labelEven, labelOdd, labelStartText;
    @FXML
    Button button;
    
    Timer timerEvent = new Timer();
    Timer timerOdd = new Timer();

    private int cnt = 0;
    public void pressButton() {
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
        }
        cnt ++;
    }

}

