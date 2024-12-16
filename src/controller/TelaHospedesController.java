package controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Observable;

import dao.AltQuartosDao;
import dao.DelHospedesDao;
import dao.DelQuartosDao;
import dao.ModDao.AltCPFDao;
import dao.ModDao.AltDataDao;
import dao.ModDao.AltEmailDao;
import dao.ModDao.AltNomeDao;
import dao.ModDao.AltTelDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AddQuartos;
import model.DelQuartos;
import model.Hospede;
import model.Mod.AltCPF;
import model.Mod.AltData;
import model.Mod.AltEmail;
import model.Mod.AltNome;
import model.Mod.AltTel;
import util.AlertUtil;

public class TelaHospedesController {

    @FXML
    private TextField TxtTel;

    @FXML
    private Button btnDel;

    @FXML
    private TableView<Hospede> idTabelaHospede;

    @FXML
    private Button idbtnCPF;

    @FXML
    private Button idbtnData;

    @FXML
    private Button idbtnEmail;

    @FXML
    private Button idbtnNome;

    @FXML
    private Button idbtnPesquisar;

    @FXML
    private DatePicker iddpData;

    @FXML
    private TextField idtxtDel;

    @FXML
    private Button ifBtnTel;

    @FXML
    private TableColumn<Hospede, Integer> tbCPF;

    @FXML
    private TableColumn<Hospede, LocalDate> tbData;

    @FXML
    private TableColumn<Hospede, String> tbEmail;

    @FXML
    private TableColumn<Hospede, Integer> tbHospede;

    @FXML
    private TableColumn<Hospede, String> tbNome;

    @FXML
    private TableColumn<Hospede, String> tbTel;

    ObservableList<Hospede> obsHos;

    @FXML
    private void initialize(){
        tbCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tbData.setCellValueFactory(new PropertyValueFactory<>("dtNasc"));
        tbEmail.setCellValueFactory(new PropertyValueFactory<>("e_mailHospede"));
        tbHospede.setCellValueFactory(new PropertyValueFactory<>("idHospede"));
        tbNome.setCellValueFactory(new PropertyValueFactory<>("nome_completo"));
        tbTel.setCellValueFactory(new PropertyValueFactory<>("telefone_Hosp"));

        obsHos = FXCollections.observableArrayList();

        idTabelaHospede.setItems(obsHos);;
    }

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtHospede;

    @FXML
    private TextField txtNome;

    @FXML
    void btnCPF(ActionEvent event) {
        try {
            int idH = Integer.parseInt(txtHospede.getText());
            int cpf = Integer.parseInt(txtCPF.getText());
            String idHString = String.valueOf(idH);
            String cpfString = String.valueOf(cpf);

            if (idHString == null || idHString.trim().isEmpty()) {
                throw new IllegalArgumentException("O campo 'Hóspede' não pode estar vazio.");
            }
            
            if (cpfString == null || cpfString.trim().isEmpty()) {
                throw new IllegalArgumentException("O campo 'Hóspede' não pode estar vazio.");
            }


            AltCPF altCPF = new AltCPF(cpf, idH);
    
            if (AltCPFDao.cadastrar(altCPF)) {
                System.out.println("Cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar.");
            }
        } catch (NumberFormatException e) {
            AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            } catch (IllegalArgumentException e) {
            AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            }
    }

    @FXML
    void btnData(ActionEvent event) {
        try{
        LocalDate data = iddpData.getValue();
        int idH = 0;
        String idHString = txtHospede.getText();


        if (data == null) {
            throw new IllegalArgumentException("O campo 'Data' não pode estar vazio.");
        }
        if (idHString == null || idHString.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Hospede' não pode estar vazio.");
        }
        
        idH = Integer.parseInt(idHString);

        if (idH <= 0) {
            throw new IllegalArgumentException("O campo 'Hospede' deve ser maior que zero.");
        }
        AltData da = new AltData(data, idH);

        if (AltDataDao.cadastrar(da)) {
            System.out.println("Cadastrado!");
        }
    } catch (NumberFormatException e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
    } catch (IllegalArgumentException e) {
    AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
    }
}

    @FXML
    void btnDel(ActionEvent event) {
        try{
        String idString = idtxtDel.getText();
        int id = 0;


        if (idString == null || idString.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Hospede' não pode estar vazio.");
        }

        id = Integer.parseInt(idtxtDel.getText());

        if (id <= 0) {
            throw new IllegalArgumentException("O campo 'Hospede' deve ser maior que zero.");
        }

        DelQuartos qua = new DelQuartos(id);

        if (DelHospedesDao.cadastrar(qua)) {
            System.out.println("Cadastrado!");
        }
        } catch (NumberFormatException e) {
            AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            } catch (IllegalArgumentException e) {
            AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            }
    }

    @FXML
    void btnEmail(ActionEvent event) {
        try{
        String email = txtEmail.getText();
        int idH = 0;
        String idHString = txtHospede.getText();
        
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'E-mail' não pode estar vazio.");
        }
        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("O campo 'E-mail' deve ter um formato valido.");
        }

        if (idHString == null || idHString.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Hospede' não pode estar vazio.");
        }
        
        idH = Integer.parseInt(idHString);

        if (idH <= 0) {
            throw new IllegalArgumentException("O campo 'Hospede' deve ser maior que zero.");
        }

        AltEmail em = new AltEmail(email, idH);

        if (AltEmailDao.cadastrar(em)) {
            System.out.println("Cadastrado!");
        }
        } catch (NumberFormatException e) {
            AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            } catch (IllegalArgumentException e) {
            AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            }
    }

    @FXML
    void btnNome(ActionEvent event) {
        try{
        String Nome = txtNome.getText();
        int idH = 0;
        String idHString = txtHospede.getText();

        if (Nome == null || Nome.trim().isEmpty()||Nome.isBlank() || Nome.length() < 3)  {
            throw new IllegalArgumentException("O nome é obrigatório e precisa ter mais de 3 letras.");
        }


        if (idHString == null || idHString.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Hospede' não pode estar vazio.");
        }
        
        idH = Integer.parseInt(idHString);

        if (idH <= 0) {
            throw new IllegalArgumentException("O campo 'Hospede' deve ser maior que zero.");
        }

        AltNome ALT = new AltNome(Nome, idH);

        if (AltNomeDao.cadastrar(ALT)) {
            System.out.println("Cadastrado!");
        }
    }catch (NumberFormatException e) {
        AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
        } catch (IllegalArgumentException e) {
        AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
        }
    }

    @FXML
    void btnPesquisar(ActionEvent event) {
        List<Hospede> HospedesCadastrados = Hospede.listar();

        for(Hospede hos : HospedesCadastrados){
            obsHos.add(hos);
        }
    }

    @FXML
    void btnTel(ActionEvent event) {
        try{
        String te = TxtTel.getText();
        int idH = 0;
        String idHString = txtHospede.getText();

        if (te == null || te.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Telefone' não pode estar vazio.");
        }
        if (!te.matches("^\\d{10,11}$")) {
            throw new IllegalArgumentException("O campo 'Telefone' deve conter 11 numeros.");
        }

        if (idHString == null || idHString.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Hospede' não pode estar vazio.");
        }
        
        idH = Integer.parseInt(idHString);

        if (idH <= 0) {
            throw new IllegalArgumentException("O campo 'Hospede' deve ser maior que zero.");
        }



        AltTel tel = new AltTel(te, idH);

        if (AltTelDao.cadastrar(tel)) {
            System.out.println("Cadastrado!");
        }
        } catch (NumberFormatException e) {
            AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            } catch (IllegalArgumentException e) {
            AlertUtil.showAlert(AlertType.WARNING, "ERRO", e.getMessage());
            }
    }

}
