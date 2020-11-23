package Controllers;

import Models.*;
import java.util.ArrayList;

public class UsuarioController {
    private static final UsuarioController INSTANCE = new UsuarioController();

    private ArrayList<UsuarioModel> listaUsuarios;
    
    private UsuarioModel usuarioLoggeado;

    public static UsuarioController getInstance() {
        return INSTANCE;
    }

    private UsuarioController(){
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new UsuarioModel("admin", "admin"));
        listaUsuarios.add(new UsuarioModel("nydia", "nydia"));
        listaUsuarios.add(new UsuarioModel("fede", "fede"));
        listaUsuarios.add(new UsuarioModel("lucho", "lucho"));
        listaUsuarios.add(new UsuarioModel("mati", "mati"));
    }
    
    public boolean esUsuario(UsuarioModel usuario){
        for (UsuarioModel user : listaUsuarios) {
            if(user.getNombre().equals(usuario.getNombre()) && user.getPassword().equals(usuario.getPassword())){
                return true;
            }
        };

        return false;
    }
    
    public UsuarioModel GetUsuarioLoggueado(){
        return usuarioLoggeado;
    }

    public void LoggearUsuario(UsuarioModel usuario) {
        usuarioLoggeado = usuario;
    }

    public void DesloggearUsuario() {
        usuarioLoggeado = null;
    }
}
