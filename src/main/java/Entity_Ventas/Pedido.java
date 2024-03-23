/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Ventas;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CFL
 */


@Entity
@Table(name = "Pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIDPedido", query = "SELECT p FROM Pedido p WHERE p.iDPedido = :iDPedido"),
    @NamedQuery(name = "Pedido.findByFechaPedido", query = "SELECT p FROM Pedido p WHERE p.fechaPedido = :fechaPedido")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Pedido")
    private Integer iDPedido;

    @Column(name = "Fecha_Pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @JoinColumn(name = "ID_Estado_Pedido_ID", referencedColumnName = "ID_estado_pedido")
    @ManyToOne
    private EstadoPedido iDEstadoPedidoID;

    @JoinColumn(name = "ID_Ventaid", referencedColumnName = "ID_Venta")
    @ManyToOne
    private Venta iDVentaid;

    public Integer getiDPedido() {
        return iDPedido;
    }

    public void setiDPedido(Integer iDPedido) {
        this.iDPedido = iDPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getiDEstadoPedidoID() {
        return iDEstadoPedidoID;
    }

    public void setiDEstadoPedidoID(EstadoPedido iDEstadoPedidoID) {
        this.iDEstadoPedidoID = iDEstadoPedidoID;
    }

    public Venta getiDVentaid() {
        return iDVentaid;
    }

    public void setiDVentaid(Venta iDVentaid) {
        this.iDVentaid = iDVentaid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.iDPedido);
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
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.iDPedido, other.iDPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" + "iDPedido=" + iDPedido + '}';
    }
    
    
}
