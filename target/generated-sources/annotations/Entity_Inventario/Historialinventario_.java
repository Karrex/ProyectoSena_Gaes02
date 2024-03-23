package Entity_Inventario;

import Entity_Inventario.Inventario;
import Entity_Inventario.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T18:43:12")
@StaticMetamodel(Historialinventario.class)
public class Historialinventario_ { 

    public static volatile SingularAttribute<Historialinventario, Integer> cantidadActual;
    public static volatile SingularAttribute<Historialinventario, Date> fechaRegistro;
    public static volatile SingularAttribute<Historialinventario, Integer> registroInventarioID;
    public static volatile SingularAttribute<Historialinventario, Inventario> iDInventarioid;
    public static volatile SingularAttribute<Historialinventario, String> tipoTransaccion;
    public static volatile SingularAttribute<Historialinventario, Productos> iDProductoid;
    public static volatile SingularAttribute<Historialinventario, Integer> cantidadModificada;

}