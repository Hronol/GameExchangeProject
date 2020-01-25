package game.views;

import game.GamesData;
import game.GamesRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdminGameView implements Initializable {

    public TableView<GamesData> tableView;
    public TableColumn<GamesData, String> titleColumn;
    public TableColumn<GamesData, String> platformColumn;
    public TableColumn<GamesData, Integer> dateColumn;
    public TableColumn<GamesData, String> genreColumn;
    public TableColumn<GamesData, Double> priceColumn;
    public TextField textFieldTitle;
    public TextField textFieldPlatform;
    public TextField textFieldYear;
    public TextField textFieldGenre;
    public TextField textfieldPrice;
    public TextField searchField;
    public GamesRepository gamesRepository = new GamesRepository();
    public ObservableList<GamesData> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("GameTitle"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("GamePlatform"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("GameYear"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("GameCategory"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("GamePrice"));

        GamesData tmp1 = new GamesData("GTA5", "PS4", 2014, "Akcja", 199.99);
        GamesData tmp2 = new GamesData("Mario Bross", "Xbox One", 2011, "Przygodowa", 239.99);
        GamesData tmp3 = new GamesData("Call of Duty", "PC", 2019, "Strzelanka", 99.99);
        dataList.addAll(tmp1,tmp2,tmp3);

        tableView.setItems(dataList);
    }

    //dodawanie gry do tableView i bazy
    public void addGame(ActionEvent event){
        GamesData gamesData = new GamesData(
                textFieldTitle.getText(),
                textFieldPlatform.getText(),
                Integer.parseInt(textFieldYear.getText()),
                textFieldGenre.getText(),
                Double.parseDouble(textfieldPrice.getText()));
        tableView.getItems().add(gamesData);
        addGamesToDB();
        clearTextFields();
    }

    //czyszczenie text fieldów
    public void clearTextFields(){
        textFieldYear.clear();
        textFieldGenre.clear();
        textFieldPlatform.clear();
        textfieldPrice.clear();
        textFieldTitle.clear();
    }
    //dodawanie gier z textFieldów do bazy gier
    public void addGamesToDB(){
        gamesRepository.addGametoRepo(
                textFieldTitle.getText(),
                textFieldPlatform.getText(),
                Integer.parseInt(textFieldYear.getText()),
                textFieldGenre.getText(),
                Double.parseDouble(textfieldPrice.getText()));
    }

    //usuwanie gry z tableView i bazy
    public void deleteGame(ActionEvent event){
        ObservableList<GamesData> allGames, singleGame;
        allGames = tableView.getItems();
        singleGame = tableView.getSelectionModel().getSelectedItems();
        singleGame.forEach(allGames::remove);
    }

    //zapis bazy gier do tableView
    public void saveTableviewtoDB(ActionEvent event){

    }

    //wczytanie bazy gier do tableView
    public void loadDBToTableview(){
        //TODO
    }

    //powrot do adminViewPanel
    public void goBacktoAdminViewPanel(ActionEvent event) throws IOException {
        ControllerMainView controllerMainView = new ControllerMainView();
        controllerMainView.goToAdminView(event);
    }

    //wyszukiwanie
    public void searchMethod() {
        FilteredList<GamesData> filteredList = new FilteredList<>(dataList, b -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(gamesData -> {

                if (newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (gamesData.getGameTitle().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                } else if (gamesData.getGameCategory().toLowerCase().indexOf(lowerCaseFilter) != -1 ){
                    return  true;
                } else if (gamesData.getGamePlatform().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return  true;
                } else if (gamesData.getGamePrice().toString().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (gamesData.getGameYear().toString().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else
                    return false;
            });
        });

        SortedList<GamesData> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedList);
    }

}
