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

    
    public DaoProducto(){
        this.conectar = new Conexion();
    }


public ArrayList<Producto> getSelect() throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM producto";
           ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idproducto"));
            producto.setCodigoProducto(rs.getString("codigoproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setPrecioVenta(rs.getDouble("precioventa"));
                producto.setCantidad(rs.getInt("cantidad"));
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
            String sql = "SELECT * FROM producto WHERE codigoproducto ='"+codigo+"'";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            if(this.rs.next()){
                
                 Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setCodigoProducto(rs.getString("codigoproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setPrecioVenta(rs.getDouble("precioventa"));
                producto.setCantidad(rs.getInt("cantidad"));
               
                return producto;
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {
        }
        return null;
    }
}


