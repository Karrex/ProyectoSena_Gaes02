/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Login;

import EJB_Login.AdminFacadeLocal;
import EJB_Login.UsuarioFacadeLocal;
import Entity_Login.Admin;
import Entity_Login.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;

/**
 *
 * @author CFL
 */


@Named
@ViewScoped
public class datosAdmin implements Serializable {

    @EJB
    private UsuarioFacadeLocal EJBuser;
    private Usuario usuario;

    @EJB
    private AdminFacadeLocal EJBAdmin;
    private Admin admin;
    private List<Admin> listaadmin;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Admin> getListaadmin() {
        return listaadmin;
    }

    public void setListaadmin(List<Admin> listaadmin) {
        this.listaadmin = listaadmin;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        admin = new Admin();
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        listaadmin = EJBAdmin.getDateAdmin(usuario.getId_Usuario());

        
    }

    public void actualizarDatosCliente() {
        try {
            EJBAdmin.edit(admin); // Asegúrate de tener un método actualizarCliente en tu EJBcliente

            // Recargar la lista de clientes después de la actualización
            listaadmin = EJBAdmin.getDateAdmin(usuario.getId_Usuario());

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos actualizados correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar datos", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println(e.getMessage());
        }
    }

    public void getDatosCliente() {
        try {
            usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            admin = EJBAdmin.getDatosAdmin(usuario.getId_Usuario());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
