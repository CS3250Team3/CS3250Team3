package main;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class dbController {


    @FXML
    public TableColumn<main.dataBaseItems, String> col_id;

    @FXML
    public TableColumn<main.dataBaseItems,Integer> col_quantity;

    @FXML
    public TableColumn<main.dataBaseItems, Float> col_cost;

    @FXML
    public TableColumn<main.dataBaseItems, Float> col_price;

    @FXML
    public TableColumn<main.dataBaseItems, String> col_sid;

}
