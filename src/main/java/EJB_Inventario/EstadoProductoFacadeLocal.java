/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Inventario;

import Entity_Inventario.EstadoProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface EstadoProductoFacadeLocal {

    void create(EstadoProducto estadoProducto);

    void edit(EstadoProducto estadoProducto);

    void remove(EstadoProducto estadoProducto);

    EstadoProducto find(Object id);

    List<EstadoProducto> findAll();

    List<EstadoProducto> findRange(int[] range);

    int count();
    
}
