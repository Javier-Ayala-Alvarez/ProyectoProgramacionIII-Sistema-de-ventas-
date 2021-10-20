package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.conexion.Conexion;
import modelo.entidades.Empresa;

public class EmpresaDao {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public EmpresaDao() {

    }
 public Empresa selectId(int codigo) {
        String sql = "SELECT * FROM empresa where idempresa='" + codigo + "'";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (this.rs.next()) {
                Empresa obj = new Empresa();
                obj.setIdEmpresa(rs.getInt("idempresa"));
                obj.setCodigoEmpresa(rs.getString("codigoempresa"));
                obj.setNombre(rs.getString("nombreempresa"));
                obj.setDireccion(rs.getString("dirrecionempresa"));
                obj.setCorreo(rs.getString("correoempresa"));
                return obj;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {

            }
            conectar.cerrarConexiones();
        }

       return null;
    }
    public Empresa selectAllto(String codigo) {
        String sql = "SELECT * FROM empresa where codigoempresa='" + codigo + "'";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (this.rs.next()) {
                Empresa obj = new Empresa();
                obj.setIdEmpresa(rs.getInt("idempresa"));
                obj.setCodigoEmpresa(rs.getString("codigoempresa"));
                obj.setNombre(rs.getString("nombreempresa"));
                obj.setDireccion(rs.getString("dirrecionempresa"));
                obj.setCorreo(rs.getString("correoempresa"));
                return obj;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {

            }
            conectar.cerrarConexiones();
        }

       return null;
    }

    public ArrayList<Empresa> selectAll() {
        String sql = "SELECT * fROM empresa";
        return select(sql);
    }

    public boolean insert(Empresa obj) {
        String sql = "INSERT INTO empresa (codigoempresa , nombreempresa , dirrecionempresa , correoempresa) VALUES (?,?,?,?)";
        return alterarRegistro(sql, obj);
    }

    public boolean update(Empresa obj) {
        String sql = "UPDATE empresa SET idempresa =?, codigoempresa =?, nombreempresa =?, dirrecionempresa =?, correoempresa =? WHERE idempresa= '" + obj.getIdEmpresa() + "'";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdEmpresa());
            ps.setString(2, obj.getCodigoEmpresa());
            ps.setString(3, obj.getNombre());
            ps.setString(4, obj.getDireccion());
            ps.setString(5, obj.getCorreo());
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

    private ArrayList<Empresa> select(String sql) {
        ArrayList<Empresa> lista = new ArrayList();
        Empresa obj = null;
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Empresa();
                obj.setIdEmpresa(rs.getInt("idEmpresa"));
                obj.setCodigoEmpresa(rs.getString("codigoEmpresa"));
                obj.setNombre(rs.getString("nombreEmpresa"));
                obj.setDireccion(rs.getString("dirrecionEmpresa"));
                obj.setCorreo(rs.getString("correoEmpresa"));
                lista.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {

            }
            conectar.cerrarConexiones();
        }

        return lista;
    }

    private boolean alterarRegistro(String sql, Empresa obj) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdEmpresa());
            ps.setString(2, obj.getCodigoEmpresa());
            ps.setString(3, obj.getNombre());
            ps.setString(4, obj.getDireccion());
            ps.setString(5, obj.getCorreo());
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

}
