/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Ventas;

import Entity_Inventario.Carta;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CFL
 */


@Entity
@Table(name = "DetalleFactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d"),
    @NamedQuery(name = "Detallefactura.findByIDdetalleFactura", query = "SELECT d FROM Detallefactura d WHERE d.iDdetalleFactura = :iDdetalleFactura"),
    @NamedQuery(name = "Detallefactura.findByCantidad", query = "SELECT d FROM Detallefactura d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detallefactura.findByPrecioUnitario", query = "SELECT d FROM Detallefactura d WHERE d.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "Detallefactura.findBySubtotal", query = "SELECT d FROM Detallefactura d WHERE d.subtotal = :subtotal")})
public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_detalleFactura")
    private Integer iDdetalleFactura;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Precio_Unitario")
    private BigDecimal precioUnitario;

    @Column(name = "Subtotal")
    private BigDecimal subtotal;

    @JoinColumn(name = "ID_Cartaid", referencedColumnName = "ID_Carta")
    @ManyToOne
    private Carta iDCartaid;
    
    

    public Integer getiDdetalleFactura() {
        return iDdetalleFactura;
    }

    public void setiDdetalleFactura(Integer iDdetalleFactura) {
        this.iDdetalleFactura = iDdetalleFactura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Carta getiDCartaid() {
        return iDCartaid;
    }

    public void setiDCartaid(Carta iDCartaid) {
        this.iDCartaid = iDCartaid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.iDdetalleFactura);
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
        final Detallefactura other = (Detallefactura) obj;
        return Objects.equals(this.iDdetalleFactura, other.iDdetalleFactura);
    }

    @Override
    public String toString() {
        return "Detallefactura{" + "iDdetalleFactura=" + iDdetalleFactura + '}';
    }  
}
