package game.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMainView {
        public void goToClientView(ActionEvent event) throws IOException {
                Parent clientViewParent = FXMLLoader.load(getClass().getResource("clientViewPanel.fxml"));
                Stage clientWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
                clientWindow.setScene(new Scene(clientViewParent));
                clientWindow.show();
        }

        public void goToAdminView(ActionEvent event) throws IOException {
                Parent adminViewParent = FXMLLoader.load(getClass().getResource("adminViewPanel.fxml"));
                Stage adminWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
                adminWindow.setScene(new Scene(adminViewParent));
                adminWindow.show();
        }

}
