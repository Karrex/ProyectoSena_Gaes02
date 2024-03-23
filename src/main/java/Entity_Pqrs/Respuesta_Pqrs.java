/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Pqrs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author CFL
 */

@Entity
@Table(name = "Respuestas_PQRS")
@NamedQuery(name = "Respuesta_Pqrs.findByPqrsId", query = "SELECT r FROM Respuesta_Pqrs r WHERE r.pqrs.ID_PQRS = :id_pqrs")
public class Respuesta_Pqrs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Respuesta;

    @ManyToOne
    @JoinColumn(name = "ID_PQRS")
    private Pqrs pqrs;
    


    @Column(name = "FechaRespuesta")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaRespuesta;

    @Column(name = "Respuesta")
    private String Respuesta;

    public int getID_Respuesta() {
        return ID_Respuesta;
    }

    public void setID_Respuesta(int ID_Respuesta) {
        this.ID_Respuesta = ID_Respuesta;
    }

    public Pqrs getPqrs() {
        return pqrs;
    }

    public void setPqrs(Pqrs pqrs) {
        this.pqrs = pqrs;
    }

    public Date getFechaRespuesta() {
        return FechaRespuesta;
    }

    public void setFechaRespuesta(Date FechaRespuesta) {
        this.FechaRespuesta = FechaRespuesta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.ID_Respuesta;
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
        final Respuesta_Pqrs other = (Respuesta_Pqrs) obj;
        return this.ID_Respuesta == other.ID_Respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta_Pqrs{" + "ID_Respuesta=" + ID_Respuesta + '}';
    }

}
