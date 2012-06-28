package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import beans.*;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
         	 config.addAnnotatedClass(Cliente.class);
         	 config.addAnnotatedClass(Rodamiento.class);
         	 config.addAnnotatedClass(SolicitudCotizacionItem.class);
         	 config.addAnnotatedClass(SolicitudCotizacion.class);  	 
        	 config.addAnnotatedClass(ListaPrecio.class);
        	 config.addAnnotatedClass(ItemPrecio.class);
        	 config.addAnnotatedClass(Financiacion.class); 	 
        	 config.addAnnotatedClass(Proveedor.class);        	         	        	 
           	 config.addAnnotatedClass(ItemStock.class);        	
           	 config.addAnnotatedClass(ODV.class);        	        	 
           	 config.addAnnotatedClass(Cotizacion.class);
           	 config.addAnnotatedClass(CotizacionItem.class);           	        	   	        	 
           	 config.addAnnotatedClass(OrdenPedido.class);
           	 config.addAnnotatedClass(OrdenPedidoItem.class);           	 
           	 config.addAnnotatedClass(OrdenCompra.class);
           	 config.addAnnotatedClass(OrdenCompraItem.class);           	        	 
           	 config.addAnnotatedClass(Remito.class);
           	 config.addAnnotatedClass(RemitoItem.class);           	        	 
           	 config.addAnnotatedClass(RemitoCliente.class);
           	 config.addAnnotatedClass(RemitoTransporte.class);           	        	 
           	 config.addAnnotatedClass(RemitoProveedor.class);           	        	 
           	 config.addAnnotatedClass(Factura.class);           	        	 
           	 config.addAnnotatedClass(FacturaItem.class);           	        	 
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
