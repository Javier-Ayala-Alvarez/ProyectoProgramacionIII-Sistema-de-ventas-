package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ClienteDao;
import modelo.entidades.Cliente;

@WebServlet(name = "ControlSeleccionarCDE", urlPatterns = {"/ControlSeleccionarCDE"})
public class ControlSeleccionarCDE extends HttpServlet {

    private Cliente registroList;
    private ClienteDao daoCliente;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.daoCliente = new ClienteDao();//
        this.registroList = new Cliente();
        PrintWriter out1 = response.getWriter();
        try (PrintWriter out = response.getWriter()) {

            try {
                String nombre = "";
                if (!request.getParameter("codigo").equals("0")) {
                    this.registroList = daoCliente.getSelectTo(request.getParameter("codigo"));
                    nombre = registroList.getNombre();
                    //ControladorProductos: Mostrara el encabezado de la factura
                }

                out1.println("<script src=https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js></script><script src=Ajax1.js></script> ");
                out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
                out1.println(" <div class='column is-one-third'><table class='TABLE1'><tr><td>");
                out1.println("Codigó Cliente:</td><td><input type='text'  name='codigopro' id='codigoCliente' value='" + request.getParameter("codigo") + "' class='input is-link'readonly /></td><td>"
                        + "<button class='button is-success is-active btn_Cliente1'><a href='javascript:abrirCliente()'><font color='#fff'>Buscar</a></button></td>"
                        + "<td><div class='column is-one-third'>Cliente:</td><td><input type='text'  name='nombreCliente' id='nombreCliente' value='" + nombre + "'  class='input is-link'readonly /></td><td>");
                
            } catch (SQLException ex) {

            }

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
