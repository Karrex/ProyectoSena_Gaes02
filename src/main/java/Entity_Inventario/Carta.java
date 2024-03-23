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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "CARTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carta.findAll", query = "SELECT c FROM Carta c"),
    @NamedQuery(name = "Carta.findByIDCarta", query = "SELECT c FROM Carta c WHERE c.iDCarta = :iDCarta"),
    @NamedQuery(name = "Carta.findByTiempoPreparacion", query = "SELECT c FROM Carta c WHERE c.tiempoPreparacion = :tiempoPreparacion"),
    @NamedQuery(name = "Carta.findByNombrefoto", query = "SELECT c FROM Carta c WHERE c.nombrefoto = :nombrefoto")})
public class Carta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Carta")
    private Integer iDCarta;
    @Column(name = "TiempoPreparacion")
    private Integer tiempoPreparacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "Ingredientes")
    private String ingredientes;
    @Lob
    @Column(name = "Imagen")
    private byte[] imagen;
    @Size(max = 200)
    @Column(name = "Nombre_foto")
    private String nombrefoto;
    
    @JoinColumn(name = "ID_Estado_Productos", referencedColumnName = "ID_Estado_producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoProducto iDEstadoProductos;
    @JoinColumn(name = "Id_productosid", referencedColumnName = "ID_Producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Productos idproductosid;

    public Carta() {
    }

    public Carta(Integer iDCarta) {
        this.iDCarta = iDCarta;
    }

    public Integer getIDCarta() {
        return iDCarta;
    }

    public void setIDCarta(Integer iDCarta) {
        this.iDCarta = iDCarta;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getNombrefoto() {
        return nombrefoto;
    }

    public void setNombrefoto(String nombrefoto) {
        this.nombrefoto = nombrefoto;
    }

    public EstadoProducto getIDEstadoProductos() {
        return iDEstadoProductos;
    }

    public void setIDEstadoProductos(EstadoProducto iDEstadoProductos) {
        this.iDEstadoProductos = iDEstadoProductos;
    }

    public Productos getIdproductosid() {
        return idproductosid;
    }

    public void setIdproductosid(Productos idproductosid) {
        this.idproductosid = idproductosid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.iDCarta);
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
        final Carta other = (Carta) obj;
        return Objects.equals(this.iDCarta, other.iDCarta);
    }

    @Override
    public String toString() {
        return "Carta{" + "iDCarta=" + iDCarta + '}';
    }
    
    

    

    
}
