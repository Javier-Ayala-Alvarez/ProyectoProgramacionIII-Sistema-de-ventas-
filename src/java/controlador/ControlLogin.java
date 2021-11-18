/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.dao.EmpleadoDao;
import modelo.dao.UsuarioDao;
import modelo.entidades.Empleados;
import modelo.entidades.Encriptacion;
import modelo.entidades.Usuario;

@WebServlet(name = "ControlLogin", urlPatterns = {"/ControlLogin"})
public class ControlLogin extends HttpServlet {

    UsuarioDao daoUsuario = new UsuarioDao();
    EmpleadoDao daoEmpleado = new EmpleadoDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            if (request.getParameter("Usuario").isEmpty() && request.getParameter("Clave").isEmpty()) {
                request.setAttribute("alerta", "<script>alert('¡Ambos campos vacíos!'); </script>");
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else if ((request.getParameter("Clave").isEmpty()) || request.getParameter("Usuario").isEmpty()) {
                request.setAttribute("alerta", "<script>alert('¡Ningún campo debe quedar en blanco!'); </script>");
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                ArrayList<Usuario> usuario1 = daoUsuario.selectAllTo("usuario", request.getParameter("Usuario"));
                //String clave = Encriptacion.getStringMessageDigest(request.getParameter("Clave"), Encriptacion.SHA256);
                String clave = request.getParameter("Clave");
                try {
                    usuario1.get(0).AddEpleado1(String.valueOf(usuario1.get(0).getIdUsuario()));

                    if (request.getParameter("Usuario").equals(usuario1.get(0).getUsuario())
                            && clave.equals(usuario1.get(0).getContraseña())
                            && usuario1.get(0).getEmpleados().getCargoEmpleado().equals("Administrador")
                            && usuario1.get(0).getEmpleados().getEstado() == 1) {
                       
                        request.setAttribute("codigo1", request.getParameter("Usuario"));
                        request.getRequestDispatcher("Inicio.jsp").forward(request, response);

                    } else if (request.getParameter("Usuario").equals(usuario1.get(0).getUsuario())
                            && clave.equals(usuario1.get(0).getContraseña())
                            && usuario1.get(0).getEmpleados().getCargoEmpleado().equals("Cajero")
                            && usuario1.get(0).getEmpleados().getEstado() == 1) {

                      
                        request.setAttribute("codigo", request.getParameter("Usuario"));
                        request.getRequestDispatcher("Factura.jsp").forward(request, response);

                    } else {
                        request.setAttribute("alerta", "<script>alert('Datos Incorrectos'); </script>");
                        request.getRequestDispatcher("index.jsp").forward(request, response);

                    }

                } catch (Exception ex) {
                    Empleados emple = daoEmpleado.selectAllUsu();
                    if (request.getParameter("Clave").equals("12345") && (request.getParameter("Usuario").equals("Admin")) && emple == null) {
                        request.setAttribute("codigo1", request.getParameter("Usuario"));
                        request.getRequestDispatcher("Inicio.jsp").forward(request, response);

                    } else {
                        request.setAttribute("alerta", "<script>alert('Datos Incorrectos'); </script>");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }

            }

            //return g;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
