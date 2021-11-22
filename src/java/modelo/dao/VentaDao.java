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
import java.sql.Date;
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
            this.sql = "SELECT v.idventa id, v.nfactura factura, v.fechaventa fecha, e.nombre empleadonombre , cl.nombre clientenombre,e.apellido empleadoapellido , cl.apellido clienteapellido, SUM ( r.cantidadproducto * pr.precioventa) total "
                    + "FROM venta v INNER JOIN cliente cl ON v.idcliente  = cl.idcliente "
                    + "INNER JOIN empleado e ON v.idempleado = e.idempleado "
                    + "INNER JOIN registros r ON r.idventa = v.idventa "
                    + "INNER JOIN producto pr ON r.idproducto = pr.idproducto "
                    + "WHERE v.estado = 0 "
                    + "GROUP BY v.idventa,v.nfactura, v.fechaventa, e.nombre, cl.nombre,  e.apellido, cl.apellido";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Venta venta = new Venta();
                venta.setIdFactura(rs.getInt("id"));
                venta.setnFactura(rs.getString("factura"));
                venta.setFechaVenta(rs.getDate("fecha"));
                venta.setNombreCliente(rs.getString("clientenombre"));
                 venta.setApellidoCliente(rs.getString("clienteapellido"));
                 venta.setNombreEmpleado(rs.getString("empleadonombre"));
                venta.setApellidoEmpleado(rs.getString("empleadoapellido"));
                venta.setSaldoTotal(rs.getDouble("total"));
                this.ventasList.add(venta);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.ventasList;
    }
     public ArrayList<Venta> getFecha() throws SQLException {

        this.ventasList = new ArrayList<>();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT  DISTINCT EXTRACT( YEAR FROM fechaventa ) AS fecha FROM venta GROUP BY fecha;";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Venta venta = new Venta();
 
                venta.setAño(rs.getInt("fecha"));
               
                this.ventasList.add(venta);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.ventasList;
    }

    public ArrayList<Venta> getVentaTo(String codigo) throws SQLException {

        this.ventasList = new ArrayList<>();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT v.idventa id, v.nfactura factura, v.fechaventa fecha, e.nombre empleado , cl.nombre cliente, SUM ( r.cantidadproducto * pr.precioventa) total "
                    + "FROM venta v INNER JOIN cliente cl ON v.idcliente  = cl.idcliente "
                    + "INNER JOIN empleado e ON v.idempleado = e.idempleado "
                    + "INNER JOIN registros r ON r.idventa = v.idventa "
                    + "INNER JOIN producto pr ON r.idproducto = pr.idproducto "
                    + "WHERE v.estado = 0 and v.nfactura = '" + codigo + "' "
                    + "GROUP BY v.idventa,v.nfactura, v.fechaventa, e.nombre, cl.nombre";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Venta venta = new Venta();
                venta.setIdFactura(rs.getInt("id"));
                venta.setnFactura(rs.getString("factura"));
                venta.setFechaVenta(rs.getDate("fecha"));
                venta.setNombreCliente(rs.getString("cliente"));
                venta.setNombreEmpleado(rs.getString("empleado"));
                venta.setSaldoTotal(rs.getDouble("total"));
                this.ventasList.add(venta);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.ventasList;
    }
      public Venta getVentaTo1c(String codigo) throws SQLException {


        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT v.idventa id, v.nfactura factura, v.fechaventa fecha, e.nombre empleado , cl.nombre cliente, SUM ( r.cantidadproducto * pr.precioventa) total "
                    + "FROM venta v INNER JOIN cliente cl ON v.idcliente  = cl.idcliente "
                    + "INNER JOIN empleado e ON v.idempleado = e.idempleado "
                    + "INNER JOIN registros r ON r.idventa = v.idventa "
                    + "INNER JOIN producto pr ON r.idproducto = pr.idproducto "
                    + "WHERE v.estado = 0 and v.nfactura = '" + codigo + "' "
                    + "GROUP BY v.idventa,v.nfactura, v.fechaventa, e.nombre, cl.nombre";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Venta venta = new Venta();
                venta.setIdFactura(rs.getInt("id"));
                venta.setnFactura(rs.getString("factura"));
                venta.setFechaVenta(rs.getDate("fecha"));
                venta.setNombreCliente(rs.getString("cliente"));
                venta.setNombreEmpleado(rs.getString("empleado"));
                venta.setSaldoTotal(rs.getDouble("total"));
                return venta;
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return venta;
    }

    public boolean getVentaTo1(String codigo) throws SQLException {

        this.ventasList = new ArrayList<>();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT *FROM venta WHERE  nfactura = '" + codigo + "' ";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                return true;
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public Venta getSelectMax() throws SQLException {

        this.ventasList = new ArrayList<>();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT MAX(idventa) max from Venta";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Venta venta = new Venta();
                venta.setMax(rs.getInt("max"));

                return venta;
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.venta;
    }

    public boolean insert(Venta obj) {
        try {
            String sql = "insert into venta(idventa, nfactura,fechaventa,estado,idcliente,idempleado)VALUES(?,?,?,?,?,?)";

            accesoDB = conexion.getConexion();
            ps = accesoDB.prepareStatement(sql);

            ps.setInt(1, obj.getIdFactura());//aqui
            ps.setString(2, obj.getnFactura());
            ps.setDate(3, (Date) obj.getFechaVenta());//aqui
            ps.setInt(4, obj.getEstado());
            ps.setInt(5, obj.getCliente().getIdCliente());//aqui
            ps.setInt(6, obj.getEmpleado().getIdEmpleado());//aqui

            ps.execute();

            return true;
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error en sql");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                 conexion.cerrarConexiones();
            } catch (Exception ex) {

            }
           
        }
        return false;
    }

}
