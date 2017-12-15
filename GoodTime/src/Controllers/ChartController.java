
package Controllers;

import entity.StoreOfDays;

import java.io.FileNotFoundException;
import java.util.Collections;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class ChartController {

    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private RadioButton last10Days;
    @FXML
    private RadioButton last30Days;

    private XYChart.Series usefulSeries;
    private XYChart.Series uselessSeries;
    final ToggleGroup group = new ToggleGroup();

    @FXML
    private void initialize() throws FileNotFoundException {
        usefulSeries = new XYChart.Series();
        uselessSeries = new XYChart.Series();

        last10Days.setToggleGroup(group);
        last30Days.setToggleGroup(group);
        last10Days.setSelected(true);


        initData(10, 0);
        lineChart.setTitle("Last 10 active days");
        usefulSeries.setName("Useful time");
        uselessSeries.setName("Useless time");
        xAxis.setLabel("Date");
        yAxis.setLabel("Hours");
        lineChart.getData().addAll(usefulSeries, uselessSeries);
    }

    @FXML
    private void pressButton() throws FileNotFoundException {
        lineChart.getData().clear();
        usefulSeries = new XYChart.Series();
        uselessSeries = new XYChart.Series();
        usefulSeries.getData().clear();
        uselessSeries.getData().clear();


        initData(30, 0);
        lineChart.setTitle("Last 30 active days");
        usefulSeries.setName("Useful time");
        uselessSeries.setName("Useless time");
        xAxis.setLabel("Date");
        yAxis.setLabel("Hours");

        lineChart.getData().addAll(usefulSeries, uselessSeries);
    }

    @FXML
    private void pressButton2() throws FileNotFoundException {
        usefulSeries = new XYChart.Series();
        uselessSeries = new XYChart.Series();
        usefulSeries.getData().clear();
        uselessSeries.getData().clear();
        lineChart.getData().clear();
        initData(10, 0);
        lineChart.setTitle("Last 10 active days");
        usefulSeries.setName("Useful time");
        uselessSeries.setName("Useless time");
        xAxis.setLabel("Date");
        yAxis.setLabel("Hours");

        lineChart.getData().addAll(usefulSeries, uselessSeries);
    }


    private void initData(int r, int l) throws FileNotFoundException {

        StoreOfDays storeList = new StoreOfDays();
        Collections.reverse(storeList);


        for (int i = Math.min(r, storeList.size()) - 1; i >= Math.min(l, storeList.size()); i--) {
            String date = storeList.get(i).getDate().substring(5, 10);
            double usefulT = countHours(storeList.get(i).getUsefulTime());
            double uselessT = countHours(storeList.get(i).getUselessTime());
            usefulSeries.getData().add(new XYChart.Data(date, usefulT));
            uselessSeries.getData().add(new XYChart.Data(date, uselessT));
        }
    }

    public static double countHours(String s) {
        String hs = new String(s.substring(0, 2));
        Integer hour = Integer.parseInt(hs);

        String ms = new String(s.substring(3, 5));
        double min = Double.parseDouble(ms);
        min = min / 60;

        String ss = new String(s.substring(6, 8));
        double second = Double.parseDouble(ss);
        second = second / 360;

        double time = hour + min + second;

        return time;
    }


}
