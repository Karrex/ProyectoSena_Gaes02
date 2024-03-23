/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Pqrs;

import EJB_Login.UsuarioFacadeLocal;
import EJB_Pqrs.PqrsFacadeLocal;
import Entity_Login.Usuario;
import Entity_Pqrs.Estado_Pqrs;
import Entity_Pqrs.Pqrs;
import Entity_Pqrs.Tipo_Pqrs;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.file.UploadedFile;


/**
 *
 * @author CFL
 */


@Named
@ViewScoped
public class Controller_Pqrs implements Serializable {

    @EJB

    private UsuarioFacadeLocal usuario_facade;
    private Usuario usuario;
    private List<Usuario> lista_usuario;
    private Tipo_Pqrs tipo_pqrs;
    private Estado_Pqrs estado_pqrs;
    private UploadedFile file;
    private String msj;

    @EJB

    private PqrsFacadeLocal pqrs_facade;
    private List<Pqrs> lista_pqrs;
    private Pqrs pqrs;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista_usuario() {
        return lista_usuario;
    }

    public void setLista_usuario(List<Usuario> lista_usuario) {
        this.lista_usuario = lista_usuario;
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<Pqrs> getLista_pqrs() {
        this.lista_pqrs = this.pqrs_facade.findAll();
        return lista_pqrs;
    }

    public void setLista_pqrs(List<Pqrs> lista_pqrs) {
        this.lista_pqrs = lista_pqrs;
    }

    public Pqrs getPqrs() {
        return pqrs;
    }

    public void setPqrs(Pqrs pqrs) {
        this.pqrs = pqrs;
    }

    @PostConstruct

    public void init() {

        this.estado_pqrs = new Estado_Pqrs();
        this.tipo_pqrs = new Tipo_Pqrs();
        this.pqrs = new Pqrs();
        this.usuario = new Usuario();
    }

    public void bicho() throws Exception {

        try {

            Usuario usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

            if (usuarioLogueado == null) {

                throw new Exception("Usuario no encontrado.");

            }

            this.pqrs.setFechaCreacion(new Date());
            this.pqrs.setUsuario(usuarioLogueado);
            this.pqrs.setEstado(estado_pqrs);
            this.pqrs.setTipo(tipo_pqrs);
            this.pqrs_facade.create(pqrs);
            this.msj = "Su PQRS ha sido creada con exito.";

            
            this.estado_pqrs = new Estado_Pqrs();
            this.tipo_pqrs = new Tipo_Pqrs();
            this.pqrs = new Pqrs();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "ERROR" + e.getMessage();
        }
        
        
        FacesMessage mensaje = new FacesMessage (this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        
        
        

    }
    
    public void Limpiar(){
        
        estado_pqrs = new Estado_Pqrs();
        tipo_pqrs = new Tipo_Pqrs();
        pqrs = new Pqrs();
        usuario = new Usuario();
        
    }
    
    public void CargarDatos (Pqrs bc){
        
        this.estado_pqrs.setId_Estado(bc.getEstado().getId_Estado());
        this.tipo_pqrs.setId_Tipo(bc.getTipo().getId_Tipo());
        this.usuario.setId_Usuario(bc.getUsuario().getId_Usuario());
        
        this.pqrs = bc;
        
        
    }
    
    
    
    

    
}
