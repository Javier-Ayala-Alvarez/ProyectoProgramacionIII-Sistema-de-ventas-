package modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.conexion.Conexion;
import modelo.entidades.Usuario;

public class UsuarioDao {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public UsuarioDao() {

    }

    public ArrayList<Usuario> selectAllTo(String atributo, String condicion) {
        String sql = "SELECT * fROM usuario WHERE  " + atributo + "='" + condicion + "'";
        return select(sql);
    }

    public ArrayList<Usuario> selectId(int id) {
        String sql = "SELECT * fROM usuario WHERE  idusuario = " + id;
        return select(sql);
    }

    private ArrayList<Usuario> select(String sql) {
        ArrayList<Usuario> lista = new ArrayList();
        Usuario obj = null;
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                obj = new Usuario();

                obj.setIdUsuario(rs.getInt("idusuario"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setContraseña(rs.getString("contraseña"));
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

}
