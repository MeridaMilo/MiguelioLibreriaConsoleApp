
package org.miguelio.model;

//POJO: Nombre, atributos de clase, constructores, metodos(get y set) otros...
//encapssulación, herencia, polimorfismo, abstractión
public class Usuario {
    //id,nombre, rol
    private int passwordHash;
    private String username;
    

    public Usuario() {
    }

    public Usuario(int passwordHash, String username) {
        this.passwordHash = passwordHash;
        this.username = username;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getpasswordHash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
           
}