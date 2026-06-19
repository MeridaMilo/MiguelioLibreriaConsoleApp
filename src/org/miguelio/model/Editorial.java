package org.miguelio.model;

import java.util.logging.Logger;

public class Editorial {
   //nit varchar(20) primary key,
    //nombre_editorial varchar(100) not null,
    //telefono_editorial varchar(15),
   // direccion_editoria varchar(100)
   String Nit; 
   String nombre;
   String telefono;
   String direccion;
 //Constructores 

    public Editorial() {
    }

    public Editorial(String nit, String nombre, String telefono, String direccion) {
        this.Nit = Nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
// Getter and setters 

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
