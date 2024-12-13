package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.AddQuartos;
import model.Reserva;

public class QuartosDao {
    
     public static boolean cadastrar(AddQuartos quartos){

        String sql;
        sql = "INSERT INTO Quartos (Numero_Quarto, Disponibilidade, Preco, idHospede)";
        sql += "VALUES (?, ?, ?, ?)";

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, quartos.getNum_Quarto());
            ps.setString(2, quartos.getDisp());
            ps.setDouble(3, quartos.getPreco());
            ps.setInt(4, quartos.getIdHosp());

            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
