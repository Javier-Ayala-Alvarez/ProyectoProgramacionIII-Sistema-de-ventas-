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
import modelo.entidades.Cliente;

@WebServlet(name = "ControlCliente", urlPatterns = {"/ControlCliente"})
public class ControlCliente extends HttpServlet {

    private ArrayList<Cliente> registroList1;
    private Cliente registroList;
    private ClienteDao daoCliente;
    Cliente cliente;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.daoCliente = new ClienteDao();// 
        this.registroList = new Cliente();
        PrintWriter out1 = response.getWriter();
        String nombre = "", apellido = "", telefono = "", direccion = "", valor = "Nuevo", id1 = "btn_agregar";
        out1.println("<script src=https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js></script><script src=Ajax1.js></script> ");
        if (request.getParameter("btn_agregar") != null) {
            //ControlCliente: agregar un nuevo cliente//
            try {

                this.registroList = daoCliente.getMax();
                int id = registroList.getMax() + 1;
                cliente = new Cliente(id, crearCodigo("CE-", id), request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("telefono"), request.getParameter("direccion"));
                if ((daoCliente.insert(cliente)) == true) {

         if ((daoCliente.getSelectToTelefono(request.getParameter("telefono"))) == true) {
                        out1.println("<script>alert('Insertado Correctamente, Hacer clic en recargar'); </script>");

                    } else {
                       out1.println("<script>alert('Numero ya registrado'); </script>");
                    }
                } else {
                    
                }
            } catch (Exception ex) {
                out1.println("<script>alert('Numero ya registrado'); </script>");
            }
        }
        if (request.getParameter("event").equals("btn_EliminarCliente")) {
            //ControlCliente: Eliminar Un cliente

            if (daoCliente.delete(request.getParameter("Eliminar")) == false) {
                out1.println("<script>alert('Cliente tiene asignada una factura (no se puede eliminar)'); </script>");
            } else {
                out1.println("<script>alert('Eliminado con exito'); </script>");
            }

        }
        if (request.getParameter("event").equals("ModificarCliente")) {
            //ControlCliente: Modificar Un cliente
            try {
                this.registroList = daoCliente.getSelectTo(request.getParameter("ModificarClien"));
                registroList.setIdCliente(registroList.getIdCliente());
                registroList.setCodigoCliente(request.getParameter("ModificarClien"));
                registroList.setNombre(request.getParameter("nombre"));
                registroList.setApellido(request.getParameter("apellido"));
                registroList.setTelefono(request.getParameter("telefono"));
                registroList.setDireccion(request.getParameter("direccion"));
                daoCliente.update(registroList);
            } catch (SQLException ex) {
                out1.println("<script>alert('Se produjo un error intente Nuevamente'); </script>");
            }

        }

        if (request.getParameter("event").equals("Cambiarnombre")) {
            //ControlCliente: resetiar datos;
            try {
                this.registroList = daoCliente.getSelectTo(request.getParameter("Modificar"));
                nombre = registroList.getNombre();
                apellido = registroList.getApellido();
                telefono = registroList.getTelefono();
                direccion = registroList.getDireccion();
                id1 = "btn_modificarCliente1";
                valor = "Modificar";
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Factura: Mostrar Datos

        out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
        out1.println("<form name='Cliente' method='post'><div class='columns'>");
        out1.println(" <div class='column'>");
        out1.println("NOMBRE:<input type='text'  name='nombre' placeholder='nombre' id='nombreClien' class='input is-link' pattern='[A-Za-z]+' value='" + nombre + "' required/ > </div> <div class='column'>");
        out1.println("APELLIDO:<input type='text'  name='apellido' placeholder='Telefono' id='apellidoClien' value='" + apellido + "' class='input is-link' pattern='[A-Za-z]+'  required/> </div> </div>  <div class='columns'>");
        out1.println("<div class='column'>TELEFONO:<input type='text'  name='telefono' id='telefonoClien' placeholder='Telefono' value='" + telefono + "' class='input is-link' pattern='[0-9]+' minlength='8' maxlength='8' required/> </div> <div class='column'>");
        out1.println("DIRECCI??N:<input type='text'  name='direccion' placeholder='Direccion' id='direccionClien' class='input is-link' value='" + direccion + "' required/> </div> <div class='column is-one-third'>");
        out1.println("AGREGAR<input type='submit' name='btn_agregar' value='" + valor + "' id='" + id1 + "' class='button is-link is-active is-fullwidth'></form> </div> </div>");
//Factura: Mostrar Datos
        this.daoCliente = new ClienteDao();
        this.registroList1 = new ArrayList();
        try {

            this.registroList1 = daoCliente.getSelect();

            out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
            out1.println("<table  class='table is-fullwidth' >");
            out1.println("<TR><TD  colspan='6'>REGISTROS DE CLIENTE</TD></TR>");
            out1.println("<TR bgcolor='#3EB429' ><TD>");
            out1.println("<H4 ><font color='#FFF'>CODIG??<TD>");
            out1.println("<H4><font color='#FFF'>NOMBRE<TD>");
            out1.println("<H4><font color='#FFF'>APELLIDO<TD>");
            out1.println(" <H4><font color='#FFF'>TEL??FONO<TD>");
            out1.println(" <H4><font color='#FFF'>DIRECCI??N<TD>");
            out1.println("  <H4><font color='#FFF'>SELECCIONAR</TD>");
            for (Cliente registro : registroList1) {
                out1.println("<tr id='regisCliente'><td>" + registro.getCodigoCliente() + "</td>");
                out1.println("<td>" + registro.getNombre() + "</td>");
                out1.println("<td>" + registro.getApellido() + "</td>");
                out1.println("<td>" + registro.getTelefono() + "</td>");
                out1.println("<td>" + registro.getDireccion() + "</td>");
                out1.println("<td></button><button class='button is-link is-outlined is-small agregarCliente'  value=" + registro.getCodigoCliente() + "> <img src='img/agregarFact.png' /></a></button>");
                out1.println("</button><button class='button is-success is-outlined is-small btn_ModificarClienta'  value=" + registro.getCodigoCliente() + "> <img src='img/modificar.png' /></a></button>");
                out1.println("</button><button class='button is-danger is-outlined is-small btn_Eliminar' > <img src='img/basurero.png' /></a></button></td>");

            }
            out1.print("</tr>");
            out1.print("</table>");

        } catch (SQLException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
///Crear Codigo

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
