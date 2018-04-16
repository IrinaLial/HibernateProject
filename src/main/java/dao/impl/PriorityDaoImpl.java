package dao.impl;

import dao.PriorityDao;
import model.Priority;
import model.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import java.util.List;

public class PriorityDaoImpl implements PriorityDao {
    @Override
    public List<Priority> getAll() {
        Session session = getSession();
        Query query = session.createQuery("FROM Priority");
        List result = query.list();
        session.close();
        return result;
    }

    @Override
    public Priority findOne(String name) {
        final Session session = getSession();
        session.beginTransaction();
        final Query emailQuery = session.createQuery("from Priority where detail = :name").setParameter("name", name);
        Priority priority;
        try {
            priority = (Priority) emailQuery.getSingleResult();
        } catch (NoResultException e) {
            session.getTransaction().commit();
            session.close();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return priority;
    }

    @Override
    public void delete(Long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Role role = session.get(Role.class, id);
        session.delete(role);
        transaction.commit();
        session.close();

    }

    @Override
    public void update(Priority priority) {

    }
    /**
     * @return {@link Session} for next steps.
     */
    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
