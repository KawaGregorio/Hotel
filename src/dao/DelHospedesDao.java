package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.AddQuartos;
import model.DelQuartos;
import model.Reserva;

public class DelHospedesDao {
    
     public static boolean cadastrar(DelQuartos DEL){

        String sql;
        sql = "delete from hospede ";
        sql += "where idHospede = ?;";

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, DEL.getID());

            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
