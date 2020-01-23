package game.views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.WindowEvent;


public class ControllerClientView {

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

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
