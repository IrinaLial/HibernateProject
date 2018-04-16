package dao.impl;

import dao.RoleDao;
import model.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Override
    public List<Role> getAll() {
        Session session = getSession();
        Query query = session.createQuery("FROM Role");
        List result = query.list();
        session.close();
        return result;
    }

    @Override
    public Role findOne(String name) {
        final Session session = getSession();
        session.beginTransaction();
        final Query emailQuery = session.createQuery("from Role where role = :name").setParameter("name", name);
        Role role;
        try {
            role = (Role) emailQuery.getSingleResult();
        } catch (NoResultException e) {
            session.getTransaction().commit();
            session.close();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return role;
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
    public void update(Role role) {

    }

    /**
     * @return {@link Session} for next steps.
     */
    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
