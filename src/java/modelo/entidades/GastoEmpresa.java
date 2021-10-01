

package modelo.entidades;
import java.util.Date;
//Asociacion, Agregacion y herencia
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GastoEmpresa {
    private int idGasto;
    private String codigoGastos;
    private Date fecha;
    private String categoria;
    private double saldo;
    private Empresa empresa; //Asociacion 
    private Empleados empleado;

    public GastoEmpresa(int idGasto, Date fecha, String categoria, double saldo) {
        this.idGasto = idGasto;
        this.fecha = fecha;
        this.categoria = categoria;
        this.saldo = saldo;
    }

    public GastoEmpresa(String codigoGastos, Date fecha, String categoria, double saldo, Empresa empresa) {
        this.codigoGastos = codigoGastos;
        this.fecha = fecha;
        this.categoria = categoria;
        this.saldo = saldo;
        this.empresa = empresa;
    }

    public GastoEmpresa(String codigoGastos, Date fecha, String categoria, double saldo) {
        this.codigoGastos = codigoGastos;
        this.fecha = fecha;
        this.categoria = categoria;
        this.saldo = saldo;
    }

    public GastoEmpresa(String codigoGastos, Date fecha, String categoria, double saldo, Empleados empleado) {
        this.codigoGastos = codigoGastos;
        this.fecha = fecha;
        this.categoria = categoria;
        this.saldo = saldo;
        this.empleado = empleado;
    }

    public GastoEmpresa(String codigoGastos, Date fecha, String categoria, double saldo, Empresa empresa, Empleados empleado) {
        this.codigoGastos = codigoGastos;
        this.fecha = fecha;
        this.categoria = categoria;
        this.saldo = saldo;
        this.empresa = empresa;
        this.empleado = empleado;
    }
    public GastoEmpresa() {
        }
    public GastoEmpresa(Empleados empleado) {
        this.empleado = empleado;
    }
   

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public String getCodigoGastos() {
        return codigoGastos;
    }

    public void setCodigoGastos(String codigoGastos) {
        this.codigoGastos = codigoGastos;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

 

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }   

}
