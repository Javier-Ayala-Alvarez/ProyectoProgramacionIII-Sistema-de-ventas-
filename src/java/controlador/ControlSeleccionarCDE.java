/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Francisco Javier
 */
@WebServlet(name = "ControlSeleccionarCDE", urlPatterns = {"/ControlSeleccionarCDE"})
public class ControlSeleccionarCDE extends HttpServlet {

    private Cliente registroList;
    private ClienteDao daoCliente;

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
        this.daoCliente = new ClienteDao();//
        this.registroList = new Cliente();
        PrintWriter out1 = response.getWriter();
        try (PrintWriter out = response.getWriter()) {
            
                try {

                    this.registroList = daoCliente.getSelectTo(request.getParameter("codigo"));
                    //idCliente = registroList.getIdCliente();
                    

                    out1.println("<script src=https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js></script><script src=Ajax1.js></script> ");
                    out1.println("<link rel='stylesheet' type='text/css' href='css/EstiloFactura.css'>");
                    out1.println(" <div class='column is-one-third'><table class='TABLE1'><tr><td>");
                    out1.println("Codigo Cliente:</td><td><input type='text'  name='codigopro' id='codigoCliente' value='"+request.getParameter("codigo")+"' class='input is-link' /></td><td>"
                            + "<div class='column is-one-third'>Cliente:</td><td><input type='text'  name='nombreCliente' id='nombreCliente' value='"+registroList.getNombre()+"' class='input is-link' /></td><td>");
                    out1.println(" <div class='column is-one-third'>");
                    out1.println("Fecha: </td><td><input type='date'  name='fecha' id='fecha' class='input is-link' /></td><td>");
                    out1.println("<div class='column is-one-third'>");
                    out1.println("Codigo Empleado: </td><td><input type='text'  name='codigoEmpleado' id='codigoEmpleado' value='CE0001' class='input is-link' /></td><td></td><td>");
                    out1.println("Empleado:</td><td><input type='text'  name='nombreEmpleado' id='nombreEmpleado' class='input is-link' /></td><td><tr></table></div>");

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
