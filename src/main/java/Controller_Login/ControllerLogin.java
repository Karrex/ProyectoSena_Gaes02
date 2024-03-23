/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Login;

import EJB_Login.UsuarioFacadeLocal;
import Entity_Login.Usuario;
import com.email.HashUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author CFL
 */


@Named
@SessionScoped
public class ControllerLogin implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal EJBuser;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
   public String iniciarSesion() {
    System.out.println("Verificando usuario");
    String redireccion = null;
    FacesContext context = FacesContext.getCurrentInstance();

    try {
        // Generar el hash con salt de la contraseña proporcionada por el usuario
        String hashConSalt = HashUtil.generarHashConSalt(usuario.getContraseña());

        // Establecer la contraseña con hash con salt en el objeto usuario
        usuario.setContraseña(hashConSalt);

        usuario = EJBuser.iniciarSesion(usuario);
        if (usuario != null) {
            context.getExternalContext().getSessionMap().put("Usuario", usuario);
            redireccion = redireccionarUsuario(usuario.getRol().getId_rol());
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o Contraseña incorrecto", null);
            context.addMessage(null, message);
        }
         usuario = new Usuario();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return redireccion;
}

    
    public String redireccionarUsuario(int rol){
        switch(rol){
            case 1:
                return "Dashboard Del Admin/IndexAdmin";
            default:
                return "Dashboard Del Cliente/indexCliente";
        }
    }
    
    public String CerrarSesion() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "/indexHome?faces-redirect=true";
}
    
}
