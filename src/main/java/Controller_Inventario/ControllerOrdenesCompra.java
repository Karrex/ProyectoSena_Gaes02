/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Inventario;


import EJB_Inventario.OrdenesCompraFacadeLocal;
import Entity_Inventario.OrdenesCompra;
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
public class ControllerOrdenesCompra implements Serializable {
    
    @EJB
    private OrdenesCompraFacadeLocal ordenesCompraFacade;
    private List<OrdenesCompra> listaOrdenesCompra;   
    private OrdenesCompra ordenesCompra;

    public List<OrdenesCompra> getListaOrdenesCompra() {
        this.listaOrdenesCompra = this.ordenesCompraFacade.findAll();
        return listaOrdenesCompra;
    }

    public void setListaOrdenesCompra(List<OrdenesCompra> listaOrdenesCompra) {
        this.listaOrdenesCompra = listaOrdenesCompra;
    }

    public OrdenesCompra getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(OrdenesCompra ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }
    
    @PostConstruct
    public void init () {
        this.ordenesCompra = new OrdenesCompra();
        
    }
    
 
 
    
    }

