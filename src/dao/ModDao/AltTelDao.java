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
import model.Mod.AltData;
import model.Mod.AltNome;
import model.Mod.AltTel;

public class AltTelDao {
    
     public static boolean cadastrar(AltTel tel){

        String sql;
        sql = "update hospede set telefone_Hosp = ? where idHospede = ?";
   

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, tel.getTel());
            ps.setInt(2, tel.getIdH());


            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
