package controller;

import beans.Agenda;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AgendaController implements IAgendaController{
    
    @Override
    public String register(String fecha_servicio,int id_usuario, int id_servicio,String nombre_servicio) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        
        String sql = "Insert into agenda values('" + fecha_servicio + "'," + id_usuario + ", " + id_servicio+ ");";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Agenda agenda = new Agenda(fecha_servicio, id_usuario,id_servicio,nombre_servicio);

            st.close();

            return gson.toJson(agenda);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
    
    @Override
    public String listarReservas(int id_usuario) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "SELECT l.fecha_servicio, l.id_usuario,a.nombre_servicio,l.id_servicio FROM agenda l INNER JOIN servicio a ON l.id_servicio = a.id_servicio INNER JOIN"
                + " usuario u ON l.id_usuario = u.id_usuario WHERE l.id_usuario =" + id_usuario +";";

        List<String> reservas = new ArrayList<>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Timestamp fechaTime = rs.getTimestamp("fecha_servicio");
                String fecha_servicio = fechaTime.toString();
                String nombre_servicio = rs.getString("nombre_servicio");
                int id_servicio = rs.getInt("id_servicio");

                Agenda agenda = new Agenda(fecha_servicio,id_usuario,id_servicio,nombre_servicio);

                reservas.add(gson.toJson(agenda));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(reservas);
    }
}
