/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Ventas;

import Entity_Ventas.Detallefactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface DetallefacturaFacadeLocal {

    void create(Detallefactura detallefactura);

    void edit(Detallefactura detallefactura);

    void remove(Detallefactura detallefactura);

    Detallefactura find(Object id);

    List<Detallefactura> findAll();

    List<Detallefactura> findRange(int[] range);

    int count();
    
}
