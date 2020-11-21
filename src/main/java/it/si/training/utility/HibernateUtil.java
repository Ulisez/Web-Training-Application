package it.si.training.utility;

import it.si.training.model.Car;
import it.si.training.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {

    //Funge da singleton per l'intera applicazione, si occupa poi di restituire le Session (oggetti che rappresentano la connessione fisica al database)
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.setProperties(settings());

            //Aggiunge la classe car al JPA mapping
            configuration.addAnnotatedClass(Car.class);
            configuration.addAnnotatedClass(User.class);

            //
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            //
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }

    /**
     * Restituisco un oggetto con le proprietà di configurazione necessarie ad hibernate
     * per stabilire la connessione con il database sottostante.
     * @return oggetto di tipo Properties
     */
    private static Properties settings(){
        Properties settings= new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/trainingHibernate");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "123456");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

        //Abilita hibernate per mostrare il log "debugging" delle operazioni SQL
        settings.put(Environment.SHOW_SQL, "true");

        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

        /**
         *    Proprietà usata per validare e esportare lo schema DDL di un database quando viene creato la SessionFactory
         *    create
         *    validate
         *    update
         *    create-drop
         */
        settings.put(Environment.HBM2DDL_AUTO,"create-drop");

        return settings;
    }
}
