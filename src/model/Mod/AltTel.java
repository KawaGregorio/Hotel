package model.Mod;

public class AltTel {
    private String tel;
    private int idH;

    public AltTel(String tel, int idH) {
        this.tel = tel;
        this.idH = idH;
    }
    
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public int getIdH() {
        return idH;
    }
    public void setIdH(int idH) {
        this.idH = idH;
    }


}
