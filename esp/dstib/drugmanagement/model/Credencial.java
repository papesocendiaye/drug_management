package esp.dstib.drugmanagement.model;

public class Credencial {

    private String login;
    private String password;
    
    public Credencial () {
    }
    public String getLogin() { 
        return login;
    }
    public String getPassword() {
        return password;
    }


    public Credencial (String login , String password){
        this.login = login;
        this.password = password;
    }
}
