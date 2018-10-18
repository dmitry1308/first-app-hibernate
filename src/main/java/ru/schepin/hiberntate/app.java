package ru.schepin.hiberntate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.schepin.hiberntate.dao.Dao;
import ru.schepin.hiberntate.dao.EngineDAO;
import ru.schepin.hiberntate.model.Car;
import ru.schepin.hiberntate.model.Engine;

import java.util.HashSet;
import java.util.Set;

public class app {
    public static void main(String[] args) {

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            Dao<Engine, Integer> dao = new EngineDAO(factory);

            /**
             * Раскоментируя интересующий метод помните что обращение к данным происходит по id.
             * Убедитесь что данные для методов create update и delete существуют.
             */

//            read(dao);

//            update(dao);

//            delete(dao);

            create(dao);

        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    private static void read(Dao<Engine, Integer> engineDao) {
        final Engine result = engineDao.getByKey(1);
        System.out.println("Read: " + result);
    }

    private static void update(Dao<Engine, Integer> engineDao) {
        final Engine result = engineDao.getByKey(1);
        result.setCarMark("lada");
        engineDao.update(result);
        System.out.println("Updated: " + engineDao.getByKey(1));
    }

    private static void create(Dao<Engine, Integer> carDao) {
        Engine engine = new Engine();
        engine.setCarMark("test-mark");
        engine.setPower(1000);
        engine.setName("test-name");

        Car car1 = new Car();
        car1.setMark("test-mark");
        car1.setCost(10);

        Car car2 = new Car();
        car2.setMark("test-mark");
        car2.setCost(20);

        Set<Car> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        engine.setCars(cars);

        carDao.save(engine);
    }


    private static void delete(Dao<Engine, Integer> engineDao) {
        Engine engine = engineDao.getByKey(1);
        engineDao.delete(engine);
        System.out.println(engineDao.getByKey(1));
    }
}
