/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion.Conexion;
import modelo.entidades.Cliente;
import modelo.entidades.Empresa;
import modelo.entidades.Producto;

/**
 *
 * @author Francisco Javier
 */
public class DaoProducto {

    private static Conexion conectar;

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private Producto registros;
    private ArrayList<Producto> registroList;

    public DaoProducto() {
        this.conectar = new Conexion();
    }

    public boolean insert(Producto obj) {
        String sql = "insert into producto(idproducto, codigoproducto, nombreproducto, preciocompra, cantidad, fechavencimiento, estado, precioventa, idempresa)VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdProducto());
            ps.setString(2, obj.getCodigoProducto());
            ps.setString(3, obj.getNombreProducto());
            ps.setDouble(4, obj.getPrecioCompra());
            ps.setInt(5, obj.getCantidad());
            ps.setDate(6, new java.sql.Date(obj.getFechaVencimiento().getTime()));
            ps.setInt(7, obj.getEstado());
            ps.setDouble(8, obj.getPrecioVenta());
            ps.setInt(9, obj.getEmpresa().getIdEmpresa());

            ps.execute();

            return true;
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {

            }
            conectar.cerrarConexiones();
        }
        return false;
    }

    public Producto getMax() throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT MAX(idproducto) Max FROM producto";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {

                registros = new Producto();
                registros.setMax(rs.getInt("Max"));

                return registros;
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Producto> buscar(String dato) {////////////////////////////
        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM producto p INNER JOIN empresa e on p.idempresa = e.idempresa WHERE p.cantidad > 0 and p.nombreproducto LIKE '%" + dato + "%'or p.codigoproducto LIKE '%" + dato + "%' ";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Producto producto = new Producto();
                Empresa obj = new Empresa();

                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setCodigoProducto(rs.getString("codigoproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setPrecioCompra(rs.getDouble("preciocompra"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setFechaVencimiento(rs.getDate("fechavencimiento"));
                producto.setEstado(rs.getInt("estado"));
                producto.setPrecioVenta(rs.getDouble("precioventa"));

                obj.setIdEmpresa(rs.getInt("idempresa"));
                obj.setCodigoEmpresa(rs.getString("codigoempresa"));
                obj.setNombre(rs.getString("nombreempresa"));
                obj.setDireccion(rs.getString("dirrecionempresa"));
                obj.setCorreo(rs.getString("correoempresa"));
                producto.setEmpresa(obj);
               
                this.registroList.add(producto);
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {

        }
        return this.registroList;
    }

    public ArrayList<Producto> getSelect1() throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM producto p INNER JOIN empresa e on p.idempresa = e.idempresa";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Producto producto = new Producto();
                Empresa obj = new Empresa();

                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setCodigoProducto(rs.getString("codigoproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setPrecioCompra(rs.getDouble("preciocompra"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setFechaVencimiento(rs.getDate("fechavencimiento"));
                producto.setEstado(rs.getInt("estado"));
                producto.setPrecioVenta(rs.getDouble("precioventa"));

                obj.setIdEmpresa(rs.getInt("idempresa"));
                obj.setCodigoEmpresa(rs.getString("codigoempresa"));
                obj.setNombre(rs.getString("nombreempresa"));
                obj.setDireccion(rs.getString("dirrecionempresa"));
                obj.setCorreo(rs.getString("correoempresa"));
                producto.setEmpresa(obj);
                this.registroList.add(producto);
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {

        }
        return this.registroList;
    }

    public ArrayList<Producto> getSelect() throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM producto p INNER JOIN empresa e on p.idempresa = e.idempresa where p.cantidad > 0";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
               Producto producto = new Producto();
                Empresa obj = new Empresa();

                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setCodigoProducto(rs.getString("codigoproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setPrecioCompra(rs.getDouble("preciocompra"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setFechaVencimiento(rs.getDate("fechavencimiento"));
                producto.setEstado(rs.getInt("estado"));
                producto.setPrecioVenta(rs.getDouble("precioventa"));

                obj.setIdEmpresa(rs.getInt("idempresa"));
                obj.setCodigoEmpresa(rs.getString("codigoempresa"));
                obj.setNombre(rs.getString("nombreempresa"));
                obj.setDireccion(rs.getString("dirrecionempresa"));
                obj.setCorreo(rs.getString("correoempresa"));
                producto.setEmpresa(obj);
                this.registroList.add(producto);
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {

        }
        return this.registroList;
    }

    public Producto getSelectTo(String codigo) throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM producto p INNER JOIN empresa e on p.idempresa = e.idempresa WHERE p.codigoproducto ='" + codigo + "'";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {

                Producto producto = new Producto();
                Empresa obj = new Empresa();

                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setCodigoProducto(rs.getString("codigoproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setPrecioCompra(rs.getDouble("preciocompra"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setFechaVencimiento(rs.getDate("fechavencimiento"));
                producto.setEstado(rs.getInt("estado"));
                producto.setPrecioVenta(rs.getDouble("precioventa"));

                obj.setIdEmpresa(rs.getInt("idempresa"));
                obj.setCodigoEmpresa(rs.getString("codigoempresa"));
                obj.setNombre(rs.getString("nombreempresa"));
                obj.setDireccion(rs.getString("dirrecionempresa"));
                obj.setCorreo(rs.getString("correoempresa"));
                producto.setEmpresa(obj);
                this.registroList.add(producto);

                return producto;
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {
        }
        return null;
    }

    public boolean update(Producto obj) {
        String sql = "update producto set idproducto =?, codigoproducto =?, nombreproducto =?, preciocompra =?, cantidad =?, fechavencimiento =?, estado =? ,precioventa =?, idempresa =? where idproducto=" + obj.getIdProducto();
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdProducto());
            ps.setString(2, obj.getCodigoProducto());
            ps.setString(3, obj.getNombreProducto());
            ps.setDouble(4, obj.getPrecioCompra());
            ps.setInt(5, obj.getCantidad());
            ps.setDate(6, new java.sql.Date(obj.getFechaVencimiento().getTime()));
            ps.setInt(7, obj.getEstado());
            ps.setDouble(8, obj.getPrecioVenta());
            ps.setInt(9, obj.getEmpresa().getIdEmpresa());

            ps.execute();

            return true;
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {

            }
            conectar.cerrarConexiones();
        }
        return false;
    }

    public Producto getSelectTo1(String codigo) throws SQLException {

       

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM producto p INNER JOIN empresa e on p.idempresa = e.idempresa WHERE p.codigoproducto ='" + codigo + "'";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {

               
                Producto producto = new Producto();
                Empresa obj = new Empresa();

                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setCodigoProducto(rs.getString("codigoproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setPrecioCompra(rs.getDouble("preciocompra"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setFechaVencimiento(rs.getDate("fechavencimiento"));
                producto.setEstado(rs.getInt("estado"));
                producto.setPrecioVenta(rs.getDouble("precioventa"));

                obj.setIdEmpresa(rs.getInt("idempresa"));
                obj.setCodigoEmpresa(rs.getString("codigoempresa"));
                obj.setNombre(rs.getString("nombreempresa"));
                obj.setDireccion(rs.getString("dirrecionempresa"));
                obj.setCorreo(rs.getString("correoempresa"));
                producto.setEmpresa(obj);
              

                return producto;
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {
        }
        return null;
    }

    public boolean delete(String obj) {
        String sql = "delete from producto where codigoproducto='" + obj + "'";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conectar.cerrarConexiones();
            } catch (Exception ex) {
            }
        }

        return false;
    }

}
