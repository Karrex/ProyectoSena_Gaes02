package Entity_Ventas;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T18:43:12")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> iDVenta;
    public static volatile SingularAttribute<Venta, BigDecimal> totalVenta;
    public static volatile SingularAttribute<Venta, String> metododePago;
    public static volatile SingularAttribute<Venta, Date> fechaVenta;

}