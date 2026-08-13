
package org.miguelio.model;

public class Autor {
//atributos de clase  
    private long id;
    private String Nombre;
    private String Apellido;
    private String Nacionalidad;
    private String Biografia;
     //contructores
    public Autor (){
    }
    public Autor(long id, String nombre, String apellido, String nacionalidad, String biografia) {
            this.id = id;
            this.Nombre = nombre;
            this.Apellido = apellido;
            this.Nacionalidad = nacionalidad;
            this.Biografia = biografia;
    }

    public Autor(String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getBiografia() {
        return Biografia;
    }

    public void setBiografia(String Biografia) {
        this.Biografia = Biografia;
    }

 
    }

    //getter and setters
    

