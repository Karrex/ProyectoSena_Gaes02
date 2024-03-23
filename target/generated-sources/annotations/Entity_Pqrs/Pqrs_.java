package Entity_Pqrs;

import Entity_Login.Usuario;
import Entity_Pqrs.Estado_Pqrs;
import Entity_Pqrs.Tipo_Pqrs;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T18:43:12")
@StaticMetamodel(Pqrs.class)
public class Pqrs_ { 

    public static volatile SingularAttribute<Pqrs, Usuario> Usuario;
    public static volatile SingularAttribute<Pqrs, Tipo_Pqrs> Tipo;
    public static volatile SingularAttribute<Pqrs, Integer> ID_PQRS;
    public static volatile SingularAttribute<Pqrs, String> Descripcion;
    public static volatile SingularAttribute<Pqrs, Date> FechaCreacion;
    public static volatile SingularAttribute<Pqrs, Estado_Pqrs> Estado;

}