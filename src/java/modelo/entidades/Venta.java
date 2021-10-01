
package modelo.entidades;

import java.util.ArrayList;
import java.util.Date;


public class Venta {
   private int  idFactura;
   private String  nFactura;
   private Date fechaVenta;
   private double saldoTotal;
   private int estado;
   private ArrayList<Registros> registros;
   private Cliente cliente;
   private Empleados empleado;
   private Empresa empresa;
   
   
    

    public Venta() {
    }

    public Venta(int idFactura) {
        this.idFactura = idFactura;
    }
    

    public Venta(int idFactura, Date fechaVenta, double saldoTotal) {
        this.idFactura = idFactura;
        this.fechaVenta = fechaVenta;
        this.saldoTotal = saldoTotal;
    }

    public Venta(Date fechaVenta, double saldoTotal) {
        this.fechaVenta = fechaVenta;
        this.saldoTotal = saldoTotal;
    }

    public Venta(int idFactura, Date fechaVenta, double saldoTotal, ArrayList<Registros> registros, Empleados empleado) {
        this.idFactura = idFactura;
        this.fechaVenta = fechaVenta;
        this.saldoTotal = saldoTotal;
        this.registros = registros;
        this.empleado = empleado;
    }

    public Venta(int idFactura, String nFactura, Date fechaVenta, double saldoTotal, ArrayList<Registros> registros, Cliente cliente, Empleados empleado) {
        this.idFactura = idFactura;
        this.nFactura = nFactura;
        this.fechaVenta = fechaVenta;
        this.saldoTotal = saldoTotal;
        this.registros = registros;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Venta(int idFactura, String nFactura, Date fechaVenta, Cliente cliente, Empleados empleado, Empresa empresa) {
        this.idFactura = idFactura;
        this.nFactura = nFactura;
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.empresa = empresa;
    }

    public Venta(String nFactura, Date fechaVenta, double saldoTotal,Cliente cliente, Empleados empleado) {
        this.nFactura = nFactura;
        this.fechaVenta = fechaVenta;
        this.saldoTotal = saldoTotal;

        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Venta(String nFactura, Date fechaVenta,  Cliente cliente, Empleados empleado,double saldoTotal) {
        this.nFactura = nFactura;
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.saldoTotal = saldoTotal;
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
    public void setNombreCliente(){

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

    public ArrayList<Registros> getRegistros() {
        return registros;
    }
    
    public void addRegistro(Registros x){
       registros.add(x);   
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

    public void setRegistros(ArrayList<Registros> registros) {
        this.registros = registros;
    }
    
    

  
}
