package it.si.training.DAOImpl;

import it.si.training.DAO.CarDAO;
import it.si.training.model.Car;
import it.si.training.model.User;
import it.si.training.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CarDaoJPAImpl implements CarDAO<Car> {

    public CarDaoJPAImpl() {
    }

    @Override
    public void save(Car car) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            //inizio della transizione
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteria = builder.createQuery(Car.class);

            Root<Car> root = criteria.from(Car.class);
            criteria.select(root);

            Query<Car> query =session.createQuery(criteria);
             cars = query.getResultList();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
            return cars;
    }

    @Override
    public Car find(Long id) {
        Car car = null;
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            car = session.get(Car.class,id);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return car;
    }


    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            //recupero l'oggetto con l''id pasasto come parametro e dopodiché posso eliminarlo
            Car car = session.get(Car.class,id);
            System.out.println(car);
            session.delete(car);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Car car) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(car);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
