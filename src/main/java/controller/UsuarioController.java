package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import com.google.gson.Gson;
import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {
    
    @Override
    public String login (int id_usuario, String contrasena_usuario){
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where id_usuario = " + id_usuario + " and contrasena_usuario = '" + contrasena_usuario + "'";
        
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String nombre_usuario=rs.getString("nombre_usuario");
                String apellido_usuario=rs.getString("apellido_usuario");
                String email=rs.getString("email");
                String telefono_usuario=rs.getString("telefono_usuario");
                String direccion_usuario=rs.getString("direccion_usuario");
                String comuna_usuario=rs.getString("comuna_usuario");
                String ciudad_usuario=rs.getString("ciudad_usuario"); 
                
                
                Usuario usuario = new Usuario(id_usuario, contrasena_usuario, nombre_usuario, apellido_usuario, email, telefono_usuario, direccion_usuario, comuna_usuario, ciudad_usuario);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
        return "false";
    }
    
    @Override
    
    public String register(int id_usuario, String contrasena_usuario, String nombre_usuario, String apellido_usuario, String email, String telefono_usuario, String direccion_usuario, String comuna_usuario, String ciudad_usuario){
        
        Gson gson = new Gson();
    
    DBConnection con = new DBConnection();
    String sql = "Insert into usuario values("+ id_usuario + ",'" + contrasena_usuario + "', '" + nombre_usuario + "', '" + apellido_usuario + "', '" + email + "', " + telefono_usuario + ", " + direccion_usuario + ", " + comuna_usuario + ",'" + ciudad_usuario + ")";
    
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
            Usuario usuario = new Usuario(id_usuario, contrasena_usuario, nombre_usuario, apellido_usuario, email, telefono_usuario, direccion_usuario, comuna_usuario, ciudad_usuario);
            
            st.close();
            
            return gson.toJson(usuario);
            
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
            
        }finally{
            con.desconectar();
        
        }
        
        return "false";
    }
}