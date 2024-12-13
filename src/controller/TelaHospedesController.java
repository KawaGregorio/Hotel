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
        int cpf = Integer.parseInt(txtCPF.getText());
        int idH = Integer.parseInt(txtHospede.getText());

        AltCPF ALTcp = new AltCPF(cpf, idH);

        if (AltCPFDao.cadastrar(ALTcp)) {
            System.out.println("Cadastrado!");
        }
    }

    @FXML
    void btnData(ActionEvent event) {
        LocalDate data = iddpData.getValue();
        int idH = Integer.parseInt(txtHospede.getText());

        AltData da = new AltData(data, idH);

        if (AltDataDao.cadastrar(da)) {
            System.out.println("Cadastrado!");
        }
    }

    @FXML
    void btnDel(ActionEvent event) {
        int id = Integer.parseInt(idtxtDel.getText());

        DelQuartos qua = new DelQuartos(id);

        if (DelHospedesDao.cadastrar(qua)) {
            System.out.println("Cadastrado!");
        }
    }

    @FXML
    void btnEmail(ActionEvent event) {
        String email = txtEmail.getText();
        int idH = Integer.parseInt(txtHospede.getText());

        AltEmail em = new AltEmail(email, idH);

        if (AltEmailDao.cadastrar(em)) {
            System.out.println("Cadastrado!");
        }
    }

    @FXML
    void btnNome(ActionEvent event) {
        String Nome = txtNome.getText();
        int idH = Integer.parseInt(txtHospede.getText());

        AltNome ALT = new AltNome(Nome, idH);

        if (AltNomeDao.cadastrar(ALT)) {
            System.out.println("Cadastrado!");
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
        String te = TxtTel.getText();
        int idH = Integer.parseInt(txtHospede.getText());

        AltTel tel = new AltTel(te, idH);

        if (AltTelDao.cadastrar(tel)) {
            System.out.println("Cadastrado!");
        }
    }

}
