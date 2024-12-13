package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;

import dao.QuartosDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.AddQuartos;

public class TelaQuartosController {

    @FXML
    private TableColumn<AddQuartos, String> Disponibilidade;

    @FXML
    private TableColumn<AddQuartos, Integer> Hospede;

    @FXML
    private TableColumn<AddQuartos, Integer> Num_Quartos;

    @FXML
    private TableColumn<AddQuartos, Double> Preco;

    



    @FXML
    private Button idAdcQuartos;

    @FXML
    private Button idDelQuartos;

    @FXML
    private TableColumn<?, ?> idIDQuarto;

    @FXML
    private Button idModificar;

    @FXML
    private Button idPesquisar;

    @FXML
    private Button idVoltar;

    @FXML
    private TableView<AddQuartos> idtbQuartos;
    ObservableList<AddQuartos> obsQua;

    @FXML
    private void initialize(){
        Disponibilidade.setCellValueFactory(new PropertyValueFactory<>("Disp"));
        Hospede.setCellValueFactory(new PropertyValueFactory<>("idHosp"));
        Num_Quartos.setCellValueFactory(new PropertyValueFactory<>("Num_Quarto"));
        Preco.setCellValueFactory(new PropertyValueFactory<>("Preco"));
        idIDQuarto.setCellValueFactory(new PropertyValueFactory<>("idQuarto"));

        obsQua = FXCollections.observableArrayList();

        idtbQuartos.setItems(obsQua);
    }

    @FXML
    void AdcQuartos(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/TelaAddQuartos.fxml");
        Parent root = FXMLLoader.load(url);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Yasmin dos Santos Silva e kawa gregorio da costa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();    
    }

    @FXML
    void Modificar(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/TelaModQuartos.fxml");
        Parent root = FXMLLoader.load(url);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Yasmin dos Santos Silva e kawa gregorio da costa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @FXML
    void Pesquisar(ActionEvent event) {
        
        List<AddQuartos> QuartosCadastrados = AddQuartos.listar();

        for(AddQuartos qua : QuartosCadastrados){
            obsQua.add(qua);
        }
    }

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/TelaMenu.fxml");
        Parent root = FXMLLoader.load(url);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Yasmin dos Santos Silva e kawa gregorio da costa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();    
    }

    @FXML
    void idDelQuartos(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/TelaDelQuartos.fxml");
        Parent root = FXMLLoader.load(url);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Yasmin dos Santos Silva e kawa gregorio da costa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();    
    }

}
