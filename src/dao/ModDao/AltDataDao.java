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

public class AltDataDao {
    
     public static boolean cadastrar(AltData dat){

        String sql;
        sql = "update hospede set dtNasc = ? where idHospede = ?";
   

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setObject(1, dat.getData());
            ps.setInt(2, dat.getIdH());


            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
