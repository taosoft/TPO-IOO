package controllers;

import modelos.mdlUsuario;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ctrUsuario {
    private ArrayList<mdlUsuario> listaUsuarios;

    public ctrUsuario(){
        listaUsuarios = new ArrayList<mdlUsuario>();
       
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
