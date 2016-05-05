package cn.fudan.edu.myssh2.dao;

import cn.fudan.edu.myssh2.bean.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Sissors-CX on 2016-04-06.
 */
public class UserDao {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void add(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();


    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return sessionFactory;
    }
}
