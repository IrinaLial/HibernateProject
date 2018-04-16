package dao.impl;

import dao.UserDao;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getAll() {
        Session session = getSession();
        Query query = session.createQuery("FROM User");
        List result = query.list();
        session.close();
        return result;
    }

    @Override
    public void delete(Long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {
    }

    /**
     * @return {@link Session} for next steps.
     */
    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
