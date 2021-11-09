package modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion.Conexion;
import modelo.entidades.Cliente;
import modelo.entidades.Empleados;
import modelo.entidades.Empresa;
import modelo.entidades.Usuario;

public class EmpleadoDao {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private Empleados empleado;

    public EmpleadoDao() {

    }
     public Empleados selectAllTo(String atributo, int condicion) {
        String sql = "SELECT * fROM empleado WHERE  " + atributo + "='" + condicion + "'";
         try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (this.rs.next()) {
                Empleados empleado = new Empleados();
                
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setIdPersona(rs.getInt("idempleado"));
                empleado.setCodigoEmpleado(rs.getString("codigoempleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setTelefono(rs.getString("telefonoempleado"));
                empleado.setDireccion(rs.getString("dirrecionempleado"));
                empleado.setSalarioEmpleado(rs.getDouble("salarioempleado"));
                empleado.setCargoEmpleado(rs.getString("cargoempleado"));
                empleado.setAfp(rs.getDouble("afp"));
                empleado.setIsss(rs.getDouble("isss"));
                empleado.setFechaContratacion(rs.getDate("contratacion"));
                empleado.setEstado(rs.getInt("estado"));
                Empresa empresa = new Empresa(rs.getInt(("idempresa")));
                Usuario usuario = new Usuario(rs.getInt(("idusuario")));
                 empleado.setEmpresa(empresa);
                empleado.addUsuario(usuario);
                return empleado;
                

            }
            conectar.cerrarConexiones();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

 public Empleados selectAllUsu() {
        String sql = "SELECT * fROM empleado WHERE  cargoempleado = 'Administrador' AND estado = '1' AND idusuario != 'null'";
         try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (this.rs.next()) {
                Empleados empleado = new Empleados();
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setIdPersona(rs.getInt("idempleado"));
                empleado.setCodigoEmpleado(rs.getString("codigoempleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setTelefono(rs.getString("telefonoempleado"));
                empleado.setDireccion(rs.getString("dirrecionempleado"));
                empleado.setSalarioEmpleado(rs.getDouble("salarioempleado"));
                empleado.setCargoEmpleado(rs.getString("cargoempleado"));
                empleado.setAfp(rs.getDouble("afp"));
                empleado.setIsss(rs.getDouble("isss"));
                empleado.setFechaContratacion(rs.getDate("contratacion"));
                empleado.setEstado(rs.getInt("estado"));
                Usuario usuario = new Usuario(rs.getInt(("idUsuario")));
                empleado.addUsuario(usuario);
                return empleado;
                

            }
            conectar.cerrarConexiones();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public Empleados getselectAllTo(String condicion) throws SQLException {
        String sql = "SELECT * FROM empleado WHERE codigoempleado='" + condicion + "'";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (this.rs.next()) {
                Empleados empleado = new Empleados();
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setIdPersona(rs.getInt("idempleado"));
                empleado.setCodigoEmpleado(rs.getString("codigoempleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setTelefono(rs.getString("telefonoempleado"));
                empleado.setDireccion(rs.getString("dirrecionempleado"));
                empleado.setSalarioEmpleado(rs.getDouble("salarioempleado"));
                empleado.setCargoEmpleado(rs.getString("cargoempleado"));
                empleado.setAfp(rs.getDouble("afp"));
                empleado.setIsss(rs.getDouble("isss"));
                empleado.setFechaContratacion(rs.getDate("contratacion"));
                empleado.setEstado(rs.getInt("estado"));
                Usuario usuario = new Usuario(rs.getInt(("idUsuario")));
                empleado.addUsuario(usuario);
                return empleado;
                

            }
            conectar.cerrarConexiones();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
