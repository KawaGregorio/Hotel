package model;

public class AltQuartos {
    private int idHosp;
    private String Disp;
    private int ID;

    public AltQuartos(int idHosp, String disp, int iD) {
        this.idHosp = idHosp;
        Disp = disp;
        ID = iD;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getIdHosp() {
        return idHosp;
    }
    public void setIdHosp(int idHosp) {
        this.idHosp = idHosp;
    }
    public String getDisp() {
        return Disp;
    }
    public void setDisp(String disp) {
        Disp = disp;
    }


}
