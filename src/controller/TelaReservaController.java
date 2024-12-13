package controller;

import java.time.LocalDate;
import java.util.Observable;

import dao.HospedeDao;
import dao.ReservaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Reserva;

public class TelaReservaController{

    @FXML
    private DatePicker idCheckin;

    @FXML
    private DatePicker idCheckout;

    @FXML
    private TextField idCliente;

    @FXML
    private ChoiceBox<String> idFormPag;

    @FXML
    ObservableList <String> pagamento = FXCollections.observableArrayList("Dinheiro", "Cartão de Crédito", "PIX");

    @FXML
    private void initialize(){
        idFormPag.setValue("");
        idFormPag.setItems(pagamento);
    }

    @FXML
    private Label idPreco;

    @FXML
    private TextField idQuarto;

    @FXML
    private Button idReserva;

    @FXML
    private TextField idtxtpreco;

    @FXML
    void Reserva(ActionEvent event) {
        int Num_Quarto = Integer.parseInt(idQuarto.getText());
        LocalDate Checkin = idCheckin.getValue();
        LocalDate Checkout = idCheckout.getValue();
        Double Preco = Double.parseDouble(idtxtpreco.getText());
        String Pagamento = idFormPag.getValue();
        int idHosp = Integer.parseInt(idCliente.getText());

        Reserva reserv = new Reserva(1, Num_Quarto, Checkin, Checkout, Preco, Pagamento, idHosp);

         if (ReservaDao.cadastrar(reserv)) {
        System.out.println("Cadastrado!");
    }
    }
 
}
