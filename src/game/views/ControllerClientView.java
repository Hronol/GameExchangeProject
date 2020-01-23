package game.views;

import game.GamesData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerClientView implements Initializable {

    public TableView<GamesData> tableView;
    public TableColumn<GamesData, String> titleColumn;
    public TableColumn<GamesData, String> platformColumn;
    public TableColumn<GamesData, Integer> dateColumn;
    public TableColumn<GamesData, String> genreColumn;
    public TableColumn<GamesData, Double> priceColumn;

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("GameTitle"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("GamePlatform"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("GameYear"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("GameCategory"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("GamePrice"));
        tableView.setItems(observableList);
    }

    ObservableList<GamesData> observableList = FXCollections.observableArrayList(
            new GamesData("GTA5", "PS4", 2014, "Akcja", 199.99),
            new GamesData("Mario Bross", "Xbox One", 2011, "Przygodowa", 239.99),
            new GamesData("Call of Duty", "PC", 2019, "Strzelanka", 99.99)
    );

    EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            alert.show();
        }
    };

    public void quitButton(ActionEvent event) {
//        eventHandler.handle();
        alert.setContentText("Czy na pewno chcesz wyjść?");
        alert.show();

        if (alert.getResult().getButtonData().isCancelButton()) {
        }
        else {
            Platform.exit();
            System.exit(0);
        }
    }

}
