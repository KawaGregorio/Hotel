package dao.ModDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.AddQuartos;
import model.AltQuartos;
import model.DelQuartos;
import model.Reserva;
import model.Mod.AltNome;

public class AltNomeDao {
    
     public static boolean cadastrar(AltNome nome){

        String sql;
        sql = "update hospede set nome_Completo = ? where idHospede = ?";
   

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nome.getNome());
            ps.setInt(2, nome.getIdH());


            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
