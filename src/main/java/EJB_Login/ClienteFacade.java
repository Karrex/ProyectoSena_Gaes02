/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB_Login;

import Entity_Login.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CFL
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "pu/ushuaia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    @Override
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

    @Override
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

    @Override
    public List<Cliente> getDateCliente(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
