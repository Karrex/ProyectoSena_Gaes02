/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity_Inventario;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "PROVEEDORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByIDProveedor", query = "SELECT p FROM Proveedores p WHERE p.iDProveedor = :iDProveedor"),
    @NamedQuery(name = "Proveedores.findByNombreProveedor", query = "SELECT p FROM Proveedores p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedores.findByContactoproveedor", query = "SELECT p FROM Proveedores p WHERE p.contactoproveedor = :contactoproveedor"),
    @NamedQuery(name = "Proveedores.findByDireccionProveedor", query = "SELECT p FROM Proveedores p WHERE p.direccionProveedor = :direccionProveedor")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Proveedor")
    private Integer iDProveedor;
    @Size(max = 200)
    @Column(name = "Nombre_Proveedor")
    private String nombreProveedor;
    @Column(name = "Contacto_proveedor")
    private Integer contactoproveedor;
    @Size(max = 200)
    @Column(name = "Direccion_Proveedor")
    private String direccionProveedor;

    public Proveedores() {
    }

    public Proveedores(Integer iDProveedor) {
        this.iDProveedor = iDProveedor;
    }

    public Integer getIDProveedor() {
        return iDProveedor;
    }

    public void setIDProveedor(Integer iDProveedor) {
        this.iDProveedor = iDProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getContactoproveedor() {
        return contactoproveedor;
    }

    public void setContactoproveedor(Integer contactoproveedor) {
        this.contactoproveedor = contactoproveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public void setOrdenesCompraList(List<OrdenesCompra> ordenesCompraList) {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.iDProveedor);
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
        final Proveedores other = (Proveedores) obj;
        return Objects.equals(this.iDProveedor, other.iDProveedor);
    }

    @Override
    public String toString() {
        return "Proveedores{" + "iDProveedor=" + iDProveedor + '}';
    }

    
    
}
