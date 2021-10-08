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
        } else if (request.getParameter("event").equals("1")) {

            daoCliente.delete(request.getParameter("Eliminar"));

        } else if (request.getParameter("event").equals("2")) {
            response.setContentType("text/html; charset=iso-8859-1");
            PrintWriter out1 = response.getWriter();
            out1.println("<script src=http://code.jquery.com/jquery-latest.js></script><script src=Ajax1.js></script> ");
            out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
            out1.println("<form name='Cliente' method='post'><div class='columns'>");
            out1.println(" <div class='column'>");
            out1.println("NOMBRE:<input type='text'  name='nombre' placeholder='Apellido' class='input is-link' pattern='[A-Za-z]+' required/> </div> <div class='column'>");
            out1.println("APELLIDO:<input type='text'  name='apellido' placeholder='Telefono' class='input is-link' pattern='[A-Za-z]+'  required/> </div> </div>  <div class='columns'>");
            out1.println("<div class='column'>TELEFONO:<input type='text'  name='telefono' placeholder='Telefono'  class='input is-link' pattern='[0-9]+' minlength='8' maxlength='8' required/> </div> <div class='column'>");
            out1.println("DIRECCION:<input type='text'  name='direccion' placeholder='Direccion' class='input is-link'  required/> </div> <div class='column is-one-third'>");
            out1.println("AGREGAR<input type='submit' name='btn_agregar' value='Nuevo' id='btn_agregar' class='button is-link is-active is-fullwidth'></form> </div> </div>");
     
        } else if ((!request.getParameter("btn").isEmpty())) {
            this.daoCliente = new ClienteDao();
            this.registroList1 = new ArrayList();
            try {
                response.setContentType("text/html; charset=iso-8859-1");
                PrintWriter out1 = response.getWriter();
                this.registroList1 = daoCliente.getSelect();
                out1.println("<script src=http://code.jquery.com/jquery-latest.js></script><script src=Ajax1.js></script> ");
                out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
                out1.println("<table  class='table is-fullwidth' >");
                out1.println("<TR bgcolor='#3EB429' ><TD>");
                out1.println("<H4 ><font color='#FFF'>CODIGO<TD>");
                out1.println("<H4><font color='#FFF'>NOMBRE<TD>");
                out1.println("<H4><font color='#FFF'>APELLIDO<TD>");
                out1.println(" <H4><font color='#FFF'>TELEFONO<TD>");
                out1.println(" <H4><font color='#FFF'>DIRECCION<TD>");
                out1.println("  <H4><font color='#FFF'>SELECCIONAR</TD>");
                for (Cliente registro : registroList1) {
                    out1.println("<tr><td>" + registro.getCodigoCliente() + "</td>");
                    out1.println("<td>" + registro.getNombre() + "</td>");
                    out1.println("<td>" + registro.getApellido() + "</td>");
                    out1.println("<td>" + registro.getTelefono() + "</td>");
                    out1.println("<td>" + registro.getDireccion() + "</td>");
                    out1.println("<td></button><button class='button is-link is-outlined is-small agregarCliente' id='agregarCliente' value=" + registro.getCodigoCliente() + "> <img src='img/agregarFact.png' /></a></button>");
                    out1.println("</button><button class='button is-danger is-outlined is-small btn_Eliminar' > <img src='img/basurero.png' /></a></button></td>");

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

    public void mostrar() {

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
