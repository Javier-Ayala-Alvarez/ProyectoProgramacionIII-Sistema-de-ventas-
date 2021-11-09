package modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Empleados extends Persona implements Serializable {

    private int idUsuario;
    private int idEmpleado;
    private String cargoEmpleado, codigoEmpleado;
    private double salarioEmpleado, afp, isss;
    private Date fechaContratacion;
    private Usuario usuario;
    private Empresa empresa;
    private int estado;

 

    public Empleados() {
    }

    public Empleados(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleados(int idUsuario, int idEmpleado, String cargoEmpleado, String codigoEmpleado, Usuario usuario, int estado, String nombre, String apellido, String telefono, String direccion) {
        super(nombre, apellido, telefono, direccion);
        this.idUsuario = idUsuario;
        this.idEmpleado = idEmpleado;
        this.cargoEmpleado = cargoEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.usuario = usuario;
        this.estado = estado;
    }



    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void addUsuario(Usuario x) {
        this.usuario = x;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public double getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(double salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    public double getAfp() {
        return afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public double getIsss() {
        return isss;
    }

    public void setIsss(double isss) {
        this.isss = isss;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

 
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {

        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
