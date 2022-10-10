
package controller;


public interface IAgendaController {
    
   public String register(String fecha_servicio,int id_usuario, int id_servicio, String nombre_servicio);
    
   public String listarReservas(int id_usuario); 
    
}
