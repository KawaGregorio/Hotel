package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.Login;

public class ConfirmarLogin {
    
     public static boolean cadastrar(Login log){

        String sql;
        sql = "SELECT * FROM funcionario WHERE nomeUsuario = ? AND senhaFunc = ?";
   

        try (Connection con = ConexaoMySql.getConexao()) {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, log.getUser());
            ps.setString(2, log.getSenha());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: "+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
