package model.Mod;

import java.time.LocalDate;

public class AltData {
    private LocalDate data;
    private int idH;

    public AltData(LocalDate data, int idH) {
        this.data = data;
        this.idH = idH;
    }
    
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public int getIdH() {
        return idH;
    }
    public void setIdH(int idH) {
        this.idH = idH;
    }
}
