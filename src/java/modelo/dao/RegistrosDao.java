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
import modelo.entidades.Registros;

/**
 *
 * @author emili
 */
public class RegistrosDao {

    private static Conexion conexion;
    private Registros registros;
    private ArrayList<Registros> registroList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private String sql;

    public RegistrosDao() {
        this.conexion = new Conexion();
    }

    public ArrayList<Registros> getRegistros(String codigo) throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.sql = "SELECT pr.codigoproducto codigo, pr.nombreproducto producto, r.cantidadproducto cantidad, pr.precioventa precio,"
                    + " SUM ( r.cantidadproducto * pr.precioventa ) "
                    + "total FROM venta v INNER JOIN cliente cl ON v.idcliente = cl.idcliente "
                    + "INNER JOIN empleado e ON v.idempleado = e.idempleado "
                    + "INNER JOIN registros r ON r.idventa = v.idventa "
                    + "INNER JOIN producto pr ON r.idproducto = pr.idproducto "
                    + "WHERE v.estado = 0 and r.idventa = "
                    + "(SELECT idventa FROM venta WHERE nfactura = '"+codigo+"')"
                    + "GROUP BY pr.codigoproducto, pr.nombreproducto, r.cantidadproducto, pr.precioventa";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                registros = new Registros();
                registros.setCodigoProducto(rs.getString("codigo"));
                registros.setNombreProducto(rs.getString("producto"));
                registros.setCantidadProducto(rs.getInt("cantidad"));
                registros.setPrecioVentaProducto(rs.getDouble("precio"));
                registros.setPrecioTotalProducto(rs.getDouble("total"));
                this.registroList.add(registros);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.registroList;
    }
    public ArrayList<Registros> getRegistros1(int codigo) throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            this.accesoDB = this.conexion.getConexion();
             this.sql = "SELECT r.idregistros id, pr.codigoproducto codigo, pr.nombreproducto producto, r.cantidadproducto cantidad, pr.precioventa precio,"
                    + " SUM ( r.cantidadproducto * pr.precioventa ) "
                    + "total FROM venta v INNER JOIN cliente cl ON v.idcliente = cl.idcliente "
                    + "INNER JOIN empleado e ON v.idempleado = e.idempleado "
                    + "INNER JOIN registros r ON r.idventa = v.idventa "
                    + "INNER JOIN producto pr ON r.idproducto = pr.idproducto "
                    + "WHERE v.estado = 0 and r.idventa = "
                    + "(SELECT idventa FROM venta WHERE idventa = '"+codigo+"')"
                    + "GROUP BY r.idregistros, pr.codigoproducto, pr.nombreproducto, r.cantidadproducto, pr.precioventa";
            this.ps = accesoDB.prepareStatement(this.sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                registros = new Registros();
                registros.setIdRegistros(rs.getInt("id"));
                registros.setCodigoProducto(rs.getString("codigo"));
                registros.setNombreProducto(rs.getString("producto"));
                registros.setCantidadProducto(rs.getInt("cantidad"));
                registros.setPrecioVentaProducto(rs.getDouble("precio"));
                registros.setPrecioTotalProducto(rs.getDouble("total"));
                this.registroList.add(registros);
            }
            this.conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return this.registroList;
    }

}
