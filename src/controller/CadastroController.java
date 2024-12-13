package controller;

import java.time.LocalDate;

import dao.FuncionarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Funcionario;

public class CadastroController {

    @FXML
    private TextField idCPFFunc;

    @FXML
    private Button idCadastrarFunc;

    @FXML
    private DatePicker idDataFunc;

    @FXML
    private TextField idEmailFunc;

    @FXML
    private TextField idNomeCom;

    @FXML
    private TextField idNomeUs;

    @FXML
    private TextField idSenhaFunc;

    @FXML
    private TextField idTelFunc;

    @FXML
    void CadastrarFunc(ActionEvent event) {
            String nomeus = idNomeUs.getText();
            String nomeCom = idNomeCom.getText();
            String emailFunc = idEmailFunc.getText();
            String senhafunc = idSenhaFunc.getText();
            String telFunc = idTelFunc.getText();
            int cpfFunc = Integer.parseInt(idCPFFunc.getText());
            LocalDate dataFunc = idDataFunc.getValue();


            Funcionario func = new Funcionario(1, nomeus, nomeCom, emailFunc, cpfFunc, senhafunc, dataFunc, telFunc);

        if (FuncionarioDao.cadastrar(func)) {
            System.out.println("Cadastrado!");
        }
    }

    @FXML
    void DataFunc(ActionEvent event) {

    }

}
