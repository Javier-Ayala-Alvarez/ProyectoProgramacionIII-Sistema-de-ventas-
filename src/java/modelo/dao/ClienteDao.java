package modelo.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion.Conexion;
import modelo.entidades.Cliente;

public class ClienteDao {

    private static Conexion conectar;

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private Cliente registros;
    private ArrayList<Cliente> registroList;

    public ClienteDao() {
        this.conectar = new Conexion();
    }

    public boolean insert(Cliente obj) {
        try {
            con = conectar.getConexion();
            String sql = "insert into cliente(idcliente,codigocliente,nombre"
                    + ",apellido,telefonocliente,direccioncliente)VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdCliente());
            ps.setString(2, obj.getCodigoCliente());
            ps.setString(3, obj.getNombre());
            ps.setString(4, obj.getApellido());
            ps.setString(5, obj.getTelefono());
            ps.setString(6, obj.getDireccion());
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                ps.close();
                this.conectar.cerrarConexiones();
            } catch (Exception ex) {
                return false;
            }

        }

    }

    public boolean delete(String codigo) {

        try {
            con = conectar.getConexion();
            String sql = "delete from cliente where codigocliente ='" + codigo + "'";
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

    public boolean update(Cliente obj) {
        String sql = "update cliente set idcliente=?, codigocliente =?, nombre =?, apellido =?, telefonocliente =?, direccioncliente =? where idcliente= '" + obj.getIdCliente() + "'";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdCliente());
            ps.setString(2, obj.getCodigoCliente());
            ps.setString(3, obj.getNombre());
            ps.setString(4, obj.getApellido());
            ps.setString(5, obj.getTelefono());
            ps.setString(6, obj.getDireccion());
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

    public Cliente getSelectTo(String codigo) throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM cliente WHERE codigocliente ='" + codigo + "'";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setCodigoCliente(rs.getString("codigocliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefonocliente"));
                cliente.setDireccion(rs.getString("direccioncliente"));

                return cliente;
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {
        }
        return null;
    }
public boolean getSelectToTelefono(String telefono) throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM cliente WHERE telefonocliente ='" + telefono + "'";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setCodigoCliente(rs.getString("codigocliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefonocliente"));
                cliente.setDireccion(rs.getString("direccioncliente"));

                return true;
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {
        }
        return false;
    }
    public Cliente getMax() throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT MAX(idcliente) Max FROM cliente;";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {

                registros = new Cliente();
                registros.setMax(rs.getInt("Max"));

                return registros;
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Cliente> getSelect() throws SQLException {

        this.registroList = new ArrayList<>();

        try {
            con = conectar.getConexion();
            String sql = "SELECT * FROM cliente";
            ps = con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setCodigoCliente(rs.getString("codigocliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefonocliente"));
                cliente.setDireccion(rs.getString("direccioncliente"));
                this.registroList.add(cliente);
            }
            this.conectar.cerrarConexiones();
        } catch (Exception e) {

        }
        return this.registroList;
    }
}
