package util;

/**
 *
 * @author RafaelBroedel
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/* A responsabilidade da classe é instanciar o SessionFactory, que
 * contém todas configuraçÕes do arquivo hibernate.cfg.xml
 */

public class HibernateUtil {

    private static SessionFactory buildSessionFactory() {
        try {

            Configuration configuration = new Configuration();

            configuration.configure();

            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

            serviceRegistryBuilder.applySettings(configuration.getProperties());

            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

            return configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable e) {
            throw new ExceptionInInitializerError("Criacao do objeto falhou: " + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
