
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ClienteDao;
import modelo.dao.DaoProducto;
import modelo.dao.EmpleadoDao;
import modelo.dao.RegistrosDao;
import modelo.dao.VentaDao;
import modelo.entidades.Cliente;
import modelo.entidades.Empleados;
import modelo.entidades.Producto;
import modelo.entidades.Registros;
import modelo.entidades.Venta;

@WebServlet(name = "ControlRegistro", urlPatterns = {"/ControlRegistro"})
public class ControlRegistro extends HttpServlet {

    private RegistrosDao daoRegistro;
    private ArrayList<Registros> registroPro;
    private VentaDao daoVenta;
    private ArrayList<Venta> ventasList;
    private Venta ventasList1;
    private Empleados empleado;
    private EmpleadoDao daoEmpleado;
    private Cliente cliente;
    private ClienteDao daoCliente;
    private DaoProducto daoProducto;
    private Registros registroVenta;
    private List<Registros> lista = new ArrayList();
    private double total = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        this.daoRegistro = new RegistrosDao();
        this.daoProducto = new DaoProducto();
        this.daoVenta = new VentaDao();
        this.ventasList1 = new Venta();
        this.ventasList = new ArrayList<>();
        this.registroPro = new ArrayList<>();
        this.empleado = new Empleados();
        this.daoEmpleado = new EmpleadoDao();
        this.cliente = new Cliente();
        this.daoCliente = new ClienteDao();
        this.registroVenta = new Registros();
        PrintWriter out1 = response.getWriter();
        try (PrintWriter out = response.getWriter()) {
            if ((!request.getParameter("btn").isEmpty())) {
                if (request.getParameter("event").equals("AgregarRegistro")) {
                    response.setContentType("text/html; charset=iso-8859-1");

//                    try {
//                       String codigofactura = request.getParameter("codigofactura");
//                        ventasList1 = daoVenta.getVentaTo1(codigofactura);
//                        if (ventasList1 == null) {
//                            cliente = daoCliente.getSelectTo(request.getParameter("codigoCliente"));
//
//                            empleado = daoEmpleado.getselectAllTo(request.getParameter("codigoEmpleado"));
//                            ventasList1 = daoVenta.getSelectMax();
//                            int id = ventasList1.getMax() + 1;
//                            // public Venta(int idFactura, String nFactura, Date fechaVenta, Cliente cliente, Empleados empleado) {
//
//                            ventasList1 = new Venta(id, request.getParameter("codigofactura"), Date.valueOf(request.getParameter("fecha")), 0, cliente, empleado);
//                            daoVenta.insert(ventasList1);
//                        }
//                    } catch (SQLException ex) {
//
//                    }
                    if (lista.size() < 6) {
                        if (!request.getParameter("codigoprducto").equals("null")) {
                            if (Integer.parseInt(request.getParameter("cantidad")) > 0) {
                                registroVenta.setCodigoProducto(request.getParameter("codigoprducto"));
                                registroVenta.setNombreProducto(request.getParameter("producto"));
                                registroVenta.setCantidadProducto(Integer.parseInt(request.getParameter("cantidad")));
                                registroVenta.setPrecioVentaProducto(Double.parseDouble(request.getParameter("precioUni")));
                                registroVenta.setPrecioTotalProducto(Double.parseDouble(request.getParameter("preciototal1")));
                                this.lista.add(registroVenta);
                            } else {
                                out1.println("<script>alert('Ingrese cantidad'); </script>");
                            }
                        } else {
                            out1.println("<script>alert('Seleccione un Producto'); </script>");
                        }
                    } else {
                        out1.println("<script>alert('Debe generar una nueva Factura'); </script>");
                    }

                }
                if (request.getParameter("event").equals("cancelarFactura")) {
                    this.lista.clear();
                    this.total = 0;
                }
                if (request.getParameter("event").equals("eliminarId")) {
                    this.lista.remove(Integer.parseInt(request.getParameter("Eliminar")));
                }
                out1.println("<div class='column'> <div class='TABLE3'> <table  class='table is-fullwidth'> <TR><TD bgcolor='#3EB429> <H4 ><font color='#fff'>N°<TD bgcolor='#3EB429' >"
                        + "<H4 ><font color='#fff'>CODIGO<TD bgcolor='#3EB429' > <H4><font color='#fff'>PRODUCTO<TD bgcolor='#3EB429' ><H4><font color='#fff'>CANTIDAD<TD bgcolor='#3EB429' >"
                        + "<H4><font color='#fff'>PRECIO<TD bgcolor='#3EB429' > <H4><font color='#fff'>TOTAL</TD><TD bgcolor='#3EB429' ><H4><font color='#fff'>OPCCIONES</TD>");
                int i = 0;
                for (Registros registro : lista) {
                    out1.println("<tr><td align='center'>" + i + "</td>");

                    out1.println("<td align='center'>" + registro.getProducto().getCodigoProducto() + "</td>");
                    out1.println("<td align='center'>" + registro.getProducto().getNombreProducto() + "</td>");
                    out1.println("<td align='center'>" + registro.getCantidadProducto() + "</td>");
                    out1.println("<td align='center'>" + "$" + String.format("%.2f", registro.getProducto().getPrecioVenta()) + "</td>");
                    out1.println("<td align='center'>" + "$" + String.format("%.2f", registro.getPrecioTotalProducto()) + "</td>");
                    i++;
                    out1.println("<td align='center'> <button class='button is-danger is-outlined btn_EliminarProducto' value='" + registro.getIdRegistros() + "' id='btn_EliminarProducto'>Eliminar</a></button></td>");
                    this.total = total + registro.getPrecioTotalProducto();
                }
                out1.println("</tr></table>  </div>  </div>");
                out1.println("<!-- TOTALES DE LA FACTURA ... -->");
                out1.println("<div  class='form-register1'>");
                out1.println("<table><tr><td>");
                out1.println(" <form>");
                out1.println("<td><input type='submit' name='ReFactura' value='Facturar' class='button is-link is-active'>");
                out1.println("<td> <input type = 'submit' name = 'ReFactura' id='cancelarFactura' value = 'Cancelar' class='button is-danger'>");
                out1.println("<td class='column is-one-third'> Total:");
                out1.println("<td> <input type='text'  name='Usuario' placeholder='Total' value='" + this.total + "' class='input is-success'/>");
                out1.println("</form> </td> </tr> </table>");
                this.total = 0;

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

    public void mostrar() {

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
