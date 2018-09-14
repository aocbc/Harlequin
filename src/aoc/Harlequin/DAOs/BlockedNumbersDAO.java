package aoc.Harlequin.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.BlockedNumberList;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemJob;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

public class BlockedNumbersDAO extends HarlequinDAO {

	
	
	
	public List<BlockedNumberList> ReadAllBlockedNumbers()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from BlockedNumberList");
		List<BlockedNumberList> Client = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Client;
		
		
		
	}
	
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        hibernateSession.flush();
		  HibernateUtil.commitTransaction();
	}
	
	public BlockedNumberList getBlockedNumberInfoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		BlockedNumberList BlockedNumber = session.get(BlockedNumberList.class, id);
		
		
		session.close();
	   
		
		return BlockedNumber;
		
		
	}
	
	public List<BlockedNumberList> getBlockedNumberInfoByCellNumber(String CellNumber)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from BlockedNumberList Where CellNumber = '"+CellNumber+"'");
		List<BlockedNumberList> BlockedNumbers = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return BlockedNumbers;
	}
	
	
	public void AddBlockedNumberInfo(String CellNumber, String Date_Blocked)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		BlockedNumberList BlockedNumber = new BlockedNumberList();
		
		BlockedNumber.setCellNumber(CellNumber);
		BlockedNumber.setDateBlocked(Date_Blocked);
		
		
		session.save(BlockedNumber);
				
		session.getTransaction().commit();
		
		
		
		session.close();

		
	}
	
}
