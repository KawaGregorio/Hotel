package controller;

import java.time.LocalDate;
import java.util.Observable;

import dao.HospedeDao;
import dao.ReservaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Reserva;
import util.AlertUtil;

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
        String numQuartoString = idQuarto.getText();
        LocalDate checkin = idCheckin.getValue();
        LocalDate checkout = idCheckout.getValue();
        String precoString = idtxtpreco.getText();
        String pagamento = idFormPag.getValue();
        String idHospString = idCliente.getText();

        int numQuarto = 0;
        int idHosp = 0;
        double preco = 0.0;

    try {
    
        if (numQuartoString == null || numQuartoString.trim().isEmpty()) {
            throw new IllegalArgumentException("O Número do Quarto não pode estar vazio.");
        }
            numQuarto = Integer.parseInt(numQuartoString);
        if (numQuarto <= 0) {
            throw new IllegalArgumentException("O Número do Quarto deve ser maior que zero.");
        }

        if (checkin == null) {
            throw new IllegalArgumentException("A Data de Check-in não pode estar vazia.");
        }
        if (checkout == null) {
            throw new IllegalArgumentException("A Data de Check-out não pode estar vazia.");
        }
        if (!checkout.isAfter(checkin)) {
            throw new IllegalArgumentException("A Data de Check-out deve ser posterior à Data de Check-in.");
        }


        if (precoString == null || precoString.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Preço' não pode estar vazio.");
        }
            preco = Double.parseDouble(precoString);
        if (preco <= 0) {
            throw new IllegalArgumentException("O campo 'Preço' deve ser maior que zero.");
        }

        if (pagamento == null || pagamento.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Forma de Pagamento' não pode estar vazio.");
        }

        if (idHospString == null || idHospString.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Cliente' não pode estar vazio.");
        }
            idHosp = Integer.parseInt(idHospString);
        if (idHosp <= 0) {
            throw new IllegalArgumentException("O campo 'Cliente' deve ser maior que zero.");
        }


    Reserva reserv = new Reserva(1, numQuarto, checkin, checkout, preco, pagamento, idHosp);
    if (ReservaDao.cadastrar(reserv)) {
        System.out.println("Reserva cadastrada com sucesso!");
    } else {
        System.out.println("Erro ao cadastrar a reserva.");
    }

} catch (NumberFormatException e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
} catch (IllegalArgumentException e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
} catch (Exception e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());

}
    }
 
}
