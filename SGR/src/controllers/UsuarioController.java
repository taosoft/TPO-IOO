package Controllers;

import Models.*;
import java.util.ArrayList;

public class UsuarioController {
    private ArrayList<UsuarioModel> listaUsuarios;

    public UsuarioController(){
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new UsuarioModel("admin", "admin"));
    }
    
    public boolean esUsuario(UsuarioModel usuario){
        for (UsuarioModel user : listaUsuarios) {
            if(user.getNombre().equals(usuario.getNombre()) && user.getPassword().equals(usuario.getPassword())){
                return true;
            }
        };

        return false;
    }
}
