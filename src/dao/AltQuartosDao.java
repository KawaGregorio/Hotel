package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.AddQuartos;
import model.AltQuartos;
import model.DelQuartos;
import model.Reserva;

public class AltQuartosDao {
    
     public static boolean cadastrar(AltQuartos ALT){

        String sql;
        sql = "update quartos set Disponibilidade = ?, idHospede = ? where idQuartos = ?";
   

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ALT.getDisp());
            ps.setInt(2, ALT.getIdHosp());
            ps.setInt(3, ALT.getID());


            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
