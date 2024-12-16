package controller;

import java.time.LocalDate;

import dao.FuncionarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Funcionario;
import util.AlertUtil;

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
        try {
            String nomeus = idNomeUs.getText();
            String nomeCom = idNomeCom.getText();
            String emailFunc = idEmailFunc.getText();
            String senhafunc = idSenhaFunc.getText();
            String telFunc = idTelFunc.getText();
            String cpfString = idCPFFunc.getText();
            LocalDate dataFunc = idDataFunc.getValue();

            StringBuilder erros = new StringBuilder();

            int cpfFunc = Integer.parseInt(idCPFFunc.getText());
            
            if (nomeus == null || nomeus.trim().isEmpty()||nomeus.isBlank() || nomeus.length() < 3)  {
                throw new IllegalArgumentException("O nome de usuário é obrigatório e precisa ter mais de 3 letras.");
            } 
            if (nomeCom == null || nomeCom.trim().isEmpty() || nomeus.length() < 3) {
                throw new IllegalArgumentException("O nome Completo é obrigatorio e precisa ter mais de 3 letras.");
            }
            if (emailFunc == null || emailFunc.trim().isEmpty() || !emailFunc.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")){
                throw new IllegalArgumentException("O e-mail é obrigatório e deve estar em um formato válido.");
            }
            if (senhafunc == null || senhafunc.trim().isEmpty() || senhafunc.length() <= 6){
                throw new IllegalArgumentException("A senha é obrigatória e deve ter pelo menos 6 caracteres.");

            }
            if (telFunc == null || telFunc.trim().isEmpty() || !telFunc.matches("^\\d{10,11}$")){
                throw new IllegalArgumentException("O telefone é obrigatório e deve conter apenas números (10 ou 11 dígitos).");

            }
            

            if (dataFunc == null){
                throw new IllegalArgumentException("A data de nascimento é obrigatória.\n");

            }


           

                Funcionario func = new Funcionario(1, nomeus, nomeCom, emailFunc, cpfFunc, senhafunc, dataFunc, telFunc);
                if (FuncionarioDao.cadastrar(func)) {
                    System.out.println("Cadastrado!");
                    } else{
                        System.out.println("Erros encontrados:\n" + erros.toString());
                    }
           
        }

            catch (IllegalArgumentException e){
                AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            } catch (Exception e){
                AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            }
            

           


            
            
               
            
    }

    @FXML
    void DataFunc(ActionEvent event) {

    }

}
