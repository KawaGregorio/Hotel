package controller;

import dao.QuartosDao;
import dao.ReservaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AddQuartos;
import util.AlertUtil;

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
        try{

        
        int Num = 0;
        String disp = idDisp.getText();
        Double prec = 0.0;
        int idHosp = 0;
        String stringNum = idNumQua.getText();
        String stringPrec = idprec.getText();
        String stringIdHosp = idHo.getText();

        if (stringNum == null || stringNum.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Numero do Quarto' não pode estar vazio!");
        }
        Num = Integer.parseInt(stringNum);
        if (Num <= 0) {
            throw new IllegalArgumentException("O campo 'Numero do Quarto' deve ser um número maior que zero.");
        }

        if (disp == null || disp.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Disponibilidade' não pode estar vazio.");
        }
        
        if (stringPrec == null || stringPrec.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Preço' não pode estar vazio.");
        }
            prec = Double.parseDouble(stringPrec);
        if (prec <= 0) {
            throw new IllegalArgumentException("O campo 'Preço' deve ser maior que zero.");
        }
        if (stringIdHosp == null || stringIdHosp.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Hospede' não pode estar vazio.");
        }
            idHosp = Integer.parseInt(stringIdHosp);
        if (idHosp <= 0) {
            throw new IllegalArgumentException("O campo 'Hospede' deve ser maior que zero.");
        }
        

        AddQuartos qua = new AddQuartos(1, Num, disp, prec, idHosp);

        if (QuartosDao.cadastrar(qua)) {
        System.out.println("Cadastrado!");
        }
    } catch (NumberFormatException e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
    } catch (IllegalArgumentException e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
    }

    }
}
