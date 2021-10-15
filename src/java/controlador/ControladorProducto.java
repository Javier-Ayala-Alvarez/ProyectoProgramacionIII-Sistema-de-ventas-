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
import modelo.dao.ClienteDao;
import modelo.dao.DaoProducto;
import modelo.dao.VentaDao;
import modelo.entidades.Cliente;
import modelo.entidades.Producto;
import modelo.entidades.Venta;

/**
 *
 * @author Francisco Javier
 */
@WebServlet(name = "ControladorProducto", urlPatterns = {"/ControladorProducto"})
public class ControladorProducto extends HttpServlet {

    
    private Producto registroproduc;
    private Producto registroproduc1;
    private DaoProducto daoProducto;
    private Venta venta;
    private VentaDao daoVenta;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.daoProducto = new DaoProducto();//
        this.registroproduc = new Producto();
        this.venta = new Venta();
        this.daoVenta = new VentaDao();

        
            int idCliente, idProducto, id=0;

           
             if (request.getParameter("event").equals("2")) {
                try {
                    this.registroproduc = daoProducto.getSelectTo(request.getParameter("codigoproduc"));
                    idProducto = registroproduc.getIdProducto();

                } catch (SQLException ex) {

                }
            }
          
            double total = 0;
            try {
                this.registroproduc1 = daoProducto.getMax();
                 venta = daoVenta.getSelectMax();
                 id = venta.getMax() + 1;
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            total = Integer.parseInt(request.getParameter("cantidad")) * registroproduc.getPrecioVenta();

            response.setContentType("text/html; charset=iso-8859-1");
            PrintWriter out1 = response.getWriter();
            out1.println("<div  class='form-register'>");
            out1.println("<script src=https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js></script><script src=Ajax1.js></script> ");
            out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
            out1.println("<table><tr ><td><td><td><td><td><td><td><td><td><td><td><td align='center' class='column is-one-third'>N° Factura<td>");
            out1.println("<form  name='Dato'> ");
            
            out1.println("<input type='text'  name='factura' placeholder='Numero Factura' id='factura' value=" + crearCodigo("NF-", id) + " class='input is-success' readonly/>  ");
            out1.println("</td></tr><tr><td class='column is-one-third'>");
            out1.println("Codigo:</td><td><input type='text'  name='codigopro' id='codigopro' class='input is-success codigopro' value=" + registroproduc.getCodigoProducto() + " readonly/></td><td>");
           out1.println("<td class='column is-one-third'>");
            out1.println("Producto:</td><td><input type='text'  name='producto' placeholder='Producto' class='input is-success' value=" + registroproduc.getNombreProducto() + " readonly/></td>");
            out1.println(" <td>");
            out1.println("<button class='button is-success is-active'><a href='javascript:abrirProducto()' id='btn_Producto'>Buscar</a></button></td>");
            out1.println("<td class='column is-one-third'>");
            out1.println(" Cantidad:</td><td> <input type='number'  name='cantidad' value=" + Integer.parseInt(request.getParameter("cantidad")) + " class='input is-success cantidad'/></td>");
            out1.println("<td align='center'>");
            out1.println("Precio Unitario:</td><td> <input type='text'  name='precioUni' placeholder='Precio Unitario' class='input is-success' value=" + registroproduc.getPrecioVenta() + "  readonly/></td>");
            out1.println("<td align='center'>");
            out1.println("Precio Total: </td><td><input type='text'  name='precioTotal' placeholder='Precio Total' value=" + total + " class='input is-success' readonly /></td>");
            out1.println("<td align='center'>");
            out1.println("<input type='submit' name='ReFactura' value='Agregar a Carrito' class='button is-link is-active' id='registrosProduct'></td></tr>");
            out1.println("</form>");
            out1.println("</table>");
            out1.println("</div>");
            
           
        

    }

    public String crearCodigo(String a, int corre) {
        String correlativo = a;
        corre = corre + 1;
        for (int i = 0; i < 6; i++) {
            if ((correlativo.length() + String.valueOf(corre).length()) < 7) {
                correlativo = correlativo + "0";
            }
        }
        correlativo = correlativo + String.valueOf(corre);

        return correlativo;
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
