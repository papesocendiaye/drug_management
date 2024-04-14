package esp.dstib.drugmanagement.model;

public class Credencial {

    int id;
    private String login;
    private String password;
    
    public Credencial () {
    }
    public String getLogin() { 
        return login;
    }
    public int getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public void setLogin(String login) { 
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(int id) {
        this.id = id;
    }


    public Credencial (String login , String password){
        this.login = login;
        this.password = password;
    }
    public Credencial (int id,String login , String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }
}
