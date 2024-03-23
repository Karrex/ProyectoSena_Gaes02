package Entity_Login;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author CFL
 */

@Entity
@Table(name = "cliente")
@NamedQueries({
@NamedQuery(name = "cliente.findAll", query = "SELECT c FROM Cliente c"),
@NamedQuery(name = "cliente.findByEdad", query = "SELECT c FROM Cliente c WHERE c.Edad = :Edad"),
@NamedQuery(name = "Cliente.finByUseriUser", query = "SELECT c FROM Cliente c WHERE C.usuario = :usuario")})

public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Cliente;

    @Column(name = "Edad")
    private int Edad;

    @OneToOne
    @JoinColumn(name = "Id_Usuario")
    private Usuario usuario;

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.Id_Cliente;
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
        final Cliente other = (Cliente) obj;
        return this.Id_Cliente == other.Id_Cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Id_Cliente=" + Id_Cliente + '}';
    }

    public void setUsuarioId_Usuario(int id_Usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
