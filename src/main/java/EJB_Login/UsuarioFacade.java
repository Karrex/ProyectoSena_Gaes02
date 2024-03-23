/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB_Login;

import Entity_Login.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CFL
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "pu/ushuaia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario iniciarSesion(Usuario us) {
        Usuario usuario = null;
        try {
            // Consulta corregida
            Query query = em.createNamedQuery("Usuario.findByContraseñaCorreo");
            query.setParameter("Correo", us.getEmail());
            query.setParameter("Contraseña", us.getContraseña());
            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    private String generarHashConSalt(String password) {
        String salt = "tu_salt_aqui"; // Cambia esto por un salt aleatorio
        String passwordWithSalt = password + salt;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(passwordWithSalt.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Usuario recuperarContraseña(Usuario usuarioemail) {
        try {
            Usuario usuario = em.createNamedQuery("Usuario.recuperarContraseña", Usuario.class)
                    .setParameter("Email", usuarioemail.getEmail())
                    .getSingleResult();

            if (usuario != null) {
                return usuario;
            }
        } catch (NoResultException e) {
            System.out.println("No se encontró el usuario con el correo proporcionado.");
        } catch (Exception e) {
            System.out.println("Error al recuperar contraseña: " + e.getMessage());
        }
        return null;
    }

    /*@Override
public Usuario findByEmail(String email) {
    try {
        // Consulta para buscar un usuario por correo electrónico
        Query query = em.createNamedQuery("Usuario.findByEmail");
        query.setParameter("Email", email);

        // Intenta obtener el resultado
        Object result = query.getSingleResult();

        // Verifica si el resultado es nulo
        return (result != null) ? (Usuario) result : null;
    } catch (NoResultException e) {
        // Captura la excepción NoResultException si no se encuentra ningún resultado
        return null;
    }
}*/
    
    @Override
    public Usuario findByEmail(String email) {
        try {
            // Consulta para buscar un usuario por correo electrónico
            Query query = em.createNamedQuery("Usuario.findByEmail");
            query.setParameter("Email", email);

            // Intenta obtener el resultado
            Object result = query.getSingleResult();

            // Verifica si el resultado es nulo
            if (result != null) {
                Usuario usuario = (Usuario) result;

                // Cargar el rol para evitar la referencia perezosa
                usuario.getRol();

                return usuario;
            } else {
                return null;
            }
        } catch (NoResultException e) {
            // Captura la excepción NoResultException si no se encuentra ningún resultado
            return null;
        }
    }
    
}
