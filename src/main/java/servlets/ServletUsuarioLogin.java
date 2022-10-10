package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.UsuarioController;

@WebServlet("/ServletUsuarioLogin")
public class ServletUsuarioLogin extends HttpServlet {

        private static final long serialVersionUID = 1L;
        
        public ServletUsuarioLogin(){
            super();   
    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioController usuario = new UsuarioController();
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        String contrasena_usuario = request.getParameter("contrasena_usuario");
        String result = usuario.login(id_usuario, contrasena_usuario);
        
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
