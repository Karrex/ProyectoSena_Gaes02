/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB_Pqrs;

import Entity_Pqrs.Respuesta_Pqrs;
import java.util.List;
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
public class Respuesta_PqrsFacade extends AbstractFacade<Respuesta_Pqrs> implements Respuesta_PqrsFacadeLocal {

    @PersistenceContext(unitName = "pu/ushuaia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Respuesta_PqrsFacade() {
        super(Respuesta_Pqrs.class);
    }
    
    @Override
    public List<Respuesta_Pqrs> findByPqrsId(int id_pqrs) {
        List<Respuesta_Pqrs> respuestas = null;

        try {
            respuestas = em.createNamedQuery("Respuesta_Pqrs.findByPqrsId", Respuesta_Pqrs.class)
                    .setParameter("id_pqrs", id_pqrs)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuestas;
    }

    @Override
    public Object findByRespuesta(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     @Override
    public List<Respuesta_Pqrs> findByPqrsIdS(int pqrsId) {
        try {
            Query query = em.createQuery("SELECT r FROM Respuesta_Pqrs r WHERE r.pqrs.ID_PQRS = :pqrsId");
            query.setParameter("pqrsId", pqrsId);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
