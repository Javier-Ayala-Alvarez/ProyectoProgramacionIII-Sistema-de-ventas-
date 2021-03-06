package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import modelo.dao.EmpresaDao;

public class Producto implements Serializable{

    private int idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private double precioCompra;
    private int cantidad;
    private Date fechaVencimiento;
    private int max;

    private int estado;
    private double gananciaUni;
    private double precioVenta;
    private Empresa empresa;

    public Producto() {

    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto( String codigoProducto, String nombreProducto, double precioCompra, int cantidad, Date fechaVencimiento, int estado, double precioVenta, Empresa empresa) {
        
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.precioVenta = precioVenta;
        this.empresa = empresa;
    }
//Id,codigo,Nombre,compra,canidad,fecha,venta,empresa
    public Producto(int idProducto, String codigoProducto, String nombreProducto, double precioCompra, int cantidad, Date fechaVencimiento, int estado, double precioVenta, Empresa empresa) {
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.precioVenta = precioVenta;
        this.empresa = empresa;
    }

    

    

   

   

    public int getIdProducto() {
        return idProducto;
    }

    public Producto(String codigoProducto, String nombreProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

    public double getGananciaUni() {
        return gananciaUni;
    }

    public void setGananciaUni(double gananciaUni) {
        this.gananciaUni = gananciaUni;
    }

    

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Empresa getEmpresa() {
       

        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
