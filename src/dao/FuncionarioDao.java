package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.Funcionario;

public class FuncionarioDao {
    

    public static boolean cadastrar(Funcionario funcionario){

        String sql;
        sql = "INSERT INTO Funcionario (nomeUsuario, nome_Completo, e_mailFuncionario, cpf, senhaFunc, dtNasc, telefone_Func)";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, funcionario.getNomeUsuario());
            ps.setString(2, funcionario.getNome_Completo());
            ps.setString(3, funcionario.getE_mailFuncionario());
            ps.setInt(4, funcionario.getCpf());
            ps.setString(5, funcionario.getSenhaFunc());
            ps.setObject(6, funcionario.getDtNasc());
            ps.setString(7, funcionario.getTelefone_Func());

            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
