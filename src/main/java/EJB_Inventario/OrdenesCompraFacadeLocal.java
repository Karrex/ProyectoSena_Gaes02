/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Inventario;

import Entity_Inventario.OrdenesCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface OrdenesCompraFacadeLocal {

    void create(OrdenesCompra ordenesCompra);

    void edit(OrdenesCompra ordenesCompra);

    void remove(OrdenesCompra ordenesCompra);

    OrdenesCompra find(Object id);

    List<OrdenesCompra> findAll();

    List<OrdenesCompra> findRange(int[] range);

    int count();
    
}
