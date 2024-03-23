package Entity_Inventario;

import Entity_Inventario.Categoria;
import Entity_Inventario.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T18:43:12")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, Date> fechaIngreso;
    public static volatile SingularAttribute<Inventario, Date> fechaCaducidad;
    public static volatile SingularAttribute<Inventario, Long> precio;
    public static volatile SingularAttribute<Inventario, Integer> iDInventario;
    public static volatile SingularAttribute<Inventario, String> ubicacionProducto;
    public static volatile SingularAttribute<Inventario, Date> fechaSalida;
    public static volatile SingularAttribute<Inventario, Categoria> iDCategoriaid;
    public static volatile SingularAttribute<Inventario, Date> fechaUltimaActualizacion;
    public static volatile SingularAttribute<Inventario, Productos> iDProductoid;

}