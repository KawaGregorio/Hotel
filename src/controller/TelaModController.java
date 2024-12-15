package controller;

import dao.AltQuartosDao;
import dao.DelQuartosDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AltQuartos;
import util.AlertUtil;

public class TelaModController {

    @FXML
    private TextField idDisponibilidade;

    @FXML
    private TextField idHospede;

    @FXML
    private Button idModificar;

    @FXML
    private TextField idQuarot;

    @FXML
    void Modificar(ActionEvent event) {
               
String idHospString = idHospede.getText();
String idQuaString = idQuarot.getText();
String disp = idDisponibilidade.getText();


int idHosp = 0;
int idQua = 0;

try {

    if (idHospString == null || idHospString.trim().isEmpty()) {
        throw new IllegalArgumentException("O campo 'Hóspede' não pode estar vazio.");
    }
    idHosp = Integer.parseInt(idHospString);
    if (idHosp <= 0) {
        throw new IllegalArgumentException("O campo 'Hóspede' deve ser um número maior que zero.");
    }


    if (idQuaString == null || idQuaString.trim().isEmpty()) {
        throw new IllegalArgumentException("O campo 'Numero do Quarto' não pode estar vazio.");
    }
    idQua = Integer.parseInt(idQuaString);
    if (idQua <= 0) {
        throw new IllegalArgumentException("O campo 'Numero do Quarto' deve ser um número maior que zero.");
    }

    if (disp == null || disp.trim().isEmpty()) {
        throw new IllegalArgumentException("O campo 'Disponibilidade' não pode estar vazio.");
    }
    if (!disp.equalsIgnoreCase("Disponível") && !disp.equalsIgnoreCase("Indisponível")) {
        throw new IllegalArgumentException("O campo 'Disponibilidade' deve ser 'Disponível' ou 'Indisponível'.");
    }


    AltQuartos alt = new AltQuartos(idHosp, disp, idQua);
    if (AltQuartosDao.cadastrar(alt)) {
        System.out.println("Cadastro realizado com sucesso!");
    } else {
        System.out.println("Erro ao cadastrar o quarto.");
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
