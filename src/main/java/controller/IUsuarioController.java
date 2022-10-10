package controller;
import java.util.Map;

public interface IUsuarioController {
    public String login (int id_usuario, String contrasena_usuario);  
    
    public String register (int id_usuario, String contrasena_usuario, String nombre_usuario, String apellido_usuario, String email, String telefono_usuario, String direccion_usuario, String ciudad_usuario, String comuna_usuario);
}
