package Controllers;

import Models.*;
import java.util.ArrayList;

public class UsuarioController {
    private ArrayList<mdlUsuario> listaUsuarios;

    public UsuarioController(){
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new mdlUsuario("admin", "admin"));
    }
    
    public boolean esUsuario(mdlUsuario usuario){
        for (mdlUsuario user : listaUsuarios) {
            if(user.getNombre().equals(usuario.getNombre()) && user.getPassword().equals(usuario.getPassword())){
                return true;
            }
        };

        return false;
    }
}
