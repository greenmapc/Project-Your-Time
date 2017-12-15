package entity;


import javafx.application.Platform;
import Controllers.MainController;

import java.io.IOException;
import java.util.TimerTask;


public class Updater extends TimerTask {
    private MainController contr;

    public Updater(MainController contr) {
        this.contr = contr;
    }

    @Override
    public void run() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (contr.getCnt() % 2 == 0) {
                    try {
                        contr.setTextEven();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        contr.setTextOdd();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
