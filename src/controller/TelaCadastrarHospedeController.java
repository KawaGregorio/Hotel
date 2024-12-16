package controller;

import java.time.LocalDate;

import dao.HospedeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Hospede;
import util.AlertUtil;

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

        try{
        String nomeCom = idNome.getText();
        String emailHosp = idEmail.getText();
        String telHosp = idTelefone.getText();
        int cpfHosp = Integer.parseInt(idCpf.getText());

        LocalDate dataHosp = idDtNact.getValue();

        if (nomeCom == null || nomeCom.trim().isEmpty() || nomeCom.length() < 3) {
            throw new IllegalArgumentException("O nome Completo é obrigatorio e precisa ter mais de 3 letras.\n");
        }
        if (emailHosp == null || emailHosp.trim().isEmpty() || !emailHosp.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")){
            throw new IllegalArgumentException("O e-mail é obrigatório e deve estar em um formato válido.\n");
        }
        if (telHosp == null || telHosp.trim().isEmpty()){
            throw new IllegalArgumentException("O telefone é obrigatório e deve conter apenas números (10 ou 11 dígitos). \n");

        }

        if (dataHosp == null){
            throw new IllegalArgumentException("A data de nascimento é obrigatória.\n");

        }


        Hospede hosp = new Hospede(1, nomeCom, emailHosp, cpfHosp, dataHosp, telHosp);

    if (HospedeDao.cadastrar(hosp)) {
        System.out.println("Cadastrado!");
    }

} catch (IllegalArgumentException e){
                AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            }
    }

    @FXML
    void DtNact(ActionEvent event) {

    }

}
