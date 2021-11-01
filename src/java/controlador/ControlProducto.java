package controlador;

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

import modelo.dao.DaoProducto;

import modelo.entidades.Producto;

@WebServlet(urlPatterns = {"/ControlProducto"})
public class ControlProducto extends HttpServlet {

    private ArrayList<Producto> registroList;
    private DaoProducto daoProducto;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            if ((!request.getParameter("btn").isEmpty())) {
                //Factura: Mostrar los registros de productos
                this.daoProducto = new DaoProducto();
                this.registroList = new ArrayList();
                response.setContentType("text/html; charset=iso-8859-1");
                PrintWriter out1 = response.getWriter();

                    registroList.clear();
                    if (!request.getParameter("dato").equals("")&&!request.getParameter("dato").equals("null")) {
                        this.registroList = daoProducto.buscar(request.getParameter("dato"));
                    } else {
                        this.registroList = daoProducto.getSelect();
                    }

                    if (registroList.get(0).equals(null)) {
                        this.registroList = daoProducto.getSelect();
                    }
                
                String dato = request.getParameter("dato");
                if(request.getParameter("dato").equals("null")){
                dato="";
                }
                out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
                out1.println("<script src=https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js></script><script src=Ajax1.js></script> ");
                out1.println("<div class='columns'><div class='column'>Buscar:<input type='text'  name='filtrar' id='filtrar' value='"+dato+"'class='input is-link filtrar' autofocus/></td>");
                out1.println("<div class='column'><table  class='table is-fullwidth' >");
                out1.println("<TR bgcolor='#3EB429' ><TD>");
                out1.println("<H4 ><font color='#FFF'>CODIGÓ<TD>");
                out1.println("<H4><font color='#FFF'>PRODUCTO<TD>");
                out1.println("<H4><font color='#FFF'>PRECIO<TD>");
                out1.println(" <H4><font color='#FFF'>CANTIDAD<TD>");
                out1.println("  <H4><font color='#FFF'>SELECCIONAR</TD><tr>");
                for (Producto registro : registroList) {
                    out1.println("<tr><td>" + registro.getCodigoProducto() + "</td>");
                    out1.println("<td>" + registro.getNombreProducto() + "</td>");
                    out1.println("<td>" + String.format("%.2f", registro.getPrecioVenta()) + "</td>");
                    out1.println("<td>" + registro.getCantidad() + "</td>");

                    out1.println("<td><button class='button is-link is-outlined agregarProducto'>AGREGAR</button>");

                }
                out1.print("</tr>");
                out1.print("</table></div></div>");

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
