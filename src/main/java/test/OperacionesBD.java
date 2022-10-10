package test;
import beans.Servicio;
import beans.Usuario;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
    public static void main(String[] args) {
        
        listarServicio();
        listarUsuario();
    }
    public static void actualizarServicio(int id_servicio, String nombre_servicio){
        DBConnection con = new DBConnection();
        String sql = "UPDATE servicio SET nombre_servicio= '"+nombre_servicio+"'WHERE id_servicio"+id_servicio;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.desconectar();
        }
    
    }
    public static void listarServicio(){
    DBConnection con = new DBConnection();
        String sql = "SELECT * FROM servicio";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id_servicio=rs.getInt("id_servicio");
                String nombre_servicio=rs.getString("nombre_servicio");
                Double costo_servicio=rs.getDouble("costo_servicio");
                String duracion=rs.getString("duracion");
                String nombre_empleado=rs.getString("nombre_empleado");
                int valoracion_servicio=rs.getInt("valoracion_servicio");
                Servicio servicios = new Servicio(id_servicio, nombre_servicio, costo_servicio, duracion, nombre_empleado, valoracion_servicio);
                System.out.println(servicios.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.desconectar();
        }
    }
    
    public static void listarUsuario(){
    
    DBConnection con = new DBConnection();
        String sql = "SELECT * FROM usuario";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id_usuario=rs.getInt("id_usuario");
                String contrasena_usuario=rs.getString("contrasena_usuario");
                String nombre_usuario=rs.getString("nombre_usuario");
                String apellido_usuario=rs.getString("apellido_usuario");
                String email=rs.getString("email");
                String telefono_usuario=rs.getString("telefono_usuario");
                String direccion_usuario=rs.getString("direccion_usuario");
                String comuna_usuario=rs.getString("comuna_usuario");
                String ciudad_usuario=rs.getString("ciudad_usuario");
                Usuario usuarios = new Usuario(id_usuario, contrasena_usuario, nombre_usuario, apellido_usuario, email, telefono_usuario, direccion_usuario, comuna_usuario, ciudad_usuario);
                System.out.println(usuarios.toString());
                      
            }
            st.executeQuery(sql);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
    }
    
    
}
