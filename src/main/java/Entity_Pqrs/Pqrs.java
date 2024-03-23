/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Pqrs;

import Entity_Login.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author CFL
 */


@Entity
@Table(name = "PQRS")
public class Pqrs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_PQRS;

    @ManyToOne
    @JoinColumn(name = "Id_Usuario")
    private Usuario Usuario;
    
    @ManyToOne
    @JoinColumn(name = "Id_Tipo")
    private Tipo_Pqrs Tipo;
    
    @Column(name = "FechaCreacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaCreacion;
    
    @ManyToOne
    @JoinColumn(name = "Id_Estado")
    private Estado_Pqrs Estado;
    
    @Column(name = "Descripcion")
    private String Descripcion;

    public int getID_PQRS() {
        return ID_PQRS;
    }

    public void setID_PQRS(int ID_PQRS) {
        this.ID_PQRS = ID_PQRS;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public Tipo_Pqrs getTipo() {
        return Tipo;
    }

    public void setTipo(Tipo_Pqrs Tipo) {
        this.Tipo = Tipo;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Estado_Pqrs getEstado() {
        return Estado;
    }

    public void setEstado(Estado_Pqrs Estado) {
        this.Estado = Estado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.ID_PQRS;
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
        final Pqrs other = (Pqrs) obj;
        return this.ID_PQRS == other.ID_PQRS;
    }

    @Override
    public String toString() {
        return "Pqrs{" + "ID_PQRS=" + ID_PQRS + '}';
    }

    public void setPqrsID_PQRS(int id_pqrs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setPqrs(Pqrs pqrs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setEstado_Pqrs(Estado_Pqrs estado_pqrs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
