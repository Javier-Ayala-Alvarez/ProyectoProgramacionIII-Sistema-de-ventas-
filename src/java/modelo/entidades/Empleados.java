package modelo.entidades;
import java.util.ArrayList;
import java.util.Date;

public class Empleados extends Persona{
    private int idUsuario;
    private int idEmpleado;
    private String cargoEmpleado,codigoEmpleado;
    private double salarioEmpleado, afp, isss;
    private Date fechaContratacion;
    private Usuario usuario;
    private Empresa empresa;
    private ArrayList<Venta> ventas;
    private int estado;

    public Empleados(int idUsuario, int idEmpleado, String cargoEmpleado, String codigoEmpleado, double salarioEmpleado, double afp, double isss, Date fechaContratacion, Usuario usuario, Empresa empresa, ArrayList<Venta> ventas, int estado, int idPersona) {
        super(idPersona);
        this.idUsuario = idUsuario;
        this.idEmpleado = idEmpleado;
        this.cargoEmpleado = cargoEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.afp = afp;
        this.isss = isss;
        this.fechaContratacion = fechaContratacion;
        this.usuario = usuario;
        this.empresa = empresa;
        this.ventas = ventas;
        this.estado = estado;
    }

   

    public Empleados() {
        ventas = new ArrayList();
    }

    public Empleados(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleados(int idUsuario, int idEmpleado, String cargoEmpleado, String codigoEmpleado, double salarioEmpleado, double afp, double isss, Date fechaContratacion, Usuario usuario,Empresa empresa, int estado, int idPersona) {
        super(idPersona);
        this.idUsuario = idUsuario;
        this.idEmpleado = idEmpleado;
        this.cargoEmpleado = cargoEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.afp = afp;
        this.isss = isss;
        this.fechaContratacion = fechaContratacion;
        this.usuario = usuario;
        this.empresa = empresa;
        this.estado = estado;
    }


    public Empleados(String cargoEmpleado, double salarioEmpleado, double afp, double isss, Date fechaContratacion, String nombre, String apellido, String telefono, String direccion) {
        super(nombre, apellido, telefono, direccion);
        this.cargoEmpleado = cargoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.afp = afp;
        this.isss = isss;
        this.fechaContratacion = fechaContratacion;
        
        ventas = new ArrayList();
    }

    public Empleados(String cargoEmpleado, String codigoEmpleado, double salarioEmpleado, double afp, double isss, Date fechaContratacion, int estado, String nombre, String apellido, String telefono, String direccion) {
        super(nombre, apellido, telefono, direccion);
        this.cargoEmpleado = cargoEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
        this.afp = afp;
        this.isss = isss;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
    }

    public Empleados(int idUsuario, String cargoEmpleado) {
        this.idUsuario = idUsuario;
        this.cargoEmpleado = cargoEmpleado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
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

    public void addVenta(Venta x){
        ventas.add(x);
    }

    public void addUsuario(Usuario x){
        this.usuario = x;
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
