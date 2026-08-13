package org.miguelio.model;

public class Autor {
    //atributos de clase
    private long cui;
    private String nombre;
    private String apellido;
    private String correoElectronico;

    //constructores
    public Autor() {
    }

    public Autor(long cui, String nombre, String apellido, String correoElectronico) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
    }
    
    //getter and setters
}

