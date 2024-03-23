/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Login;

import EJB_Login.ClienteFacadeLocal;
import EJB_Login.UsuarioFacadeLocal;
import Entity_Login.Cliente;
import Entity_Login.Usuario;
import com.email.HashUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author CFL
 */
@Named
@ViewScoped
public class datosClienteController implements Serializable {

    @EJB
    private UsuarioFacadeLocal EJBuser;
    private Usuario usuario;

    @EJB
    private ClienteFacadeLocal EJBcliente;
    private Cliente cliente;
    private List<Cliente> listaCliente;
    private String msj;

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        cliente = new Cliente();
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        listaCliente = EJBcliente.getDateClient(usuario.getId_Usuario());
        //getDatosCliente();
    }

    public void actualizarDatosClientes() {
    try {
        // Generar el hash con salt de la nueva contraseña proporcionada por el usuario
        String hashConSalt = HashUtil.generarHashConSalt(usuario.getContraseña());

        // Establecer la nueva contraseña con hash con salt en el objeto usuario
        usuario.setContraseña(hashConSalt);

        EJBuser.edit(usuario);
        actualizarDatosCliente(usuario);
        this.msj = "Registro creado correctamente";
    } catch (Exception e) {
        e.printStackTrace();
        this.msj = "Error" + e.getMessage();
    }

    FacesMessage mensaje = new FacesMessage(this.msj);
    FacesContext.getCurrentInstance().addMessage(null, mensaje);
}

    public void actualizarDatosCliente(Usuario user) {
        try {
            cliente.setUsuarioId_Usuario(user.getId_Usuario());
            cliente.setUsuario(usuario);
            EJBcliente.edit(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void CargarDatosModal(Usuario _usuario) {
        try {
            usuario = _usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getDatosCliente() {
        try {
            usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            cliente = EJBcliente.getDatosCliente(usuario.getId_Usuario());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
