/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.DaoProducto;
import modelo.dao.EmpresaDao;
import modelo.dao.VentaDao;
import modelo.entidades.Empresa;
import modelo.entidades.Producto;

/**
 *
 * @author Francisco Javier
 */
@WebServlet(name = "ControlProductoAdministracion", urlPatterns = {"/ControlProductoAdministracion"})
public class ControlProductoAdministracion extends HttpServlet {

    private DaoProducto daoProducto;
    private ArrayList<Producto> productoList;
    private Producto producto = null;
    private Empresa empresa = null;
    private EmpresaDao daoEmpresa;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=utf-8>");
        this.daoProducto = new DaoProducto();
        this.productoList = new ArrayList<>();
        this.producto = new Producto();
        this.empresa = new Empresa();
        this.daoEmpresa = new EmpresaDao();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            if (request.getParameter("btn_Guardar") != null) {

                if (!request.getParameter("nombre").isEmpty()
                        && !request.getParameter("precioCompra").isEmpty()
                        && !request.getParameter("cantidad").isEmpty()
                        && !request.getParameter("fecha").isEmpty()
                        && !request.getParameter("precioVenta").isEmpty()) {
                    this.producto = daoProducto.getMax();
                    this.empresa = daoEmpresa.select();
                    Producto obj = new Producto(producto.getMax() + 1, crearCodigo("CP-", producto.getMax() + 1),
                            request.getParameter("nombre"), Double.parseDouble(request.getParameter("precioCompra")),
                            Integer.parseInt(request.getParameter("cantidad")), formatter.parse(request.getParameter("fecha")),
                            1, Double.parseDouble(request.getParameter("precioVenta")), empresa);
                    if (daoProducto.insert(obj)) {
                        this.producto = daoProducto.getMax();
                        request.setAttribute("codigo", crearCodigo("CP-", producto.getMax() + 1));
                        this.productoList = daoProducto.getSelect1();

                        request.setAttribute("alerta", "<script>alert('Ingresado Con exito'); </script>");
                        request.setAttribute("productoList", this.productoList);
                        request.getRequestDispatcher("Producto.jsp").forward(request, response);

                    } else {
                        request.setAttribute("alerta", "<script>alert('Campos incorrectos'); </script>");
                    }
                } else {
                    request.setAttribute("alerta", "<script>alert('Campos vacios'); </script>");
                }

            } else if (request.getParameter("btn_Modificar") != null) {
                String codigo = request.getParameter("id");
                this.producto = daoProducto.getSelectTo1(codigo);
                this.productoList = daoProducto.getSelect1();
                request.setAttribute("productoList", this.productoList);
                request.setAttribute("producto", this.producto);
                request.getRequestDispatcher("Producto.jsp").forward(request, response);

            } else if (request.getParameter("btn_Eliminar") != null) {

                String codigo = request.getParameter("id");
                if (daoProducto.delete(codigo)) {
                    request.setAttribute("alerta", "<script>alert('Eliminado Con exito'); </script>");
                } else {
                    request.setAttribute("alerta", "<script>alert('Este producto tiene factura registrada'); </script>");
                }

            } else if (request.getParameter("btn_ModificarRegistros") != null) {

                if (!request.getParameter("nombre").isEmpty()
                        && !request.getParameter("precioCompra").isEmpty()
                        && !request.getParameter("cantidad").isEmpty()
                        && !request.getParameter("fecha").isEmpty()
                        && !request.getParameter("precioVenta").isEmpty()) {
                    String codigo = request.getParameter("codigo");
                    this.producto = daoProducto.getSelectTo1(codigo);

                    producto.setNombreProducto(request.getParameter("nombre"));
                    producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                    producto.setPrecioCompra(Double.parseDouble(request.getParameter("precioCompra")));
                    producto.setPrecioVenta(Double.parseDouble(request.getParameter("precioVenta")));
                    producto.setFechaVencimiento(formatter.parse(request.getParameter("fecha")));

                    if (daoProducto.update(producto)) {
                        this.producto = daoProducto.getMax();
                        this.productoList = daoProducto.getSelect1();
                        request.setAttribute("alerta", "<script>alert('Modificado Con exito'); </script>");
                        request.setAttribute("codigo", crearCodigo("CP-", producto.getMax() + 1));
                        request.setAttribute("productoList", this.productoList);
                        request.getRequestDispatcher("Producto.jsp").forward(request, response);

                    } else {

                        request.setAttribute("alerta", "<script>alert('Se produjo un error'); </script>");
                    }
                }
            } else if (request.getParameter("btn_Aumetar") != null) {
                String codigo = request.getParameter("id");
                this.producto = daoProducto.getSelectTo1(codigo);
                request.setAttribute("producto", this.producto);
                request.getRequestDispatcher("ProductoAmentar.jsp").forward(request, response);

            } else if (request.getParameter("btn_GuardarAumento") != null) {
                if (!request.getParameter("cantidad").isEmpty()
                        && !request.getParameter("precioCompra").isEmpty()) {

                    String codigo = request.getParameter("codigo");
                    this.producto = daoProducto.getSelectTo1(codigo);
                    producto.setCantidad(producto.getCantidad() + Integer.parseInt(request.getParameter("cantidad")));
                    producto.setPrecioCompra((producto.getPrecioCompra() + Double.parseDouble(request.getParameter("precioCompra"))) / 2);

                    if (daoProducto.update(producto)) {
                        this.producto = daoProducto.getMax();
                        this.productoList = daoProducto.getSelect1();
                        request.setAttribute("alerta", "<script>alert('Aunmento Con exito'); </script>");
                        request.setAttribute("codigo", crearCodigo("CP-", producto.getMax() + 1));
                        request.setAttribute("productoList", this.productoList);
                        request.getRequestDispatcher("Producto.jsp").forward(request, response);

                    } else {

                        request.setAttribute("alerta", "<script>alert('Se produjo un error'); </script>");
                    }

                } else {
                    request.setAttribute("alerta", "<script>alert('Campos vacios'); </script>");
                }
            }
            this.producto = daoProducto.getMax();

            this.productoList = daoProducto.getSelect1();
            request.setAttribute("codigo", crearCodigo("CP-", producto.getMax() + 1));
            request.setAttribute("productoList", this.productoList);
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(ControlProductoAdministracion.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(ControlProductoAdministracion.class.getName()).log(Level.SEVERE, null, ex);
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
}
