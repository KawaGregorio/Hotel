package model;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private int Num_Quarto;
    private LocalDate Checkin;
    private LocalDate Checkout;
    private double preco;
    private String Form_Pagt;
    private int idHospede;

    

    public Reserva(int id, int Quarto, LocalDate checkin, LocalDate checkout, double preco, String form_Pagt,
            int idHosp) {
        this.idReserva = id;
        Num_Quarto = Quarto;
        Checkin = checkin;
        Checkout = checkout;
        this.preco = preco;
        Form_Pagt = form_Pagt;
        this.idHospede = idHosp;
    }

    public int getNum_Quarto() {
        return Num_Quarto;
    }
    public void setNum_Quarto(int num_Quarto) {
        Num_Quarto = num_Quarto;
    }
    public LocalDate getCheckin() {
        return Checkin;
    }
    public void setCheckin(LocalDate checkin) {
        Checkin = checkin;
    }
    public LocalDate getCheckout() {
        return Checkout;
    }
    public void setCheckout(LocalDate checkout) {
        Checkout = checkout;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getForm_Pagt() {
        return Form_Pagt;
    }
    public void setForm_Pagt(String form_Pagt) {
        Form_Pagt = form_Pagt;
    }
    public int getIdHospede() {
        return idHospede;
    }
    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

}
