package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.UsuarioController;


@WebServlet("/ServletUsuarioRegister")
public class ServletUsuarioRegister extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public ServletUsuarioRegister(){
        
        super();  
    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioController usuario = new UsuarioController();
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        String contrasena_usuario = request.getParameter("contrasena_usuario");
        String nombre_usuario = request.getParameter("nombre_usuario");
        String apellido_usuario = request.getParameter("apellido_usuario");
        String email = request.getParameter("email");
        String telefono_usuario = request.getParameter("telefono_usuario");
        String direccion_usuario = request.getParameter("direccion_usuario");
        String comuna_usuario = request.getParameter("comuna_usuario");
        String ciudad_usuario = request.getParameter("ciudad_usuario");
        
        
        String result = usuario.register(id_usuario, contrasena_usuario, nombre_usuario, apellido_usuario, email, telefono_usuario, direccion_usuario, comuna_usuario, ciudad_usuario);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
