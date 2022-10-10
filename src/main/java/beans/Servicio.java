package beans;

public class Servicio {
    private int id_servicio;
    private String nombre_servicio;
    private Double costo_servicio;
    private String duracion;
    private String nombre_empleado;
    private int valoracion_servicio;

    public Servicio(int id_usuario, String nombre_servicio, Double costo_servicio, String duracion, String nombre_empleado, int valoracion_servicio) {
        this.id_servicio = id_usuario;
        this.nombre_servicio = nombre_servicio;
        this.costo_servicio = costo_servicio;
        this.duracion = duracion;
        this.nombre_empleado = nombre_empleado;
        this.valoracion_servicio = valoracion_servicio;
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

    public Double getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(Double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public int getValoracion_servicio() {
        return valoracion_servicio;
    }

    public void setValoracion_servicio(int valoracion_servicio) {
        this.valoracion_servicio = valoracion_servicio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id_servicio=" + id_servicio + ", nombre_servicio=" + nombre_servicio + ", costo_servicio=" + costo_servicio + ", duracion=" + duracion + ", nombre_manicurista=" + nombre_empleado + ", valoracion_servicio=" + valoracion_servicio + '}';
    }
    
    
}
