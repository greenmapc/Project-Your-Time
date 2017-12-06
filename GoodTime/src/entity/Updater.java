package entity;


import javafx.application.Platform;
import sample.Controller;

import java.util.TimerTask;


public class Updater extends TimerTask {
    private Controller contr;

    public Updater(Controller contr) {
        this.contr = contr;
    }

    @Override
    public void run() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (contr.getCnt() % 2 == 0) {
                    contr.setTextEven();
                } else {
                    contr.setTextOdd();
                }
            }
        });
    }
}
