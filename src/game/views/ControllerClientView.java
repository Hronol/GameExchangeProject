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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerClientView{

    public TextField searchField;
    public ControllerAdminGameView controllerAdminGameView = new ControllerAdminGameView();

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

    //wyszukiwanie
    public void searchText(){
        controllerAdminGameView.searchMethod();
    }

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
