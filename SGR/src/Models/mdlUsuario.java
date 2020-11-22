package Models;

public class mdlUsuario {

    private String nombre;
    private String password;

    public mdlUsuario(String nombre, String password){
        this.nombre = nombre;
        this.password = password;

    }

    public String  getNombre(){
        return nombre;
    }

    public String getPassword(){
        return password;
    }

}
