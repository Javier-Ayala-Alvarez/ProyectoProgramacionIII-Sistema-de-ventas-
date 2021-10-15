/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import modelo.dao.RegistrosDao;
import modelo.dao.VentaDao;
import modelo.entidades.Producto;
import modelo.entidades.Registros;
import modelo.entidades.Venta;

/**
 *
 * @author Francisco Javier
 */
@WebServlet(name = "ControlRegistro", urlPatterns = {"/ControlRegistro"})
public class ControlRegistro extends HttpServlet {

    private RegistrosDao daoRegistro;
    private ArrayList<Registros> registroPro;
    private ArrayList<Producto> registrop;
    private Registros registroVenta;
    private Producto registroproduc;
    private DaoProducto daoProducto;
    private VentaDao daoVenta;
    private ArrayList<Venta> ventasList;

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        this.daoRegistro = new RegistrosDao();
        daoProducto = new DaoProducto();
        this.daoVenta = new VentaDao();
        this.ventasList = new ArrayList<>();
        this.registroPro = new ArrayList<>();
        try (PrintWriter out = response.getWriter()) {
            if ((!request.getParameter("btn").isEmpty())) {
                if (request.getParameter("event").equals("3")) {
                    response.setContentType("text/html; charset=iso-8859-1");
                    registroVenta = new Registros();
//                    try {
//                        this.registroproduc = daoProducto.getSelectTo(request.getParameter("codigo"));
//                    } catch (SQLException ex) {
//                        Logger.getLogger(ControlRegistros.class.getName()).log(Level.SEVERE, null, ex);
//                    }
////                    registroVenta.setProducto(registroproduc);
////                    registroVenta.setNombreProducto(request.getParameter("producto"));
////                    registroVenta.setCantidadProducto(Integer.parseInt(request.getParameter("cantidad1")));
////                    registroVenta.setPrecioVentaProducto(Double.parseDouble(request.getParameter("precioUni")));
////                    registroVenta.setPrecioTotalProducto(4);
////                    registroPro.add(registroVenta);
                    PrintWriter out1 = response.getWriter();
                    out1.println("<div class='column'> <div class='TABLE3'> <table  class='table is-fullwidth'> <TR><TD bgcolor='#3EB429> <H4 ><font color='#fff'>N°<TD bgcolor='#3EB429' >"
                            + "<H4 ><font color='#fff'>CODIGO<TD bgcolor='#3EB429' > <H4><font color='#fff'>PRODUCTO<TD bgcolor='#3EB429' ><H4><font color='#fff'>PRECIO<TD bgcolor='#3EB429' >"
                            + "<H4><font color='#fff'>CANTIDAD<TD bgcolor='#3EB429' > <H4><font color='#fff'>TOTAL</TD><TD bgcolor='#3EB429' ><H4><font color='#fff'>OPCCIONES</TD>");

                    this.registroPro = daoRegistro.getRegistros1(1);
                    int i = 0;

                    for (Registros registro : registroPro) {
                        out1.println("<tr><td align='center'>" + i + "</td>");
                        out1.println("<td align='center'>" + registro.getProducto().getCodigoProducto() + "</td>");
                        out1.println("<td align='center'>" + registro.getProducto().getNombreProducto() + "</td>");
                        out1.println("<td align='center'>" + registro.getProducto().getPrecioVenta() + "</td>");
                        out1.println("<td align='center'>" + registro.getCantidadProducto() + "</td>");
                        out1.println("<td align='center'>" + registro.getPrecioTotalProducto() + "</td>");

                        i++;
                        out1.println("<td align='center'> <button class='button is-danger is-outlined btn_EliminarProducto'>Eliminar</a></button>'</td>");
                    }

                    this.ventasList = daoVenta.getVentaTo(1);
                    for (Venta registro : ventasList) {
                    out1.println("</tr></table>  </div>  </div>");
                    out1.println("<!-- TOTALES DE LA FACTURA ... -->");
                    out1.println("<div  class='form-register1'>");
                    out1.println("<table><tr><td>");
                    out1.println(" <form>");
                    out1.println("<td><input type='submit' name='ReFactura' value='Facturar' class='button is-link is-active'>");
                    out1.println("<td> <input type = 'submit' name = 'ReFactura' value = 'Cancelar' class='button is-danger'>");
                    out1.println("<td class='column is-one-third'> Total:");
                    out1.println("<td> <input type='text'  name='Usuario' placeholder='Total' value='" + registro.getSaldoTotal()+ "' class='input is-success'/>");
                    out1.println("</form> </td> </tr> </table>");
                    }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
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
