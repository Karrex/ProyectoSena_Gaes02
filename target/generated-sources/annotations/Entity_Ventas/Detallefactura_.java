package Entity_Ventas;

import Entity_Inventario.Carta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T18:43:12")
@StaticMetamodel(Detallefactura.class)
public class Detallefactura_ { 

    public static volatile SingularAttribute<Detallefactura, Integer> iDdetalleFactura;
    public static volatile SingularAttribute<Detallefactura, BigDecimal> precioUnitario;
    public static volatile SingularAttribute<Detallefactura, Carta> iDCartaid;
    public static volatile SingularAttribute<Detallefactura, BigDecimal> subtotal;
    public static volatile SingularAttribute<Detallefactura, Integer> cantidad;

}