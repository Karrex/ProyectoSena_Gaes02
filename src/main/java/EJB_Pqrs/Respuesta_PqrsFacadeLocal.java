/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Pqrs;

import Entity_Pqrs.Respuesta_Pqrs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface Respuesta_PqrsFacadeLocal {

    void create(Respuesta_Pqrs respuesta_Pqrs);

    void edit(Respuesta_Pqrs respuesta_Pqrs);

    void remove(Respuesta_Pqrs respuesta_Pqrs);

    Respuesta_Pqrs find(Object id);

    List<Respuesta_Pqrs> findAll();

    List<Respuesta_Pqrs> findRange(int[] range);

    int count();
    
    public Object findByPqrsId(int id_pqrs);

    public Object findByRespuesta(String pqrs);

    public Object findByPqrsIdS(int id_pqrs);
    
}
