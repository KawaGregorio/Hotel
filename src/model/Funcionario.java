package model;

import java.time.LocalDate;

public class Funcionario {
    private int idFuncionario;
    private String nomeUsuario;
    private String nome_Completo;
    private String e_mailFuncionario;
    private int cpf;
    private String senhaFunc;
    private LocalDate dtNasc;
    private String telefone_Func;


    


    public Funcionario(int id, String usuario, String nomeCom, String emailFunc, int cpf, String senhaFunc, LocalDate dtNasc, String telFunc) {
        this.idFuncionario = id;
        this.nomeUsuario = usuario;
        this.nome_Completo = nomeCom;
        this.e_mailFuncionario = emailFunc;
        this.cpf = cpf;
        this.senhaFunc = senhaFunc;
        this.dtNasc = dtNasc;
        this.telefone_Func = telFunc;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getNome_Completo() {
        return nome_Completo;
    }
    public void setNome_Completo(String nome_Completo) {
        this.nome_Completo = nome_Completo;
    }
    public String getE_mailFuncionario() {
        return e_mailFuncionario;
    }
    public void setE_mailFuncionario(String e_mailFuncionario) {
        this.e_mailFuncionario = e_mailFuncionario;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getSenhaFunc() {
        return senhaFunc;
    }
    public void setSenhaFunc(String senhaFunc) {
        this.senhaFunc = senhaFunc;
    }
    public LocalDate getDtNasc() {
        return dtNasc;
    }
    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }
    public String getTelefone_Func() {
        return telefone_Func;
    }
    public void setTelefone_Func(String telefone_Func) {
        this.telefone_Func = telefone_Func;
    }


}
