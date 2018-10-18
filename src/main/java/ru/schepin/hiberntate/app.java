package ru.schepin.hiberntate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.schepin.hiberntate.dao.Dao;
import ru.schepin.hiberntate.dao.UserDao;
import ru.schepin.hiberntate.model.User;

public class app {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Dao<User, Integer> userDao = new UserDao(sessionFactory);


            System.out.println(userDao.getByKey(1));


        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }


}
