/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Inventario;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CFL
 */
@Entity
@Table(name = "ORDENES_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesCompra.findAll", query = "SELECT o FROM OrdenesCompra o"),
    @NamedQuery(name = "OrdenesCompra.findByIDOrdencompra", query = "SELECT o FROM OrdenesCompra o WHERE o.iDOrdencompra = :iDOrdencompra"),
    @NamedQuery(name = "OrdenesCompra.findByFechaOrden", query = "SELECT o FROM OrdenesCompra o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "OrdenesCompra.findByDescripcionCompra", query = "SELECT o FROM OrdenesCompra o WHERE o.descripcionCompra = :descripcionCompra"),
    @NamedQuery(name = "OrdenesCompra.findByTotalCompra", query = "SELECT o FROM OrdenesCompra o WHERE o.totalCompra = :totalCompra"),
    @NamedQuery(name = "OrdenesCompra.findByValorUnitario", query = "SELECT o FROM OrdenesCompra o WHERE o.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "OrdenesCompra.findByEstadoOrden", query = "SELECT o FROM OrdenesCompra o WHERE o.estadoOrden = :estadoOrden")})
public class OrdenesCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Orden_compra")
    private Integer iDOrdencompra;
    @Column(name = "Fecha_Orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @Size(max = 255)
    @Column(name = "Descripcion_Compra")
    private String descripcionCompra;
    @Column(name = "Total_Compra")
    private Long totalCompra;
    @Column(name = "Valor_Unitario")
    private Long valorUnitario;
    @Size(max = 200)
    @Column(name = "Estado_Orden")
    private String estadoOrden;
    @JoinColumn(name = "ID_Proveedorid", referencedColumnName = "ID_Proveedor")
    @ManyToOne
    private Proveedores iDProveedorid;

    public OrdenesCompra() {
    }

    public OrdenesCompra(Integer iDOrdencompra) {
        this.iDOrdencompra = iDOrdencompra;
    }

    public Integer getIDOrdencompra() {
        return iDOrdencompra;
    }

    public void setIDOrdencompra(Integer iDOrdencompra) {
        this.iDOrdencompra = iDOrdencompra;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getDescripcionCompra() {
        return descripcionCompra;
    }

    public void setDescripcionCompra(String descripcionCompra) {
        this.descripcionCompra = descripcionCompra;
    }

    public Long getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Long totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(String estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public void setProductosList(List<Productos> productosList) {
    }

    public Proveedores getIDProveedorid() {
        return iDProveedorid;
    }

    public void setIDProveedorid(Proveedores iDProveedorid) {
        this.iDProveedorid = iDProveedorid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.iDOrdencompra);
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
        final OrdenesCompra other = (OrdenesCompra) obj;
        return Objects.equals(this.iDOrdencompra, other.iDOrdencompra);
    }

    @Override
    public String toString() {
        return "OrdenesCompra{" + "iDOrdencompra=" + iDOrdencompra + '}';
    }

    
    
}
