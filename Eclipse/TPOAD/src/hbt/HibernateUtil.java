package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import beans.Cliente;
import beans.Cotizacion;
import beans.CotizacionItem;
import beans.Factura;
import beans.FacturaItem;
import beans.Financiacion;
import beans.Ganancia;
import beans.ItemPrecio;
import beans.ItemStock;
import beans.ListaPrecio;
import beans.ODV;
import beans.OrdenCompra;
import beans.OrdenCompraItem;
import beans.OrdenPedido;
import beans.OrdenPedidoItem;
import beans.Proveedor;
import beans.Remito;
import beans.RemitoCliente;
import beans.RemitoItem;
import beans.RemitoProveedor;
import beans.RemitoTransporte;
import beans.Rodamiento;
import beans.SolicitudCotizacion;
import beans.SolicitudCotizacionItem;

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
           	 config.addAnnotatedClass(Ganancia.class);           	            	
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
