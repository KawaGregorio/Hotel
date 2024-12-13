package model.Mod;

public class AltNome {
    private String Nome;
    private int idH;

    public AltNome(String nome, int idH) {
        Nome = nome;
        this.idH = idH;
    }

    public int getIdH() {
        return idH;
    }

    public void setIdH(int idH) {
        this.idH = idH;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }


}
