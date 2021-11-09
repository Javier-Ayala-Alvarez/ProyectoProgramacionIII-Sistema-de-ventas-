package modelo.entidades;

import java.io.Serializable;
import modelo.dao.EmpleadoDao;

public class Usuario implements Serializable {

    private int idUsuario;
    private String usuario;
    private String contraseña;

    Empleados empleados;

    public Usuario() {
        empleados = new Empleados();
    }

    public Usuario(String usuario, String contraseña) {
        empleados = new Empleados();
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Usuario(int estado, String usuario, String contraseña) {
        empleados = new Empleados();

        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Usuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Empleados getEmpleados() {

        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public void AddEpleado1(String id) {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        this.empleados = empleadoDao.selectAllTo("idusuario", Integer.parseInt(id));

    }

}
