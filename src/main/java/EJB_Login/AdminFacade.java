/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB_Login;

import Entity_Login.Admin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CFL
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeLocal {

    @PersistenceContext(unitName = "pu/ushuaia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }
    
    @Override
    public Admin getDatosAdmin(Integer Id_Admin) {
        Admin datosAdmin = Admin();
        try {
            datosAdmin = (Admin) em.createNamedQuery("Admin.findByUsuarioId_usuario")
                    .setParameter("usuarioId_usuario", Id_Admin)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosAdmin;
    }

    private Admin Admin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Admin> getDateAdmin(int intgr) {
        List<Admin> listAdmin = null;
        try {
            listAdmin = em.createNamedQuery("Admin.findByUsuarioId_usuario")
                    .setParameter("usuarioId_usuario", intgr)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listAdmin;
    }

    @Override
    public List<Admin> getDateadmin(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
