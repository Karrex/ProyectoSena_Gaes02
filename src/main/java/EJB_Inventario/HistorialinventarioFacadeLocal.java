/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Inventario;

import Entity_Inventario.Historialinventario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface HistorialinventarioFacadeLocal {

    void create(Historialinventario historialinventario);

    void edit(Historialinventario historialinventario);

    void remove(Historialinventario historialinventario);

    Historialinventario find(Object id);

    List<Historialinventario> findAll();

    List<Historialinventario> findRange(int[] range);

    int count();
    
}
