package Entity_Login;

import Entity_Login.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T18:43:12")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> Nombre;
    public static volatile SingularAttribute<Usuario, Integer> Id_Usuario;
    public static volatile SingularAttribute<Usuario, String> Email;
    public static volatile SingularAttribute<Usuario, String> Numero_de_Telefono;
    public static volatile SingularAttribute<Usuario, String> Apellido;
    public static volatile SingularAttribute<Usuario, String> Direccion;
    public static volatile SingularAttribute<Usuario, String> Contraseña;
    public static volatile SingularAttribute<Usuario, Rol> rol;

}