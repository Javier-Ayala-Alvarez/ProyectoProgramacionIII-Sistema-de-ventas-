package modelo.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Venta {

    private int idFactura;
    private String nFactura;
    private Date fechaVenta;
    private double saldoTotal;
    private int estado;
    private Cliente cliente = new Cliente();
    private Empleados empleado = new Empleados();
    private Empresa empresa;
    private int max;

    public Venta() {
    }

    public Venta(int max) {
        this.max = max;
    }

    public Venta(int idFactura, String nFactura, Date fechaVenta,int estado, Cliente cliente, Empleados empleado) {
        this.idFactura = idFactura;
        this.nFactura = nFactura;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Venta(int idFactura, String nFactura, int estado, Cliente cliente) {
        this.idFactura = idFactura;
        this.nFactura = nFactura;
      
        this.estado = estado;
        this.cliente = cliente;
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
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

    public String getnFactura() {
        return nFactura;
    }

    public void setnFactura(String nFactura) {
        this.nFactura = nFactura;
    }

    public void setNombreCliente(String nombre) {

        cliente.setNombre(nombre);

    }

    public void setNombreEmpleado(String nombre) {

        empleado.setNombre(nombre);

    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

}
