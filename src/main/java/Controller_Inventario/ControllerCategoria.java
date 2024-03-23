/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Inventario;

import EJB_Inventario.CategoriaFacadeLocal;
import Entity_Inventario.Categoria;
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

public class ControllerCategoria implements Serializable  {
    
    @EJB
    private CategoriaFacadeLocal categoriafacade;
    private List<Categoria> listacategoria;
    private Categoria categoria;
    private Object PrimeFaces;
    private String msj;
    private List<Categoria> BuscadorCategorias;

    public List<Categoria> getListacategoria() {
        this.listacategoria = this.categoriafacade.findAll();
        return listacategoria;
    }

    public void setListacategoria(List<Categoria> listacategoria) {
        this.listacategoria = listacategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Object getPrimeFaces() {
        return PrimeFaces;
    }

    public void setPrimeFaces(Object PrimeFaces) {
        this.PrimeFaces = PrimeFaces;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public List<Categoria> getBuscadorCategorias() {
        return BuscadorCategorias;
    }

    public void setBuscadorCategorias(List<Categoria> BuscadorCategorias) {
        this.BuscadorCategorias = BuscadorCategorias;
    }
    
    
    
    
    
    
    @PostConstruct
    
    public void init(){
        this.categoria = new Categoria();
        
    }
    
    
    public void guardar (){
        
        try {
            this.categoriafacade.create(categoria);
            this.msj = "Su categoria a sido guardada con exito";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    
    public void actualizar(){
        
        try{
            this.categoriafacade.edit(categoria);
            this.msj = "Categoria Actualizada Correctamente";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar(Categoria eli){
        
        try {
            this.categoriafacade.remove(eli);
            this.msj = "Esta categoria se elimino correctamente";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    
    public void Cargardatos(Categoria cat){
        this.categoria = cat;
    }
    
    public void limpiar() {
        
        this.categoria = new Categoria();
        
    }
    
    
    
    
}
