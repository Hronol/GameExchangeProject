package game.views;

import game.GamesData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerClientView{

    public TextField searchField;
    public ControllerAdminGameView controllerAdminGameView = new ControllerAdminGameView();



    //wyszukiwanie
    public void searchText(){
        controllerAdminGameView.searchMethod();
    }

    public void quitButton(ActionEvent event) {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Potwierdź", ButtonType.OK, ButtonType.CANCEL);
          Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
          alert.setContentText("Czy na pewno chcesz wyjść?");
          alert.initModality(Modality.APPLICATION_MODAL);
          alert.initOwner(stage);
          alert.showAndWait();

          if (alert.getResult() == ButtonType.OK) {
              Platform.exit();
        } else {
              alert.close();
          }
    }

}
