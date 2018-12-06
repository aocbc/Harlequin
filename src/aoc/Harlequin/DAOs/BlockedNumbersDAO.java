package aoc.Harlequin.DAOs;

import java.util.ArrayList;
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
		List<BlockedNumberList> Client = new ArrayList<BlockedNumberList>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<BlockedNumberList> query = session.createQuery("from BlockedNumberList");
			Client = query.list();
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: ReadAllBlockedNumbers - BlockedNumbersDAO");
			System.out.println(ex.toString());
		}
		finally
		{
			if(session != null && session.isConnected())
			{
				session.clear(); // ADDED 170302
				session.flush();
				session.close();
			}
		}
		
		return Client;
		

	}
	
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  try
		  {
			  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        hibernateSession.flush();
		        HibernateUtil.commitTransaction();  
		  }
		  catch(Exception ex)
		  {
			  System.out.println("Error In Function: delete - BlockedNumbersDAO");
			  System.out.println(ex.toString());
		  }
		  finally
		  {
			  if(hibernateSession != null && hibernateSession.isConnected())
			  {
				  hibernateSession.close();
			  }
		  }
		  
	}
	
	public BlockedNumberList getBlockedNumberInfoById(int id)
	{
		
		
		Session session = this.getSession();
		BlockedNumberList BlockedNumber = new BlockedNumberList();
		try
		{
			HibernateUtil.beginTransaction();
			   
			
			BlockedNumber = session.get(BlockedNumberList.class, id);
		
		}
		catch(Exception ex)
		{
			 System.out.println("Error In Function: getBlockedNumberInfoById - BlockedNumbersDAO");
			 System.out.println(ex.toString());
		}
		finally
		{
			if(session != null & session.isConnected())
			{
				session.clear();
				session.flush();
				session.close();
			}
		}
	
		
		return BlockedNumber;
		
		
	}
	
	public List<BlockedNumberList> getBlockedNumberInfoByCellNumber(String CellNumber)
	{
		Session session = this.getSession();
		List<BlockedNumberList> BlockedNumbers = new ArrayList<BlockedNumberList>();
		
		try
		{
			HibernateUtil.beginTransaction();	
			Query<BlockedNumberList> query = session.createQuery("from BlockedNumberList Where CellNumber = '"+CellNumber+"'");
			BlockedNumbers = query.list();
		
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: getBlockedNumberInfoByCellNumber - BlockedNumbersDAO");
			System.out.println(ex.toString());
			
		}
		finally
		{
			if(session != null && session.isConnected())
			{
				session.clear();
				session.flush();
				session.close();
			}
		
		}
		
		return BlockedNumbers;
	}
	
	
	public void AddBlockedNumberInfo(String CellNumber, String Date_Blocked)
	{
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		
		//session.beginTransaction();
		
		Session session = this.getSession();
		
		
		try
		{
			HibernateUtil.beginTransaction();
			
			BlockedNumberList BlockedNumber = new BlockedNumberList();
			
			BlockedNumber.setCellNumber(CellNumber);
			BlockedNumber.setDateBlocked(Date_Blocked);
			
			
			session.save(BlockedNumber);
					
			session.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: AddBlockedNumberInfo - BlockedNumbersDAO");
			System.out.println(ex.toString());
			
		}
		finally
		{
			if(session != null && session.isConnected())
			{
				session.close();
			}
		}

	}
	
}
