/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Pqrs;

import EJB_Pqrs.Respuesta_PqrsFacadeLocal;
import Entity_Login.Usuario;
import Entity_Pqrs.Estado_Pqrs;
import Entity_Pqrs.Pqrs;
import Entity_Pqrs.Respuesta_Pqrs;
import Entity_Pqrs.Tipo_Pqrs;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author CFL
 */
@ManagedBean
@SessionScoped
public class Controller_RespuestaPqrs implements Serializable {

    @EJB

    private Respuesta_PqrsFacadeLocal respuestapqrsfacade;
    private List<Respuesta_Pqrs> listarespuestapqrs;
    private Respuesta_Pqrs respuestapqrs;
    private Tipo_Pqrs tipo_pqrs;
    private Estado_Pqrs estado_pqrs;
    private String msj;
    private Pqrs pqrs;
    private List<Respuesta_Pqrs> buscadorrespuesta;

    public List<Respuesta_Pqrs> getListarespuestapqrs() {
        this.listarespuestapqrs = this.respuestapqrsfacade.findAll();
        return listarespuestapqrs;
    }

    public void setListarespuestapqrs(List<Respuesta_Pqrs> listarespuestapqrs) {
        this.listarespuestapqrs = listarespuestapqrs;
    }

    public Respuesta_Pqrs getRespuestapqrs() {
        return respuestapqrs;
    }

    public void setRespuestapqrs(Respuesta_Pqrs respuestapqrs) {
        this.respuestapqrs = respuestapqrs;
    }

    public Tipo_Pqrs getTipo_pqrs() {
        return tipo_pqrs;
    }

    public void setTipo_pqrs(Tipo_Pqrs tipo_pqrs) {
        this.tipo_pqrs = tipo_pqrs;
    }

    public Estado_Pqrs getEstado_pqrs() {
        return estado_pqrs;
    }

    public void setEstado_pqrs(Estado_Pqrs estado_pqrs) {
        this.estado_pqrs = estado_pqrs;
    }

    public Pqrs getPqrs() {
        return pqrs;
    }

    public void setPqrs(Pqrs pqrs) {
        this.pqrs = pqrs;
    }

    public List<Respuesta_Pqrs> getBuscadorrespuesta() {
        return buscadorrespuesta;
    }

    public void setBuscadorrespuesta(List<Respuesta_Pqrs> buscadorrespuesta) {
        this.buscadorrespuesta = buscadorrespuesta;
    }

    @PostConstruct
    public void init() {
        this.respuestapqrs = new Respuesta_Pqrs();
        this.pqrs = new Pqrs();
        this.estado_pqrs = new Estado_Pqrs();
        this.tipo_pqrs = new Tipo_Pqrs();
    }

    public void responder() {
        
        try {
            Usuario usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

            if (usuarioLogueado == null) {
                throw new Exception("Usuario no encontrado en la sesión.");
                
            }
            
            if (pqrsYarespondido()){
                
                this.msj = "El PQRS ya se respondio antiguamente";
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO El PQRS ya se ha respondido anteriormente.", this.msj);
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                PrimeFaces.current().ajax().update("msj");
                return;
                
            }
            
            this.respuestapqrs.setPqrs(pqrs);
            this.respuestapqrs.setFechaRespuesta(new Date());
            this.respuestapqrsfacade.create(respuestapqrs);
            this.msj = "Su PQRS ha sido resuelta";
            this.pqrs = new Pqrs();
            this.respuestapqrs = new Respuesta_Pqrs();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }

        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public boolean pqrsYarespondido(){
       
        List <Respuesta_Pqrs> respuestas = (List <Respuesta_Pqrs>) respuestapqrsfacade.findByPqrsId(pqrs.getID_PQRS());
        
        return respuestas !=null && !respuestas.isEmpty();
        
    }
    
    
    public void cargarDatos(Pqrs pqrs){
        
        this.pqrs.setID_PQRS(pqrs.getID_PQRS());
        this.pqrs = pqrs;
        
        
    }

}
