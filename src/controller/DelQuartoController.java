package controller;

import dao.DelQuartosDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AddQuartos;
import model.DelQuartos;
import util.AlertUtil;

public class DelQuartoController {

    @FXML
    private Button idDel;

    @FXML
    private TextField idID;

    @FXML
    void Del(ActionEvent event) {
    try {
        int id = Integer.parseInt(idID.getText());
        String idd = idID.getText();

        if (idd == null || idd.isEmpty()) {
            throw new IllegalArgumentException("o id do cliente está vazio");
        }

        DelQuartos qua = new DelQuartos(id);

        if (DelQuartosDao.cadastrar(qua)) {
            System.out.println("Cadastrado!");
        }

    } catch (NumberFormatException e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
} catch (IllegalArgumentException e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
}
}
}
