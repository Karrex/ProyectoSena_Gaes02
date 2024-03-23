/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Inventario;

import EJB_Inventario.InventarioFacadeLocal;
import Entity_Inventario.Inventario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CFL
 */

@ManagedBean
@SessionScoped

public class ControllerInventario implements Serializable {
    
    @EJB
    private InventarioFacadeLocal inventariofacade;
    private List<Inventario> listainventario;
    private String msj;
    private Inventario inventario;
    private List<Inventario> Buscadorinventario;

    public List<Inventario> getListainventario() {
        this.listainventario = this.inventariofacade.findAll();
        return listainventario;
    }

    public void setListainventario(List<Inventario> listainventario) {
        this.listainventario = listainventario;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Inventario> getBuscadorinventario() {
        return Buscadorinventario;
    }

    public void setBuscadorinventario(List<Inventario> Buscadorinventario) {
        this.Buscadorinventario = Buscadorinventario;
    }
    
    @PostConstruct
    public void init(){
        this.inventario = new Inventario();
    }
    
    
    public void guardar (){
        
        try {
            this.inventariofacade.create(inventario);
            this.msj = "Su categoria a sido guardada con exito";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    
    public void actualizar () {
        try {
            this.inventariofacade.edit(inventario);
            this.msj = "Registro Creado correctamente";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }

        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar(Inventario elim){
        
        try {
            this.inventariofacade.remove(elim);
            this.msj = "Esta categoria se elimino correctamente";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    
    public void Cargardatos(Inventario cats){
        this.inventario = cats;
    }
    public void limpiar() {
        
        this.inventario = new Inventario();
    }
    
    
    
    
    
   
    
    
    
}
