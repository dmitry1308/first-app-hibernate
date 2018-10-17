package ru.schepin.hiberntate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.schepin.hiberntate.dao.Dao;
import ru.schepin.hiberntate.dao.UserDao;
import ru.schepin.hiberntate.model.User;

import java.util.Date;

public class app {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Dao<User, Integer> userDao = new UserDao(sessionFactory);

            // save(userDao);
            // User user = getByKey(userDao);
            delete(userDao);

        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    private static User getByKey(Dao<User, Integer> userDao) {
        return userDao.getByKey(4);
    }

    private static void delete(Dao<User, Integer> userDao) {
        User user = getByKey(userDao);
        userDao.delete(user);
    }

    private static void save(Dao<User, Integer> userDao) {
        User user = new User();
        user.setName("Vargas Ilya");
        user.setAge(33);

        user.setDate(new Date(1985, 5, 1));

        userDao.save(user);
    }
}
