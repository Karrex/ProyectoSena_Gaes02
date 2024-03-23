/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Inventario;

import EJB_Inventario.ProductosFacadeLocal;
import Entity_Inventario.Categoria;
import Entity_Inventario.EstadoProducto;
import Entity_Inventario.Productos;
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
public class ControllerProductos implements Serializable{
    
    @EJB
    private ProductosFacadeLocal productosFacade;
    private List<Productos> listaProductos;
    private Productos productos;
    private Categoria categorias;
    private EstadoProducto estadoProducto;
    private String msj;

    public List<Productos> getListaProductos() {
        this.listaProductos = this.productosFacade.findAll();
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
    
    @PostConstruct
    public void init (){
       this.productos = new Productos();
       this.categorias = new Categoria();
       this.estadoProducto = new EstadoProducto();
        
    }
    public void guardar() {
        try {
            this.productosFacade.create(productos);
            this.estadoProducto.setIDEstadoproducto(Integer.MIN_VALUE);
            this.categorias.setIDCategoria(Integer.BYTES);
            this.msj = "Su producto se creo correctamente";
            this.productos = new Productos();
            this.categorias = new Categoria();
            this.estadoProducto = new EstadoProducto();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void Actualizar() {
        try {
            this.productos.setIDEstadoproducto(estadoProducto);
            this.productosFacade.edit(productos);
            this.msj = "Su producto se acualizado correctamente";
            this.productos = new Productos();
            this.estadoProducto = new EstadoProducto();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }

        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    
    public void eliminar(Productos eli) {
        try {
            this.productosFacade.remove(eli);
            this.msj = "Producto eliminado correctamente ";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void CargarDatos(Productos pro) {
        this.productos = pro;
        
    }
    
    public void limpiar() {
        this.productos.setIDEstadoproducto(estadoProducto);
        this.productosFacade.edit(productos);

    }

}
