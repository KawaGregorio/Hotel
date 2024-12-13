package model;

public class Login {
    private String User;
    private String Senha;

    public Login(String user, String senha) {
        User = user;
        Senha = senha;
    }
    
    public String getUser() {
        return User;
    }
    public void setUser(String user) {
        User = user;
    }
    public String getSenha() {
        return Senha;
    }
    public void setSenha(String senha) {
        Senha = senha;
    }

    
}
