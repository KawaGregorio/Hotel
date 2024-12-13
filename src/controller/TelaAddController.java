package controller;

import dao.QuartosDao;
import dao.ReservaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AddQuartos;

public class TelaAddController {

    @FXML
    private Button idAdc;

    @FXML
    private TextField idDisp;

    @FXML
    private TextField idHo;

    @FXML
    private TextField idNumQua;

    @FXML
    private TextField idprec;

    @FXML
    void Adc(ActionEvent event) {
        int Num = Integer.parseInt(idNumQua.getText());
        String disp = idDisp.getText();
        Double prec = Double.parseDouble(idprec.getText());
        int idHosp = Integer.parseInt(idHo.getText());

        AddQuartos qua = new AddQuartos(1, Num, disp, prec, idHosp);

        if (QuartosDao.cadastrar(qua)) {
        System.out.println("Cadastrado!");
    }
    }

}
