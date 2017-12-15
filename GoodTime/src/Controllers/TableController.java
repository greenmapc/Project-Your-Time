package Controllers;


import java.io.FileNotFoundException;

import entity.StatisticView;
import entity.StoreOfDays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController {


    @FXML
    private ObservableList<StatisticView> statiscticTable = FXCollections.observableArrayList();

    @FXML
    private TableView<StatisticView> table;
    @FXML
    private TableColumn<StatisticView, String> dayColumn;

    @FXML
    private TableColumn<StatisticView, String> usefulTimeColumn;

    @FXML
    private TableColumn<StatisticView, String> uselesslTimeColumn;


    @FXML
    private void initialize() throws FileNotFoundException {
        initData();


        dayColumn.setCellValueFactory(new PropertyValueFactory<StatisticView, String>("dayColumn"));
        usefulTimeColumn.setCellValueFactory(new PropertyValueFactory<StatisticView, String>("usefulTimeColumn"));
        uselesslTimeColumn.setCellValueFactory(new PropertyValueFactory<StatisticView, String>("uselesslTimeColumn"));


        table.setItems(statiscticTable);
    }


    private void initData() throws FileNotFoundException {

        StoreOfDays store = new StoreOfDays();
        for (int i = 0; i < store.size(); i++) {
            statiscticTable.add(new StatisticView(store.get(i).getDate(), store.get(i).getUsefulTime(), store.get(i).getUselessTime()));
        }
    }
}
