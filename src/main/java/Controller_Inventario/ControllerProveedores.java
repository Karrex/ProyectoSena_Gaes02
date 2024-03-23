/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Inventario;


import EJB_Inventario.ProveedoresFacadeLocal;
import Entity_Inventario.OrdenesCompra;
import Entity_Inventario.Proveedores;
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
public class ControllerProveedores implements Serializable {

    @EJB
    private ProveedoresFacadeLocal proveedoresFacade;
    private List<Proveedores> listaproveedores;
    private Proveedores proveedores;
    private OrdenesCompra ordenesCompra;
    private String msj;

    public List<Proveedores> getListaproveedores() {
        this.listaproveedores = this.proveedoresFacade.findAll();
        return listaproveedores;
    }

    public void setListaproveedores(List<Proveedores> listaproveedores) {
        this.listaproveedores = listaproveedores;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public OrdenesCompra getOrdenesCompra() {
        return ordenesCompra;
    }

    @PostConstruct
    public void init() {
        this.proveedores = new Proveedores();
    }

    public void guardar() {
        try {
            this.proveedoresFacade.create(proveedores);
            this.msj = "Proveedor actualizado correctamente";
            this.proveedores = new Proveedores();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }

        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void Actualizar() {
        try {
            this.proveedoresFacade.edit(proveedores);
            this.msj = "Proveedor actualizado correctamente";
            this.proveedores = new Proveedores();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }

        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

   

    public void Eliminar(Proveedores eli) {
        try {
            this.proveedoresFacade.remove(eli);
            this.msj = "Eliminado correctamente ";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    
    public void Cargardatos(Proveedores ca){
        this.proveedores = ca;
    }
    
    public void limpiar(){
        this.proveedores = new Proveedores();
    }

}
