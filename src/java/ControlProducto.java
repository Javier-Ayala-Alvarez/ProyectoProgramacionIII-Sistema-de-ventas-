/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.ControlCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ClienteDao;
import modelo.dao.DaoProducto;
import modelo.entidades.Cliente;
import modelo.entidades.Producto;

/**
 *
 * @author Francisco Javier
 */
@WebServlet(urlPatterns = {"/ControlProducto"})
public class ControlProducto extends HttpServlet {
private ArrayList<Producto> registroList;
    private DaoProducto daoProducto;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
          if ((!request.getParameter("btn").isEmpty())) {
            this.daoProducto = new DaoProducto();
            this.registroList = new ArrayList();
            response.setContentType( "text/html; charset=iso-8859-1" );
            PrintWriter out1 =  response.getWriter();
            this.registroList = daoProducto.getSelect();
            out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
            out1.println("<table  class='table is-fullwidth' >");
            out1.println("<TR bgcolor='#3EB429' ><TD>");
            out1.println("<H4 ><font color='#FFF'>CODIGO<TD>");
            out1.println("<H4><font color='#FFF'>PRODUCTO<TD>");
            out1.println("<H4><font color='#FFF'>PRECIO<TD>");
            out1.println(" <H4><font color='#FFF'>CANTIDAD<TD>");
            out1.println("  <H4><font color='#FFF'>SELECCIONAR</TD><tr>");
            for (Producto registro : registroList) {
                out1.println("<tr><td>" + registro.getCodigoProducto() + "</td>");
                out1.println("<td>"+registro.getNombreProducto()+"</td>");
                out1.println("<td>"+registro.getPrecioVenta()+"</td>");
                out1.println("<td>"+registro.getCantidad()+"</td>");
               
                out1.println("<td></button><button class='button is-link is-outlined '> <a href='javascript:abrirProducto()'>AGREGAR</a></button>");
               
            }
            out1.print("</tr>");
            out1.print("</table>");
            
        }
          } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
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
