package sample;

import entity.Day;
import entity.Stopwatch;
import entity.StoreOfDays;
import entity.Updater;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Controller {
    @FXML
    private Label labelEven, labelOdd, labelStartText;
    @FXML
    private Button button;

    private Stopwatch stopwatchEven;
    private Stopwatch stopwatchOdd;
    private int cnt ;
    private Updater updater ;
    private Timer timer ;
    private Day day;
    private StoreOfDays repo;


    @FXML
    public void initialize() throws FileNotFoundException {
        stopwatchEven = new Stopwatch();
        stopwatchOdd = new Stopwatch();
        updater =  new Updater(this);
        timer =  new Timer();
        repo = new StoreOfDays();
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        day = new Day();
        day.setDate(format.format(dateNow));
        if(repo.size()!=0 && repo.get(repo.size()-1).getDate().equals(day.getDate())){
            day = repo.get(repo.size()-1);
            stopwatchEven.setCurrentTime(Day.getSec(day.getUsefullTime()));
            stopwatchOdd.setCurrentTime(Day.getSec(day.getUselessTime()));
        } else {
            repo.add(day);
        }
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

    public void setTextOdd() throws IOException {
        labelEven.setText(stopwatchEven.getTimeSec());
        labelOdd.setText(stopwatchOdd.getTimeSec());
        day.setUsefullTime(stopwatchEven.getTimeSec());
        repo.save();
    }

    public void setTextEven() throws IOException {
        labelEven.setText(stopwatchEven.getTimeSec());
        labelOdd.setText(stopwatchOdd.getTimeSec());
        day.setUselessTime(stopwatchOdd.getTimeSec());
        repo.save();
    }

    public int getCnt() {
        return cnt;
    }


}

