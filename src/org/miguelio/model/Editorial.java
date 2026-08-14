package org.miguelio.model;

public class Editorial {
   String nit; 
   String nombre;
   String telefono;
   String direccion;
 //Constructores 
    public Editorial() {
    }

    public Editorial(String nit, String nombre, String telefono, String direccion) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
// Getter and setters 
    
    
    public String getNit() {
        return nit;
    }
    
    public void setNit(String Nit) {
        this.nit = nit;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        String nombreMayusculas = nombre.toUpperCase();
        this.nombre = nombreMayusculas;
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
}
