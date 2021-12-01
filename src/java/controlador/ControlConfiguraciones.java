/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.EmpresaDao;
import modelo.entidades.Empresa;

@WebServlet(name = "ControlConfiguraciones", urlPatterns = {"/ControlConfiguraciones"})
public class ControlConfiguraciones extends HttpServlet {
private EmpresaDao daoEmpresa;
    private ArrayList<Empresa> registroList;
     private Empresa registroList1;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.registroList = new ArrayList();
        this.registroList1 = new Empresa();
        
        this.daoEmpresa = new EmpresaDao();
        try (PrintWriter out = response.getWriter()) {
          
            if(request.getParameter("btn_Actualizar") != null){
                this.registroList1 = daoEmpresa.selectAllto(request.getParameter("codigo"));
               registroList1.setIdEmpresa(registroList1.getIdEmpresa());
                registroList1.setCodigoEmpresa(request.getParameter("codigo"));
                registroList1.setNombre(request.getParameter("nombre"));
                registroList1.setCorreo(request.getParameter("correo"));
                registroList1.setDireccion(request.getParameter("direccion"));
                daoEmpresa.update(registroList1);
                
                this.registroList = daoEmpresa.selectAll();
            request.setAttribute("registroList", this.registroList);
           request.getRequestDispatcher("Configuraciones.jsp").forward(request, response);
            
            }
            
            this.registroList = daoEmpresa.selectAll();
            request.setAttribute("registroList", this.registroList);
           request.getRequestDispatcher("Configuraciones.jsp").forward(request, response);
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
