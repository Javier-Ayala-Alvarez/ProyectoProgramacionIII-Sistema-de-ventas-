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
        String sql = "SELECT * fROM empleado e INNER JOIN empresa ee ON ee.idempresa = e.idempresa  INNER JOIN usuario u ON u.idusuario = e.idusuario WHERE  e." + atributo + "='" + condicion + "'";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (this.rs.next()) {
                Empleados empleado = new Empleados();
                Empresa obj = new Empresa();
                Usuario usuario = new Usuario();

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

                obj.setIdEmpresa(rs.getInt("idempresa"));
                obj.setCodigoEmpresa(rs.getString("codigoempresa"));
                obj.setNombre(rs.getString("nombreempresa"));
                obj.setDireccion(rs.getString("dirrecionempresa"));
                obj.setCorreo(rs.getString("correoempresa"));

                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));

                empleado.setEmpresa(obj);
                empleado.setUsuario(usuario);
                return empleado;

            }
            conectar.cerrarConexiones();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Empleados selectAllUsu() {
        String sql = "SELECT * fROM empleado e INNER JOIN usuario u ON u.idusuario = e.idusuario WHERE  cargoempleado = 'Administrador' AND estado = '1' AND idusuario != 'null'";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (this.rs.next()) {
                Empleados empleado = new Empleados();
                Usuario usuario = new Usuario();

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

                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                empleado.setUsuario(usuario);
                return empleado;

            }
            conectar.cerrarConexiones();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Empleados getselectAllTo(String condicion) throws SQLException {
        String sql = "SELECT * fROM empleado e INNER JOIN usuario u ON u.idusuario = e.idusuario  WHERE e.codigoempleado='"+ condicion + "'";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (this.rs.next()) {
                Empleados empleado = new Empleados();
                 Usuario usuario = new Usuario();
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
               
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                
                empleado.setUsuario(usuario);
                return empleado;

            }
            conectar.cerrarConexiones();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
