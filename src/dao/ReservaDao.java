package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.Reserva;

public class ReservaDao {
    
     public static boolean cadastrar(Reserva reserva){

        String sql;
        sql = "INSERT INTO Reserva (Num_Quarto, Data_Checkin, Data_Checkout, pagamento, Form_Pagt, idHospede)";
        sql += "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, reserva.getNum_Quarto());
            ps.setObject(2, reserva.getCheckin());
            ps.setObject(3, reserva.getCheckout());
            ps.setDouble(4, reserva.getPreco());
            ps.setString(5, reserva.getForm_Pagt());
            ps.setInt(6, reserva.getIdHospede());

            return (ps.executeUpdate()>0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            return false;
        }
    }
}
