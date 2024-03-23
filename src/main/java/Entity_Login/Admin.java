package Entity_Login;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CFL
 */
@Entity
@Table(name = "admin")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Admin;

    @Column(name = "Cargo")
    private String Cargo;

    @OneToOne
    @JoinColumn(name = "Id_Usuario")
    private Usuario usuario;

    @PersistenceContext
    private transient EntityManager em;

    public int getId_Admin() {
        return Id_Admin;
    }

    public void setId_Admin(int Id_Admin) {
        this.Id_Admin = Id_Admin;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.Id_Admin;
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
        final Admin other = (Admin) obj;
        return this.Id_Admin == other.Id_Admin;
    }

    @Override
    public String toString() {
        return "Admin{" + "Id_Admin=" + Id_Admin + '}';
    }
    
    

    public Cliente getDatosCliente(Integer Id_Cliente) {
        Cliente datosCliente = new Cliente();
        try {
            datosCliente = (Cliente) em.createNamedQuery("Cliente.findByUsuarioId_usuario")
                    .setParameter("usuarioId_usuario", Id_Cliente)
                    .getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return datosCliente;
    }

    public List<Cliente> getDateClient(int intgr) {
        List<Cliente> listClient = null;

        try {
            listClient = em.createNamedQuery("Cliente.findByUsuarioId_usuario")
                    .setParameter("usuarioId_usuario", intgr)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listClient;
    }

    public List<Cliente> getDateCliente(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
