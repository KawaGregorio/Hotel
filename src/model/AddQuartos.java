package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConexaoMySql;

public class AddQuartos {
    private int idQuarto;
    private int Num_Quarto;
    private String Disp;
    private double Preco;
    private int idHosp;

    public AddQuartos(int idQuarto, int num_Quarto, String disp, double preco, int idHosp) {
        this.idQuarto = idQuarto;
        Num_Quarto = num_Quarto;
        Disp = disp;
        Preco = preco;
        this.idHosp = idHosp;
    }

    public AddQuartos(){

    }
    
    public int getIdQuarto() {
        return idQuarto;
    }
    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }
    public int getNum_Quarto() {
        return Num_Quarto;
    }
    public void setNum_Quarto(int num_Quarto) {
        Num_Quarto = num_Quarto;
    }
    public String getDisp() {
        return Disp;
    }
    public void setDisp(String disp) {
        Disp = disp;
    }
    public double getPreco() {
        return Preco;
    }
    public void setPreco(double preco) {
        Preco = preco;
    }
    public int getIdHosp() {
        return idHosp;
    }
    public void setIdHosp(int idHosp) {
        this.idHosp = idHosp;
    }

    public static List<AddQuartos> listar(){
            List<AddQuartos> lista = new ArrayList<AddQuartos>();

            String sql = "SELECT * FROM Quartos";

            try(Connection con = ConexaoMySql.getConexao()){
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    AddQuartos qua = new AddQuartos();

                    qua.setIdQuarto(rs.getInt("idQuartos"));
                    qua.setNum_Quarto(rs.getInt("Numero_Quarto"));
                    qua.setDisp(rs.getString("Disponibilidade"));
                    qua.setPreco(rs.getDouble("Preco"));
                    qua.setIdHosp(rs.getInt("idHospede"));

                    lista.add(qua);
                }
                return lista;
            }catch(SQLException erro){
                System.out.println("ERRO: "+ erro.getMessage());
                return null;
            }
    }
}
