/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Ventas;

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
@Table(name = "Estado_Pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPedido.findAll", query = "SELECT e FROM EstadoPedido e"),
    @NamedQuery(name = "EstadoPedido.findByIDestadopedido", query = "SELECT e FROM EstadoPedido e WHERE e.iDestadopedido = :iDestadopedido"),
    @NamedQuery(name = "EstadoPedido.findByEstadopedido", query = "SELECT e FROM EstadoPedido e WHERE e.estadopedido = :estadopedido")})
public class EstadoPedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_estado_pedido")
    private Integer iDestadopedido;
    
    @Size(max = 45)
    @Column(name = "Estado_pedido")
    private String estadopedido;

    public Integer getiDestadopedido() {
        return iDestadopedido;
    }

    public void setiDestadopedido(Integer iDestadopedido) {
        this.iDestadopedido = iDestadopedido;
    }

    public String getEstadopedido() {
        return estadopedido;
    }

    public void setEstadopedido(String estadopedido) {
        this.estadopedido = estadopedido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.iDestadopedido);
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
        final EstadoPedido other = (EstadoPedido) obj;
        return Objects.equals(this.iDestadopedido, other.iDestadopedido);
    }

    @Override
    public String toString() {
        return "EstadoPedido{" + "iDestadopedido=" + iDestadopedido + '}';
    }
    
    
    
}
