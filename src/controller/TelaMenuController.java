package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaMenuController {

    @FXML
    private Button idBtHopede;

    @FXML
    private Button idBtQua;

    @FXML
    private Button idBtRes;

    @FXML
    private Button idbtnHospedes;

    @FXML
    void btnHospedes(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/TelaHospedes.fxml");
        Parent root = FXMLLoader.load(url);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Yasmin dos Santos Silva e kawa gregorio da costa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void idBtHospedeA(ActionEvent event) throws IOException {
         URL url = getClass().getResource("/view/TelaCadastrarHospede.fxml");
        Parent root = FXMLLoader.load(url);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Yasmin dos Santos Silva e kawa gregorio da costa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void idBtQuaA(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/TelaRegistroQuartos.fxml");
        Parent root = FXMLLoader.load(url);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Yasmin dos Santos Silva e kawa gregorio da costa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void idBtResA(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/TelaReserva.fxml");
        Parent root = FXMLLoader.load(url);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Yasmin dos Santos Silva e kawa gregorio da costa");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
