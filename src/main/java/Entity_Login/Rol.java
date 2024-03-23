/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Login;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author CFL
 */

@Entity
@Table (name ="Rol")
public class Rol implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id_rol;
    
    @Column(name = "Nombre")
    private String Nombre;

    public int getId_rol() {
        return Id_rol;
    }

    public void setId_rol(int Id_rol) {
        this.Id_rol = Id_rol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.Id_rol;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rol other = (Rol) obj;
        return this.Id_rol == other.Id_rol;
    }

    @Override
    public String toString() {
        return "Rol{" + "Id_rol=" + Id_rol + '}';
    }
}


