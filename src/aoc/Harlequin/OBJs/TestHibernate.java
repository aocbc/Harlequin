package aoc.Harlequin.OBJs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;







/**
 * 
 */

/**
 * @author Jateen
 *
 */
public class TestHibernate {
	
	public static void main(String[] args)
	{
	
		Configuration cfg = new Configuration();
	    cfg.configure("/aoc/Harlequin/Services/hibernate.cfg.xml");

	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
	    SystemUser users = new SystemUser();
	    users.setName("Jateen");
	    users.setSurname("Singh01");
	    users.setUserName("Test");
	   
	    
	    Transaction tx = session.beginTransaction();
	    session.save(users);
	    System.out.println("Object saved successfully.....!!");
	    tx.commit();
	    session.close();
	    factory.close();

	}
	
}
