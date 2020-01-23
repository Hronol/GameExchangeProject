package game.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class ControllerAdminView {
    public void goToAdminViewClients(ActionEvent event) throws IOException {
        Parent adminClientViewParent = FXMLLoader.load(getClass().getResource("adminClientViewPanel.fxml"));
        Stage adminClientWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        adminClientWindow.setScene(new Scene(adminClientViewParent));
        adminClientWindow.show();
    }

    public void goToAdminViewGames(ActionEvent event) throws IOException {
        FXMLLoader adminGamesViewParent = new FXMLLoader(getClass().getResource("adminGameViewPanel.fxml"));
        Parent root = adminGamesViewParent.load();

       // ControllerClientView clientView = adminGamesViewParent.getController();
       //clientView.initialize();

        Stage adminGamesWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        adminGamesWindow.setScene(new Scene(root));
        adminGamesWindow.show();
    }
}
