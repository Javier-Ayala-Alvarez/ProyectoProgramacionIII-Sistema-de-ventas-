/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Francisco Javier
 */
@WebServlet(name = "ControlRegistro", urlPatterns = {"/ControlRegistro"})
public class ControlRegistro extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            if ((!request.getParameter("btn").isEmpty())) {
                if (request.getParameter("event").equals("3")) {
                    response.setContentType("text/html; charset=iso-8859-1");
                    PrintWriter out1 = response.getWriter();
                    out1.println("<div class='column'> <div class='TABLE3'> <table  class='table is-fullwidth'> <TR><TD bgcolor='#3EB429> <H4 ><font color='#fff'>N°<TD bgcolor='#3EB429' >"
                            + "<H4 ><font color='#fff'>CODIGO<TD bgcolor='#3EB429' > <H4><font color='#fff'>PRODUCTO<TD bgcolor='#3EB429' ><H4><font color='#fff'>PRECIO<TD bgcolor='#3EB429' >"
                            + "<H4><font color='#fff'>CANTIDAD<TD bgcolor='#3EB429' > <H4><font color='#fff'>TOTAL</TD><TD bgcolor='#3EB429' ><H4><font color='#fff'>OPCCIONES</TD><tr>");
                    out1.println("<td align='center'>  4 </td>");
                    out1.println("<td align='center'>  4 </td>");
                    out1.println("<td align='center'>  4 </td>");
                    out1.println("<td align='center'>  4 </td>");
                    out1.println("<td align='center'>  4 </td>");
                    out1.println("<td align='center'>  4 </td>");

                    out1.println("<td align='center'> <button class='button is-danger is-outlined'><a href='javascript:abrirProducto()'>Eliminar</a></button>'</td></table>  </div>  </div>");
                    out1.println("<!-- TOTALES DE LA FACTURA ... -->");
                    out1.println("<div  class='form-register1'>");
                    out1.println("<table><tr><td>");
                    out1.println(" <form>");
                    out1.println("<td><input type='submit' name='ReFactura' value='Facturar' class='button is-link is-active'>");
                    out1.println("<td> <input type = 'submit' name = 'ReFactura' value = 'Cancelar' class='button is-danger'>");
                    out1.println("<td class='column is-one-third'> Total:");
                    out1.println("<td> <input type='text'  name='Usuario' placeholder='Total' class='input is-success'/>");
                    out1.println("</form> </td> </tr> </table>");

                }
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
