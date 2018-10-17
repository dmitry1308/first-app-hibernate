package ru.schepin.hiberntate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.schepin.hiberntate.model.User;

public class UserDao implements Dao<User, Integer> {
    private SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public User getByKey(Integer id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);

        return user != null ? user : new User();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }
}
