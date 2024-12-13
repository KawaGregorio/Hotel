package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.Funcionario;
import model.Hospede;

public class HospedeDao {
    

    public static boolean cadastrar(Hospede hospede){

        String sql;
        sql = "INSERT INTO Hospede (nome_Completo, e_mailHospede, cpf, dtNasc, telefone_Hosp)";
        sql += "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, hospede.getNome_completo());
            ps.setString(2, hospede.getE_mailHospede());
            ps.setInt(3, hospede.getCpf());
            ps.setObject(4, hospede.getDtNasc());
            ps.setString(5, hospede.getTelefone_Hosp());

            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
