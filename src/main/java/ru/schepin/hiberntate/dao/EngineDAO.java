package ru.schepin.hiberntate.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.schepin.hiberntate.model.Engine;

/**
 * @author Pavel Ravvich.
 */
public class EngineDAO implements Dao<Engine, Integer> {
    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    public EngineDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(Engine engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(engine);

            session.getTransaction().commit();
        }
    }

    @Override
    public Engine getByKey(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            return session.get(Engine.class, id);
        }
    }

    @Override
    public void update(Engine engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(engine);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Engine engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(engine);

            session.getTransaction().commit();
        }
    }
}
