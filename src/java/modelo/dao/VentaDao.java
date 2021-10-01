/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;
/**
 *
 * @author JOSUE GARCIA
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.entidades.Cliente;
import modelo.entidades.Empleados;
import modelo.entidades.Venta;

/**
 *
 * @author emili
 */
public class VentaDao {

    private static Conexion conexion;
    private Venta venta;
    private ArrayList<Venta> ventasList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;

    
    public VentaDao() {
        this.conexion = new Conexion();
    }

    public ArrayList<Venta> getVenta() throws SQLException {

        this.ventasList = new ArrayList<>();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT v.nfactura factura, v.fechaventa fecha, e.nombre empleado, cl.nombre, SUM ( r.cantidadproducto * pr.precioventa) total "
                    + "FROM venta v INNER JOIN cliente cl ON v.idcliente  = cl.idcliente "
                    + "INNER JOIN empleado e ON v.idempleado = e.idempleado "
                    + "INNER JOIN registros r ON r.idventa = v.idventa "
                    + "INNER JOIN producto pr ON r.idproducto = pr.idproducto "
                    + "GROUP BY v.nfactura, v.fechaventa, e.nombre, cl.nombre";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Venta venta = new Venta();
  //              venta.setIdFactura(rs.getInt("idVenta"));
            venta.setnFactura(rs.getString("factura"));
                venta.setFechaVenta(rs.getDate("fecha"));
                //venta.setCliente(new Cliente(rs.getInt("empleado")));
//                venta.setEmpleado(new Empleados(rs.getInt("idEmpleado")));
                venta.setSaldoTotal(rs.getDouble("total"));
               this.ventasList.add(venta);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.ventasList;
    }
}