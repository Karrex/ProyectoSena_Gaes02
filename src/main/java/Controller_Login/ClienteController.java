/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Login;

import EJB_Login.ClienteFacadeLocal;
import EJB_Login.UsuarioFacadeLocal;
import Entity_Login.Cliente;
import Entity_Login.Rol;
import Entity_Login.Usuario;
import com.email.HashUtil;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author CFL
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

    @EJB
    private UsuarioFacadeLocal EJBuser;
    private Usuario usuario;
    private UploadedFile file;
    private String msj;
    private String confirmarPassword;

    @EJB
    private ClienteFacadeLocal EJBcliente;
    private Cliente cliente;

    public UsuarioFacadeLocal getEJBuser() {
        return EJBuser;
    }

    public void setEJBuser(UsuarioFacadeLocal EJBuser) {
        this.EJBuser = EJBuser;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        cliente = new Cliente();
    }

    public String guardar() {
        try {
            // Verificar si el correo ya está registrado
            if (EJBuser.findByEmail(usuario.getEmail()) != null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "El Correo ya se encuentra registrado."));
                return null; // Salir del método si el correo ya está registrado
            }
            if (!usuario.getContraseña().equals(confirmarPassword)) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las contraseñas no coinciden."));
                return null;
            }

            Rol rol = new Rol();
            rol.setId_rol(2);
            rol.setNombre("Cliente");
            usuario.setRol(rol);
            // Generar el hash con salt de la contraseña antes de guardarla en la base de datos
            String hashConSalt = HashUtil.generarHashConSalt(usuario.getContraseña());
            usuario.setContraseña(hashConSalt);

            EJBuser.create(usuario);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se registró correctamente");
            // Obtener el contexto de Faces y el contexto Flash
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Flash flash = facesContext.getExternalContext().getFlash();

            // Mantener el mensaje a través de la redirección
            flash.setKeepMessages(true);

            // Agregar el mensaje al contexto de Faces
            facesContext.addMessage(null, message);

            registrarCliente(usuario);

            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            String msj = "Error: " + e.getMessage();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, null);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return null;
        }

    }

    public void cargarDatos(Usuario us) {
        this.usuario = us;
        this.cliente.setId_Cliente(us.getId_Usuario());
    }

    public void registrarCliente(Usuario usuario) {
        try {
            cliente.setUsuarioId_Usuario(usuario.getId_Usuario());
            cliente.setUsuario(usuario);
            EJBcliente.create(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarDatosCliente() {
        try {
            // Generar el hash con salt de la nueva contraseña proporcionada por el usuario
            String hashConSalt = HashUtil.generarHashConSalt(usuario.getContraseña());

            // Establecer la nueva contraseña con hash con salt en el objeto usuario
            usuario.setContraseña(hashConSalt);
            EJBuser.edit(usuario);
            EJBcliente.edit(cliente);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos actualizados correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar datos", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println(e.getMessage());
        }
    }

}
