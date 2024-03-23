package Entity_Ventas;

import Entity_Ventas.EstadoPedido;
import Entity_Ventas.Venta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T18:43:12")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, EstadoPedido> iDEstadoPedidoID;
    public static volatile SingularAttribute<Pedido, Integer> iDPedido;
    public static volatile SingularAttribute<Pedido, Date> fechaPedido;
    public static volatile SingularAttribute<Pedido, Venta> iDVentaid;

}