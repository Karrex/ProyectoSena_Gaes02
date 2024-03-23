/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Pqrs;

import Entity_Pqrs.Tipo_Pqrs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface Tipo_PqrsFacadeLocal {

    void create(Tipo_Pqrs tipo_Pqrs);

    void edit(Tipo_Pqrs tipo_Pqrs);

    void remove(Tipo_Pqrs tipo_Pqrs);

    Tipo_Pqrs find(Object id);

    List<Tipo_Pqrs> findAll();

    List<Tipo_Pqrs> findRange(int[] range);

    int count();
    
}
