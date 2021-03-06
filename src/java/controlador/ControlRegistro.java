package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.conexion.Conexion;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import java.io.File;
import java.util.Map;

@WebServlet(name = "ControlRegistro", urlPatterns = {"/ControlRegistro"})
public class ControlRegistro extends HttpServlet {

    private RegistrosDao daoRegistro;
    private ArrayList<Registros> registroPro;
    private VentaDao daoVenta;
    private ArrayList<Venta> ventasList;
    private Venta ventasList1, ventasList2;
    private Empleados empleado;
    private EmpleadoDao daoEmpleado;
    private Cliente cliente;
    private ClienteDao daoCliente;
    private DaoProducto daoProducto;
    private Producto producto;
    private Registros registroVenta;
    private List<Registros> lista = new ArrayList();
    private double total = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        this.daoRegistro = new RegistrosDao();
        this.daoProducto = new DaoProducto();
        this.producto = new Producto();
        this.daoVenta = new VentaDao();
        this.ventasList1 = new Venta();
        this.ventasList2 = new Venta();
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

                    if (lista.size() < 6) {
                        if (!request.getParameter("codigoprducto").equals("null")) {
                            if (Integer.parseInt(request.getParameter("cantidad")) > 0) {
                                producto = daoProducto.getSelectTo(request.getParameter("codigoprducto"));
                                if (producto.getCantidad() >= Integer.parseInt(request.getParameter("cantidad"))) {
                                    int existe = 0;
                                    for (Registros registro : lista) {
                                        if (request.getParameter("codigoprducto").equals(registro.getProducto().getCodigoProducto())) {
                                            existe = 1;
                                        }
                                    }
                                    if (existe == 0) {
                                        registroVenta.setCodigoProducto(request.getParameter("codigoprducto"));
                                        registroVenta.setNombreProducto(request.getParameter("producto"));
                                        registroVenta.setCantidadProducto(Integer.parseInt(request.getParameter("cantidad")));
                                        registroVenta.setPrecioVentaProducto(Double.parseDouble(request.getParameter("precioUni")));
                                        registroVenta.setPrecioTotalProducto(Double.parseDouble(request.getParameter("preciototal1")));
                                        this.lista.add(registroVenta);
                                    } else {
                                        out1.println("<script>alert('Ya esta el producto en carrito'); </script>");
                                    }
                                } else {
                                    out1.println("<script>alert('Cantidad ingresada sobrepasa la existencia de: " + producto.getCantidad() + "'); </script>");
                                }

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
                //ControlRegistros: Agregara la factura a la base de datos
                if (request.getParameter("event").equals("Facturar")) {
                    if (!request.getParameter("codigoEmpleado").isEmpty()) {
                        if (!request.getParameter("codigoCliente").equals("0")) {
                            if (!request.getParameter("fecha").isEmpty()) {
                                if (!this.lista.isEmpty()) {
                                    try {
                                        cliente = daoCliente.getSelectTo(request.getParameter("codigoCliente"));
                                        empleado = daoEmpleado.getselectAllTo(request.getParameter("codigoEmpleado"));
                                        ventasList1 = daoVenta.getSelectMax();
                                        int id = ventasList1.getMax() + 1;
                                        ventasList1 = new Venta(id, request.getParameter("codigofactura"), Date.valueOf(request.getParameter("fecha")), 0, cliente, empleado);
                                        //ventasList2 =  daoVenta.getVentaTo1( request.getParameter("codigofactura"));
                                        if (daoVenta.getVentaTo1(request.getParameter("codigofactura"))) {
                                            out1.println("<script>alert('Generar nuevo correlativo'); </script>");
                                        } else {
                                            if (daoVenta.insert(ventasList1) == true) {
                                                out1.println("<script>alert('Factura Guardada con exito'); </script>");
                                                for (int x = 0; x < lista.size(); x++) {
                                                    //Agregar a registro//
                                                    registroVenta = daoRegistro.getSelectMax();
                                                    int id1 = registroVenta.getMax() + 1;
                                                    String codigo = lista.get(x).getProducto().getCodigoProducto();
                                                    producto = daoProducto.getSelectTo(codigo);
                                                    registroVenta = new Registros(id1, lista.get(x).getCantidadProducto(), ventasList1, producto);
                                                    daoRegistro.insert(registroVenta);
                                                    //fin de agregrar a registro//
                                                    //Modificar Producto//
                                                    producto.setIdProducto(producto.getIdProducto());
                                                    producto.setCodigoProducto(producto.getCodigoProducto());
                                                    producto.setNombreProducto(producto.getNombreProducto());
                                                    producto.setPrecioCompra(producto.getPrecioCompra());

                                                    producto.setCantidad(producto.getCantidad() - lista.get(x).getCantidadProducto());
                                                    producto.setFechaVencimiento(producto.getFechaVencimiento());
                                                    producto.setEstado(producto.getEstado());
                                                    producto.setEmpresa(producto.getEmpresa());
                                                    daoProducto.update(producto);
                                                    String id2 = request.getParameter("codigofactura");
                                                   out1.println("<a href='ReporteImpreso.jsp?id="+id2+"'><img src='img/impresora.png'/></a>");

                                                    //fin de modificar producto//
                                                }

                                                this.lista.clear();
                                                this.registroVenta = null;
                                                

                                            } else {
                                                out1.println("<script>alert('Verifique que los datos han sido ingresados correctamente'); </script>");
                                            }

                                        }
                                    } catch (SQLException ex) {
                                        out1.println("<script>alert('Se ha producido un error'); </script>");
                                    }
                                } else {
                                    out1.println("<script>alert('Debe agregar un registro'); </script>");
                                }
                            } else {
                                out1.println("<script>alert('Debe de agregar fecha'); </script>");
                            }
                        } else {
                            out1.println("<script>alert('Debe agregar un cliente'); </script>");
                        }
                    } else {
                        out1.println("<script>alert('Debe agregar un Empleado'); </script>");
                    }
                }
                if (request.getParameter("event").equals("cancelarFactura")) {
                    this.lista.clear();
                    this.total = 0;
                }
                if (request.getParameter("event").equals("eliminarId")) {
                    this.lista.remove(Integer.parseInt(request.getParameter("Eliminar")) - 1);
                }
                out1.println("<div class='column'> <div class='TABLE3'> <table class='table is-fullwidth'> <TR><TD bgcolor='#3EB429  align='center> <H4 ><font color='#fff'>N??<TD bgcolor='#3EB429' >"
                        + "<H4 ><font color='#fff'>CODIG??<TD bgcolor='#3EB429' > <H4><font color='#fff'>PRODUCTO<TD bgcolor='#3EB429' ><H4><font color='#fff'>CANTIDAD<TD bgcolor='#3EB429' >"
                        + "<H4><font color='#fff'>PRECIO<TD bgcolor='#3EB429' > <H4><font color='#fff'>TOTAL</TD><TD bgcolor='#3EB429' ><H4><font color='#fff'>ACCI??N</TD>");
                int i = 1;
                for (Registros registro : lista) {
                    out1.println("<tr><td align='center'>" + i + "</td>");

                    out1.println("<td align='center'>" + registro.getProducto().getCodigoProducto() + "</td>");
                    out1.println("<td align='center'>" + registro.getProducto().getNombreProducto() + "</td>");
                    out1.println("<td align='center'>" + registro.getCantidadProducto() + "</td>");
                    out1.println("<td align='center'>" + "$" + String.format("%.2f", registro.getProducto().getPrecioVenta()) + "</td>");
                    out1.println("<td align='center'>" + "$" + String.format("%.2f", registro.getPrecioTotalProducto()) + "</td>");
                    i++;
                    out1.println("<td align='center'> <button class='button is-link is-active btn_EliminarProducto' value='" + registro.getIdRegistros() + "' id='btn_EliminarProducto'>Quitar de carrito</button></td>");
                    this.total = total + registro.getPrecioTotalProducto();
                }
                out1.println("</tr></table>  </div>  </div>");
                out1.println("<!-- TOTALES DE LA FACTURA ... -->");
                out1.println("<div  class='form-register1'>");
                out1.println("<table><tr><td>");
                out1.println(" <form>");
                out1.println("<td class='column' ><input type='submit' name='ReFactura' value='Facturar' id='Facturar' class='button is-warning'>");
                out1.println("<input type = 'submit' name = 'cancelarFactura' id='cancelarFactura' value = 'Cancelar' class='button is-danger'>");
                out1.println("</td> <td align='center'> Total: $ ");
                out1.println("<input type='text'  name='Usuario' placeholder='Total' value='" + this.total + "' class='input is-medium is-right  totalFactura'/></td>");
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
