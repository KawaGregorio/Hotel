package dao.ModDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.AddQuartos;
import model.AltQuartos;
import model.DelQuartos;
import model.Reserva;
import model.Mod.AltCPF;
import model.Mod.AltNome;

public class AltCPFDao {
    
     public static boolean cadastrar(AltCPF cpf){

        String sql;
        sql = "update hospede set cpf = ? where idHospede = ?";
   

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cpf.getCpf());
            ps.setInt(2, cpf.getIdH());


            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
