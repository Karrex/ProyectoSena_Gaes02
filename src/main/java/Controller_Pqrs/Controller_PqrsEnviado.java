/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Pqrs;


import EJB_Login.UsuarioFacadeLocal;
import EJB_Pqrs.PqrsFacadeLocal;
import EJB_Pqrs.Respuesta_PqrsFacadeLocal;
import Entity_Login.Usuario;
import Entity_Pqrs.Estado_Pqrs;
import Entity_Pqrs.Pqrs;
import Entity_Pqrs.Respuesta_Pqrs;
import Entity_Pqrs.Tipo_Pqrs;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author CFL
 */

@Named
@ViewScoped
public class Controller_PqrsEnviado implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuariofacade;
    private Usuario usuario;
    private List<Usuario> listausuario;
    
    
    @EJB
    private Respuesta_PqrsFacadeLocal respuestapqrsfacade;
    private List<Respuesta_Pqrs> listarespuestapqrs;
    private Respuesta_Pqrs respuesta_pqrs;
    
    
    
    @EJB
    private PqrsFacadeLocal pqrsfacade;
    private Pqrs pqrs;
    private List<Pqrs> listapqrs;
    private Estado_Pqrs estado_pqrs;
    private Tipo_Pqrs tipo_pqrs;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListausuario() {
        return listausuario;
    }

    public void setListausuario(List<Usuario> listausuario) {
        this.listausuario = listausuario;
    }

    public List<Respuesta_Pqrs> getListarespuestapqrs() {
        return listarespuestapqrs;
    }

    public void setListarespuestapqrs(List<Respuesta_Pqrs> listarespuestapqrs) {
        this.listarespuestapqrs = listarespuestapqrs;
    }

    public Respuesta_Pqrs getRespuesta_pqrs() {
        return respuesta_pqrs;
    }

    public void setRespuesta_pqrs(Respuesta_Pqrs respuesta_pqrs) {
        this.respuesta_pqrs = respuesta_pqrs;
    }

    public Pqrs getPqrs() {
        return pqrs;
    }

    public void setPqrs(Pqrs pqrs) {
        this.pqrs = pqrs;
    }

    public List<Pqrs> getListapqrs() {
        return listapqrs;
    }

    public void setListapqrs(List<Pqrs> listapqrs) {
        this.listapqrs = listapqrs;
    }

    public Estado_Pqrs getEstado_pqrs() {
        return estado_pqrs;
    }

    public void setEstado_pqrs(Estado_Pqrs estado_pqrs) {
        this.estado_pqrs = estado_pqrs;
    }

    public Tipo_Pqrs getTipo_pqrs() {
        return tipo_pqrs;
    }

    public void setTipo_pqrs(Tipo_Pqrs tipo_pqrs) {
        this.tipo_pqrs = tipo_pqrs;
    }
    
    
    @PostConstruct
    public void init(){
        
        usuario =new Usuario();
        pqrs = new Pqrs();
        respuesta_pqrs = new Respuesta_Pqrs();
        cargarlistaPqrs();
    }
    
    public void cargarlistaPqrs(){
        
        try {
            Usuario usuarioLogeado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
            if (usuarioLogeado != null) {

                this.listapqrs = this.pqrsfacade.findByUsuarioId(usuarioLogeado.getId_Usuario());

            }
        } catch (Exception e) {
            Logger.getLogger(Controller_Pqrs.class.getName()).log(Level.SEVERE, "Error al obtener la lista de PQRS", e);
        }
        
    }
    
    
    public void cargarRespuestas(Pqrs pqrs) {
        try {
            this.listarespuestapqrs = (List<Respuesta_Pqrs>) this.respuestapqrsfacade.findByPqrsIdS(pqrs.getID_PQRS());
        } catch (Exception e) {
            Logger.getLogger(Controller_PqrsEnviado.class.getName()).log(Level.SEVERE, "Error al obtener las respuestas del PQRS", e);
        }
    }
    
    
    
}
