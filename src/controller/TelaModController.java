package controller;

import dao.AltQuartosDao;
import dao.DelQuartosDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AltQuartos;

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
        int idHosp = Integer.parseInt(idHospede.getText());
        int idQua = Integer.parseInt(idQuarot.getText());
        String Disp = idDisponibilidade.getText();

        AltQuartos Alt = new AltQuartos(idHosp, Disp, idQua);

        if (AltQuartosDao.cadastrar(Alt)) {
            System.out.println("Cadastrado!");
        }
    }

}
