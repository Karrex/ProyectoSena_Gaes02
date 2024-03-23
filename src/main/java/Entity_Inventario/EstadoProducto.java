/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Inventario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CFL
 */
@Entity
@Table(name = "ESTADO_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProducto.findAll", query = "SELECT e FROM EstadoProducto e"),
    @NamedQuery(name = "EstadoProducto.findByIDEstadoproducto", query = "SELECT e FROM EstadoProducto e WHERE e.iDEstadoproducto = :iDEstadoproducto"),
    @NamedQuery(name = "EstadoProducto.findByEstadoProducto", query = "SELECT e FROM EstadoProducto e WHERE e.estadoProducto = :estadoProducto")})
public class EstadoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Estado_producto")
    private Integer iDEstadoproducto;
    @Size(max = 200)
    @Column(name = "estado_producto")
    private String estadoProducto;

    public EstadoProducto() {
    }

    public EstadoProducto(Integer iDEstadoproducto) {
        this.iDEstadoproducto = iDEstadoproducto;
    }

    public Integer getIDEstadoproducto() {
        return iDEstadoproducto;
    }

    public void setIDEstadoproducto(Integer iDEstadoproducto) {
        this.iDEstadoproducto = iDEstadoproducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.iDEstadoproducto);
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
        final EstadoProducto other = (EstadoProducto) obj;
        return Objects.equals(this.iDEstadoproducto, other.iDEstadoproducto);
    }

    @Override
    public String toString() {
        return "EstadoProducto{" + "iDEstadoproducto=" + iDEstadoproducto + '}';
    }

    

    
    
}
