/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Inventario;

import EJB_Inventario.HistorialinventarioFacadeLocal;
import Entity_Inventario.Historialinventario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author CFL
 */

@ManagedBean
@SessionScoped
public class ControllerHistorialinventario implements Serializable {

    @EJB
    private HistorialinventarioFacadeLocal historialinventarioFacade;
    private List<Historialinventario> listaHistorialinventario;
    private Historialinventario historialinventario;

    public List<Historialinventario> getListaHistorialinventario() {
        this.listaHistorialinventario = this.historialinventarioFacade.findAll();
        return listaHistorialinventario;
    }

    public void setListaHistorialinventario(List<Historialinventario> listaHistorialinventario) {
        this.listaHistorialinventario = listaHistorialinventario;
    }

    public Historialinventario getHistorialinventario() {
        return historialinventario;
    }

    public void setHistorialinventario(Historialinventario historialinventario) {
        this.historialinventario = historialinventario;
    }
    
    @PostConstruct
    public void init(){
        this.historialinventario = new Historialinventario();
        
    }
    
    
    
    
    
    
}
