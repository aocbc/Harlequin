package aoc.Harlequin.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	
	private static final SessionFactory sessionFactory;

	static 
	{
		try 
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) 
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession() 
	{
		Session hibernateSession = sessionFactory.getCurrentSession();
		
		return hibernateSession;
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
	public static Session beginTransaction() 
	{
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		
				//hibernateSession.setCacheMode(CacheMode.REFRESH);
		//hibernateSession.setFlushMode(FlushMode.ALWAYS);
		//System.out.println(hibernateSession.getCacheMode().toString());
		//System.out.println(hibernateSession.getFlushMode().toString());
		
		//hibernateSession.clear();
		return hibernateSession;
	}

}
