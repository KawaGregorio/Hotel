package controller;

import dao.DelQuartosDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AddQuartos;
import model.DelQuartos;

public class DelQuartoController {

    @FXML
    private Button idDel;

    @FXML
    private TextField idID;

    @FXML
    void Del(ActionEvent event) {
        int id = Integer.parseInt(idID.getText());

        DelQuartos qua = new DelQuartos(id);

        if (DelQuartosDao.cadastrar(qua)) {
            System.out.println("Cadastrado!");
        }
}
}
