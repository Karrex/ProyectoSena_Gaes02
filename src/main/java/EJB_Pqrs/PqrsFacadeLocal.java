/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Pqrs;

import Entity_Pqrs.Pqrs;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface PqrsFacadeLocal {

    void create(Pqrs pqrs);

    void edit(Pqrs pqrs);

    void remove(Pqrs pqrs);

    Pqrs find(Object id);

    List<Pqrs> findAll();

    List<Pqrs> findRange(int[] range);

    int count();
    
    public Pqrs getDatosPqrs(Integer ID_PQRS);

    public List<Pqrs> getDatePqr(int id_Usuario);

    public List<Pqrs> getDatePqrs(int id_Usuario);

    public List<Pqrs> findByUsuarioId(int idUsuario);

    public long countPqrsByUsuarioYFecha(int idUsuario, Date fecha);
    
    
}
