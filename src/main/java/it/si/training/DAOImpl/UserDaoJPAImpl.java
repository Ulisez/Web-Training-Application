package it.si.training.DAOImpl;

import it.si.training.DAO.UserDAO;
import it.si.training.model.Car;
import it.si.training.model.User;
import it.si.training.utility.CarDaoFactory;
import it.si.training.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public class UserDaoJPAImpl implements UserDAO<User> {


    @Override
    public void save(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
          transaction  = session.beginTransaction();
          session.save(user);
          transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
     Transaction transaction = null;
     try(Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();
        //recupero l'oggetto con l''id pasasto come parametro e dopodiché posso eliminarlo
         User user = session.get(User.class,id);
         session.delete(user);
         transaction.commit();

     }catch (Exception e){
         if(transaction != null){
             transaction.rollback();
         }
         e.printStackTrace();
     }
    }

    @Override
    public void update(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction  = session.beginTransaction();
            session.update(user);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * è necessario usare CriteriaBuilder and CriteriaQuery interfaces dalla versione
     * 5+ di Hibernate
     * @return
     */
    @Override
    public List<User> findAll() {

        List<User> users = null;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Create CriteriaBuilder
            CriteriaBuilder builder = session.getCriteriaBuilder();

             // Create CriteriaQuery
            CriteriaQuery<User> criteria = builder.createQuery(User.class);

           // Set root
            Root<User> root = criteria.from(User.class);
            criteria.select(root);

             // Query execution
            Query<User> query = session.createQuery(criteria);
             users = query.getResultList();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User find(Long id) {
        User user = null;
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.get(User.class,id);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Set<Car> findUserCars(Long userId) {
        Set<Car> cars=null;
        return cars;
    }

    @Override
    public void addNewCar(Long userId, Long carId) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction  = session.beginTransaction();
            User user = session.get(User.class,userId);
            user.getCars().add(session.get(Car.class, carId));
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
