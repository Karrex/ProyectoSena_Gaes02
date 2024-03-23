/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Inventario;


import EJB_Inventario.EstadoProductoFacadeLocal;
import Entity_Inventario.EstadoProducto;
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
public class ControllerEstadoProducto implements Serializable{
    
    @EJB
    private EstadoProductoFacadeLocal estadoProductoFacade;
    private List<EstadoProducto> listaEstadoProducto;
    private EstadoProducto estadoProducto;

    public List<EstadoProducto> getListaEstadoProducto() {
        this.listaEstadoProducto = this.estadoProductoFacade.findAll();
        return listaEstadoProducto;
    }

    public void setListaEstadoProducto(List<EstadoProducto> listaEstadoProducto) {
        this.listaEstadoProducto = listaEstadoProducto;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
    
    
    @PostConstruct
    public void init () {
        this.estadoProducto = new EstadoProducto();
        
    }
}
