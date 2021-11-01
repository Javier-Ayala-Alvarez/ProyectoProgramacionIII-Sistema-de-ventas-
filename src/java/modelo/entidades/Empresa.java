

package modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Empresa implements Serializable {
    private int IdEmpresa;
    private String codigoEmpresa;
    private String nombre,direccion,correo;


    public Empresa() {
    }
    

    public Empresa(int IdEmpresa, String nombre, String direccion, String correo) {
        this.IdEmpresa = IdEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;

    }

    public Empresa(String codigoEmpresa, String nombre, String direccion, String correo) {
        this.codigoEmpresa = codigoEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

  
    

    public Empresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
    }
    
    
    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

     
     

}
