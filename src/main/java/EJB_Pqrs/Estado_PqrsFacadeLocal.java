/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Pqrs;

import Entity_Pqrs.Estado_Pqrs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface Estado_PqrsFacadeLocal {

    void create(Estado_Pqrs estado_Pqrs);

    void edit(Estado_Pqrs estado_Pqrs);

    void remove(Estado_Pqrs estado_Pqrs);

    Estado_Pqrs find(Object id);

    List<Estado_Pqrs> findAll();

    List<Estado_Pqrs> findRange(int[] range);

    int count();
    
}
