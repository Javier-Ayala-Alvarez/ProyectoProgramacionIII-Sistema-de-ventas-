/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import static java.lang.System.out;
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
import modelo.dao.RegistrosDao;
import modelo.dao.VentaDao;
import modelo.entidades.Cliente;
import modelo.entidades.Registros;
import modelo.entidades.Venta;
import org.json.simple.JSONArray;

/**
 *
 * @author Francisco Javier
 */
@WebServlet(name = "ControlCliente", urlPatterns = {"/ControlCliente"})
public class ControlCliente extends HttpServlet {

    private ArrayList<Cliente> registroList1;
    private Cliente registroList;
    private ClienteDao daoCliente;
    Cliente cliente;

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
        if (request.getParameter("btn_agregar") != null) {
            
            try {
                
                this.daoCliente = new ClienteDao();// 
                
                this.registroList = daoCliente.getMax();
                int id = registroList.getMax() + 1;;
                cliente = new Cliente(id, crearCodigo("CE-", id), request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("apellido"), request.getParameter("direccion"));
                daoCliente.insert(cliente);
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if ((!request.getParameter("btn").isEmpty())) {
            this.daoCliente = new ClienteDao();
            this.registroList1 = new ArrayList();
            try {
                response.setContentType( "text/html; charset=iso-8859-1" );
                PrintWriter out1 =  response.getWriter();
                this.registroList1 = daoCliente.getSelect();
                out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
                out1.println("<table  class='table is-fullwidth' >");
                out1.println("<TR bgcolor='#3EB429' ><TD>");
                out1.println("<H4 ><font color='#FFF'>CODIGO<TD>");
                out1.println("<H4><font color='#FFF'>NOMBRE<TD>");
                out1.println("<H4><font color='#FFF'>APELLIDO<TD>");
                out1.println(" <H4><font color='#FFF'>TELEFONO<TD>");
                out1.println(" <H4><font color='#FFF'>DIRECCION<TD>");
                out1.println("  <H4><font color='#FFF'>SELECCIONAR</TD><tr>");
                for (Cliente registro : registroList1) {
                 out1.println("<tr><td>" + registro.getCodigoCliente() + "</td>");
                out1.println("<td>"+registro.getNombre()+"</td>");
                out1.println("<td>"+registro.getApellido()+"</td>");
                out1.println("<td>"+registro.getTelefono()+"</td>");
                out1.println("<td>"+registro.getDireccion()+"</td>");
                 out1.println("<td></button><button class='button is-link is-outlined is-small'> <a href='javascript:abrirProducto()'><img src='img/agregarFact.png'/></a></button>");
                out1.println("</button><button class='button is-danger is-outlined is-small'> <a href='javascript:abrirProducto()'><img src='img/basurero.png'/></a></button></td>");
                
                }
                out1.print("</tr>");
                out1.print("</table>");
            
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

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
    public void mostrar(){
    
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
