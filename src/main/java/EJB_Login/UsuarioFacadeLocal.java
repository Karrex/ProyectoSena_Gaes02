/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB_Login;

import Entity_Login.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CFL
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    public Usuario iniciarSesion(Usuario usuario);

    public Object findByEmail(String email);

    public Usuario recuperarContraseña(Usuario usuarioEmail);
    
}
