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
public class Cliente extends Persona implements Serializable{
    
    private int idCliente;
    private String codigoCliente;
 
    private int max;// Atributos para adquirir el numero maximo de id en la base de datos;

    public Cliente() {
    }

    public Cliente(int idCliente, String codigoCliente,  String nombre, String apellido, String telefono, String direccion) {
        super(nombre, apellido, telefono, direccion);
        this.idCliente = idCliente;
        this.codigoCliente = codigoCliente;
        
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
    
    
}
