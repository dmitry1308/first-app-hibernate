package ru.schepin.hiberntate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.schepin.hiberntate.dao.CarDao;
import ru.schepin.hiberntate.dao.Dao;
import ru.schepin.hiberntate.model.Car;
import ru.schepin.hiberntate.model.User;

import java.util.Date;

public class CarDaoTest {
    private SessionFactory sessionFactory;
    private Dao<Car, Integer> carDao;
    private User user = new User();
    private Car car = new Car();

    @Before
    public void before() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        carDao = new CarDao(sessionFactory);
    }

    @After
    public void after() {
        if (carDao.getByKey(68) != null) {
            carDao.delete(car);
        }
    }


    @Test
    public void whenSaveCarThenCarIsExist() {
        user = new User();
        user.setName("Schepin Dmitriy");
        user.setAge(32);
        user.setDate(new Date(1986, 8, 13));
        user.setId(1);

        Car car = new Car();
        car.setMarka("Skoda");
        car.setModel("Yeti");
        car.setUser(user);
        car.setId(68);
        carDao.save(car);

        Car car1 = carDao.getByKey(68);
        Assert.assertEquals(car, car1);

    }
}
