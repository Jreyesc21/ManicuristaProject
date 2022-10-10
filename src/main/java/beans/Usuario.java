package beans;

public class Usuario {
    private int id_usuario;
    private String contrasena_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String email;
    private String telefono_usuario;
    private String direccion_usuario;
    private String comuna_usuario;
    private String ciudad_usuario;
    

    public Usuario(int id_usuario, String contrasena_usuario, String nombre_usuario, String apellido_usuario, String email, String telefono_usuario, String direccion_usuario, String ciudad_usuario, String comuna_usuario) {
        this.id_usuario = id_usuario;
        this.contrasena_usuario = contrasena_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email = email;
        this.telefono_usuario = telefono_usuario;
        this.direccion_usuario = direccion_usuario;
        this.comuna_usuario = comuna_usuario;
        this.ciudad_usuario = ciudad_usuario;
        
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public String getCiudad_usuario() {
        return ciudad_usuario;
    }

    public void setCiudad_usuario(String ciudad_usuario) {
        this.ciudad_usuario = ciudad_usuario;
    }
    
    public String getComuna_usuario(){
        return comuna_usuario;
    }
    
    public void setComuna_usuario(String comuna_usuario){
        this.comuna_usuario = comuna_usuario;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", contrasena_usuario=" + contrasena_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", email=" + email + ", telefono_usuario=" + telefono_usuario + ", direccion_usuario=" + direccion_usuario + ", ciudad_usuario=" + ciudad_usuario + ", comuna_usuario=" + comuna_usuario + '}';
    }
    
    
}
