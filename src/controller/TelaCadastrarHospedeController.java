package controller;

import java.time.LocalDate;

import dao.HospedeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Hospede;

public class TelaCadastrarHospedeController {

    @FXML
    private Button idCadastrar;

    @FXML
    private TextField idCpf;

    @FXML
    private DatePicker idDtNact;

    @FXML
    private TextField idEmail;

    @FXML
    private TextField idNome;

    @FXML
    private TextField idTelefone;

    @FXML
    void Cadastrar(ActionEvent event) {
        String nomeCom = idNome.getText();
        String emailHosp = idEmail.getText();
        String telHosp = idTelefone.getText();
        int cpfHosp = Integer.parseInt(idCpf.getText());
        LocalDate dataHosp = idDtNact.getValue();


        Hospede hosp = new Hospede(1, nomeCom, emailHosp, cpfHosp, dataHosp, telHosp);

    if (HospedeDao.cadastrar(hosp)) {
        System.out.println("Cadastrado!");
    }
    }

    @FXML
    void DtNact(ActionEvent event) {

    }

}
