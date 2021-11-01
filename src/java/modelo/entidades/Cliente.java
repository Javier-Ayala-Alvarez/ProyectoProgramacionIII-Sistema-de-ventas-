/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.LinkedHashMap;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

/**
 *
 * @author gerar
 */
public class Cliente implements Serializable, JSONStreamAware{
    
    private int idCliente;
    private String codigoCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private int max;// Atributos para adquirir el numero maximo de id en la base de datos;

    public Cliente() {
    }

    public Cliente(int idCliente, String codigoCliente, String nombre, String apellido, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void writeJSONString(Writer out) throws IOException {
      LinkedHashMap obj = new LinkedHashMap();//un objeto que nos ayudara a mapear
      obj.put("codigo",codigoCliente);
      obj.put("nombre",nombre);
      obj.put("apellido",apellido);
      obj.put("telefono",telefono);
      obj.put("telefono",direccion);
      JSONValue.writeJSONString(obj, out);
    }
    
    
}
