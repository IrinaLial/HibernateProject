package dao.impl;

import dao.TodoDao;
import model.Todo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class TodoDaoImpl implements TodoDao {

    @Override
    public List<Todo> getAll() {
        Session session = getSession();
        Query query = session.createQuery("SELECT d.name FROM Todo d");
        List result = query.list();
        session.close();
        return result;
    }

    @Override
    public void delete(Long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Todo todo = session.get(Todo.class, id);
        session.delete(todo);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Todo todo) {
    }
    /**
     * @return {@link Session} for next steps.
     */
    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
