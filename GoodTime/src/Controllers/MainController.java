package Controllers;

import entity.Day;
import entity.Stopwatch;
import entity.StoreOfDays;
import entity.Updater;

import java.awt.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import javafx.stage.Stage;
import Application.LineChartApp;
import Application.TableApp;

public class MainController {
    @FXML
    private Label labelEven, labelOdd, labelStartText;
    @FXML
    private Button button;


    private Stopwatch stopwatchEven;
    private Stopwatch stopwatchOdd;
    private int cnt;
    private Updater updater;
    private Timer timer;
    private Day day;
    private StoreOfDays repo;


    @FXML
    public void initialize() throws FileNotFoundException {
        stopwatchEven = new Stopwatch();
        stopwatchOdd = new Stopwatch();
        updater = new Updater(this);
        timer = new Timer();
        repo = new StoreOfDays();
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        day = new Day();
        day.setDate(format.format(dateNow));
        if (repo.size() != 0 && repo.get(repo.size() - 1).getDate().equals(day.getDate())) {
            day = repo.get(repo.size() - 1);
            stopwatchEven.setCurrentTime(Day.getSec(day.getUsefulTime()));
            stopwatchOdd.setCurrentTime(Day.getSec(day.getUselessTime()));
        } else {
            repo.add(day);
        }
        timer.schedule(updater, 0, 1000);

    }

    @FXML
    private void pressButton() {
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
        day.setUsefulTime(stopwatchEven.getTimeSec());
        repo.save();
    }

    public void setTextEven() throws IOException {
        labelEven.setText(stopwatchEven.getTimeSec());
        labelOdd.setText(stopwatchOdd.getTimeSec());
        day.setUselessTime(stopwatchOdd.getTimeSec());
        repo.save();
    }

    @FXML
    private void getStatistic() throws Exception {
        TableApp stat = new TableApp();
        stat.start(new Stage());
    }

    @FXML
    private void graphic() throws Exception {
        LineChartApp chart = new LineChartApp();
        chart.start(new Stage());
    }

    @FXML
    private void getHelp() throws FileNotFoundException {
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(new File("src/help/help.txt"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public int getCnt() {
        return cnt;
    }


}