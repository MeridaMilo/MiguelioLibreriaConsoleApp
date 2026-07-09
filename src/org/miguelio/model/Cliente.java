package org.miguelio.model;

/**
 *
 * @author informatica
 */
public class Cliente {
    /*
create table clientes(
	cui bigint primary key,
    nombre_cliente varchar(100),
    apellido_cliente varchar(100),
    correo_electronico varchar(100)
);
    */
 // atributos clase
  // verificar todo
    // cambios para guardar programa
    long cui;
    String nombre;
    String apellido;
    String correoElectronico;
    
    // construsctures
    public Cliente() {
    }
    
    public Cliente(long cui, String nombre, String apellido, String correoElectronico){
     this.cui = cui;
     this.nombre = nombre;
     this.apellido = apellido;
     this.correoElectronico = correoElectronico;
     
    }

    public long getCui() {
        return cui;
    }

    public void setCui(long cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
            // Validacion: Cambiar mayuscula, 
            String nombreMayusculas = nombre.toUpperCase();
        this.nombre = nombreMayusculas;
  
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
}
