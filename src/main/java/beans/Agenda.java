package beans;


public class Agenda {
    
    private String fechaHora_servicio;
    private int id_usuario;
    private int id_servicio;
    private String nombre_servicio;

    public Agenda(String fechaHora_servicio, int id_usuario, int id_servicio, String nombre_servicio) {
        this.fechaHora_servicio = fechaHora_servicio;
        this.id_usuario = id_usuario;
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
    }

    public String getFechaHora_servicio() {
        return fechaHora_servicio;
    }

    public void setFechaHora_servicio(String fechaHora_servicio) {
        this.fechaHora_servicio = fechaHora_servicio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    @Override
    public String toString() {
        return "Agenda{" + "fechaHora_servicio=" + fechaHora_servicio + ", id_usuario=" + id_usuario + ", id_servicio=" + id_servicio + ", nombre_servicio=" + nombre_servicio + '}';
    }
    
    

   
    
    
    
}
