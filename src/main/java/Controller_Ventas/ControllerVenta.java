/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Ventas;


import EJB_Ventas.VentaFacadeLocal;
import Entity_Ventas.Venta;
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

public class ControllerVenta implements Serializable{
    
    @EJB
    private VentaFacadeLocal ventaFacade;
    private List<Venta> listaVenta;
    private Venta venta;
    private String msj;

    public List<Venta> getListaVenta() {
        this.listaVenta = this.ventaFacade.findAll();
        return listaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    @PostConstruct
    public void init (){
        this.venta = new Venta();
    }
        public void guardar() {
    try {
        this.ventaFacade.edit(venta);
        this.msj = "Registro Guardado correctamente";
        this.venta = new Venta();
        FacesMessage mensajeExito = new FacesMessage(FacesMessage.SEVERITY_INFO, this.msj, null);
        FacesContext.getCurrentInstance().addMessage(null, mensajeExito);
    } catch (Exception e) {
        this.msj = "Error al Guardar el registro: " + e.getMessage();
        FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, this.msj, null);
        FacesContext.getCurrentInstance().addMessage(null, mensajeError);
        e.printStackTrace(); // o guarda la traza en un archivo de registro
    }  
        }
        
         public void actualizar() {
    try {
        this.ventaFacade.edit(venta);
        this.msj = "Registro Actualizado correctamente";
        this.venta = new Venta();
        FacesMessage mensajeExito = new FacesMessage(FacesMessage.SEVERITY_INFO, this.msj, null);
        FacesContext.getCurrentInstance().addMessage(null, mensajeExito);
    } catch (Exception e) {
        this.msj = "Error al Actualizar el registro: " + e.getMessage();
        FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, this.msj, null);
        FacesContext.getCurrentInstance().addMessage(null, mensajeError);
        e.printStackTrace(); // o guarda la traza en un archivo de registro
    }  
        }
    public void eliminar(Venta eli){
        try {
            this.ventaFacade.remove(eli);
            this.msj = "Registro Eliminado correctamente ";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void Cargardatos(Venta ca){
        this.venta= ca;
    }
        public void limpiar(){
        this.venta = new Venta();
    }
}

    


