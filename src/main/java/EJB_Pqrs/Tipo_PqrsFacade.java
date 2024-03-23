/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB_Pqrs;

import Entity_Pqrs.Tipo_Pqrs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CFL
 */
@Stateless
public class Tipo_PqrsFacade extends AbstractFacade<Tipo_Pqrs> implements Tipo_PqrsFacadeLocal {

    @PersistenceContext(unitName = "pu/ushuaia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Tipo_PqrsFacade() {
        super(Tipo_Pqrs.class);
    }
    
}
