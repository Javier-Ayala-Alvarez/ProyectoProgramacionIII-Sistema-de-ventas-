/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.conexion;
import java.sql.*;
/**
 *
 * @author JOSUE GARCIA
 */

public class Conexion {

    private  Connection conexion = null;
    private static final ResultSet rs = null;
    private static Statement sentencia = null;
    private static final PreparedStatement ps = null;
    private static final String url = "jdbc:postgresql://localhost:5433/proyectofinal";
    private static final String usuario = "postgres";
    private static final String password = "12345";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            // Obtener la conexion
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("conectando a la DB");
        } catch (SQLException ex) {
        } catch (Exception e) {
        }
        return con;
    }

    public void cerrarConexiones() {
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el Statement" + e);
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la bd" + e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la bd" + e);
            }
        }
    }
}