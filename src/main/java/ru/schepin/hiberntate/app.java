package ru.schepin.hiberntate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.schepin.hiberntate.dao.CarDao;
import ru.schepin.hiberntate.dao.Dao;
import ru.schepin.hiberntate.model.Car;
import ru.schepin.hiberntate.model.User;

import java.util.Date;

public class app {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Dao<Car, Integer> carDao = new CarDao(sessionFactory);


          //    save(carDao);

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
        user.setId(1);

        Car mmcL200 = new Car();
        mmcL200.setMarka("MMC");
        mmcL200.setModel("L200");

        Car skodaOctavia = new Car();
        skodaOctavia.setMarka("Skoda");
        skodaOctavia.setModel("Octavia");

        mmcL200.setUser(user);
        skodaOctavia.setUser(user);

        carDao.save(skodaOctavia);
        carDao.save(mmcL200);
    }
}
