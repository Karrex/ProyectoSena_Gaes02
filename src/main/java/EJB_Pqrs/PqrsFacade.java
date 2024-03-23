/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB_Pqrs;

import Entity_Pqrs.Pqrs;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CFL
 */
@Stateless
public class PqrsFacade extends AbstractFacade<Pqrs> implements PqrsFacadeLocal {

    @PersistenceContext(unitName = "pu/ushuaia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PqrsFacade() {
        super(Pqrs.class);
    }
    
    @Override
    public Pqrs getDatosPqrs(Integer ID_PQRS) {
        Pqrs datosPqrs = new Pqrs();
        try {
            datosPqrs = (Pqrs) em.createNamedQuery("Pqrs.findByUsuarioId_usuario")
                    .setParameter("usuarioId_usuario", ID_PQRS)
                    .getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPqrs;
    }

    @Override
    public List<Pqrs> getDatePqr(int intgr) {
        List<Pqrs> listPqr = null;

        try {
            listPqr = em.createNamedQuery("Pqrs.findByUsuarioId_usuario")
                    .setParameter("usuarioId_usuario", intgr)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listPqr;
    }

    @Override
    public List<Pqrs> getDatePqrs(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pqrs> findByUsuarioId(int idUsuario) {
        try {
            Query query = em.createQuery("SELECT p FROM Pqrs p WHERE p.Usuario.Id_Usuario = :Id_Usuario");
            query.setParameter("Id_Usuario", idUsuario);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PqrsFacade.class.getName()).log(Level.SEVERE, "Error al buscar PQRS por usuario", e);
            return null;
        }
    }

    @Override
    public long countPqrsByUsuarioYFecha(int Id_Usuario, Date fecha) {
        try {
            Query query = em.createQuery("SELECT COUNT(p) FROM Pqrs p WHERE p.Usuario.Id_Usuario = :Id_Usuario AND FUNCTION('DATE', p.FechaCreacion) = FUNCTION('DATE', :fecha)");
            query.setParameter("Id_Usuario", Id_Usuario);
            query.setParameter("fecha", fecha);
            return (long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0;
        }
    }
    
}
