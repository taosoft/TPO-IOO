package Models;

public class UsuarioModel {

    private String nombre;
    private String password;

    public UsuarioModel(String nombre, String password){
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre(){
        return nombre;
    }

    public String getPassword(){
        return password;
    }
}
