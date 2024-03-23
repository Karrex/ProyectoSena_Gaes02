package Entity_Inventario;

import Entity_Inventario.EstadoProducto;
import Entity_Inventario.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T18:43:12")
@StaticMetamodel(Carta.class)
public class Carta_ { 

    public static volatile SingularAttribute<Carta, String> ingredientes;
    public static volatile SingularAttribute<Carta, Integer> iDCarta;
    public static volatile SingularAttribute<Carta, Integer> tiempoPreparacion;
    public static volatile SingularAttribute<Carta, Productos> idproductosid;
    public static volatile SingularAttribute<Carta, String> nombrefoto;
    public static volatile SingularAttribute<Carta, byte[]> imagen;
    public static volatile SingularAttribute<Carta, EstadoProducto> iDEstadoProductos;

}