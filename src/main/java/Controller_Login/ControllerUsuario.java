/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Login;

import EJB_Login.UsuarioFacadeLocal;
import Entity_Login.Admin;
import Entity_Login.Cliente;
import Entity_Login.Rol;
import Entity_Login.Usuario;
import com.email.CorreoBean;
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
public class ControllerUsuario implements Serializable {

    @EJB
    private UsuarioFacadeLocal UsuarioFacade;
    private List<Usuario> ListaUsuario;
    private List<Usuario> BuscadorUsuario;
    private Usuario usuario;
    private Rol rol;
    private Cliente Cliente;
    private Admin admin;
    private String msj;

    public List<Usuario> getListaUsuario() {
        this.ListaUsuario = this.UsuarioFacade.findAll();
        return ListaUsuario;
    }

    public void setListaUsuario(List<Usuario> ListaUsuario) {
        this.ListaUsuario = ListaUsuario;
    }

    public List<Usuario> getBuscadorUsuario() {
        return BuscadorUsuario;
    }

    public void setBuscadorUsuario(List<Usuario> BuscadorUsuario) {
        this.BuscadorUsuario = BuscadorUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.rol = new Rol();
        this.Cliente = new Cliente();
        this.admin = new Admin();
    }
    
    public void recuperarContraseña(){
        try {
            Usuario usuarioRecuperado = UsuarioFacade.recuperarContraseña(usuario);
            if (usuarioRecuperado != null) {
                CorreoBean mail = new CorreoBean();
                mail.setTo(usuarioRecuperado.getEmail());
                mail.setSubject("Recuperar Contraseña");
                mail.setDescr("Su contraseña es: " + usuarioRecuperado.getContraseña());
                mail.enviarEmail(); // Asegúrate de que este método esté implementado correctamente

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se envió un correo con su contraseña"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "El correo no es válido"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo recuperar la contraseña"));
        }
    }

    public void actualizar() {
        try {
            this.usuario.setRol(rol);
            this.UsuarioFacade.edit(usuario);
            this.msj = "Registro Acualizado correctamente";
            this.usuario = new Usuario();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Usuario re) {
        this.rol.setId_rol(re.getRol().getId_rol());
        this.usuario = re;

    }

    public void limpiar() {
        this.usuario = new Usuario();
        this.rol = new Rol();
        this.Cliente = new Cliente();
        this.admin = new Admin();
    }
    
    public void eliminar(Usuario re) {
        try {
            this.UsuarioFacade.remove(re);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
