package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import entity.StoreOfDays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller2 {
    @FXML
    private ObservableList<StatisticPojo> statiscticTable = FXCollections.observableArrayList();
 
    @FXML
    private TableView<StatisticPojo> table;
    @FXML
    private TableColumn<StatisticPojo, String> dayColumn;
 
    @FXML
    private TableColumn<StatisticPojo, String> usefulTimeColumn;
 
    @FXML
    private TableColumn<StatisticPojo, String> uselesslTimeColumn;

 
    @FXML
    private void initialize() throws FileNotFoundException {
        initData();
 
        // устанавливаем тип и значение которое должно хранится в колонке
        dayColumn.setCellValueFactory(new PropertyValueFactory<StatisticPojo, String>("dayColumn"));
        usefulTimeColumn.setCellValueFactory(new PropertyValueFactory<StatisticPojo, String>("usefulTimeColumn"));
        uselesslTimeColumn.setCellValueFactory(new PropertyValueFactory<StatisticPojo, String>("uselesslTimeColumn"));

 
        // заполняем таблицу данными
        table.setItems(statiscticTable);
    }
 
    private void initData() throws FileNotFoundException {

        Scanner in = new Scanner(new File("src/repository/database"));
        String string;

        while(in.hasNext()) {
            String date = in.next();
            String useful = in.next();
            String useless = in.next();
            statiscticTable.add(new StatisticPojo(date, useful, useless));

        }





    }

    private void goBack() throws IOException {
        
        
    }
    
    
}
