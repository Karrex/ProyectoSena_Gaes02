/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Inventario;

import Entity_Inventario.Carta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface CartaFacadeLocal {

    void create(Carta carta);

    void edit(Carta carta);

    void remove(Carta carta);

    Carta find(Object id);

    List<Carta> findAll();

    List<Carta> findRange(int[] range);

    int count();
    
}
