package ru.schepin.hiberntate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.schepin.hiberntate.dao.CarDao;
import ru.schepin.hiberntate.dao.Dao;
import ru.schepin.hiberntate.model.Car;
import ru.schepin.hiberntate.model.Engine;
import ru.schepin.hiberntate.model.User;

import java.util.Date;

public class app {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Dao<Car, Integer> carDao = new CarDao(sessionFactory);


              save(carDao);

//            Car car = carDao.getByKey(4);
//            System.out.println(car);
//
//            car.getUser().setAge(33);
//            carDao.update(car);
//            System.out.println(carDao.getByKey(3));
//            carDao.delete(car);


        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }


    private static void save(Dao<Car, Integer> carDao) {
        User user = new User();
        user.setName("Schepin Dmitriy");
        user.setAge(32);
        user.setDate(new Date(1986, 8, 13));
        user.setId(25);

        Car mmcL200 = new Car();
        mmcL200.setMarka("MMC");
        mmcL200.setModel("L200");
        mmcL200.setId(25);

        Engine k56456 = new Engine(5, "K56456");


        mmcL200.setUser(user);
        mmcL200.setEngine(k56456);
        carDao.save(mmcL200);
        System.out.println(carDao.getByKey(25));
    }
}
