package aoc.Harlequin.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import aoc.Harlequin.OBJs.AssignedJobApplicantList;
import aoc.Harlequin.OBJs.BlockedNumberList;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemJob;
import aoc.Harlequin.OBJs.overideuser;
import aoc.Harlequin.util.HibernateUtil;

public class OverideUserDAO extends HarlequinDAO 
{
	
	public List<overideuser> ReadOveridePassword()
	{
		Session session = this.getSession();
		List<overideuser> overideusers = new ArrayList<overideuser>();
		
		//System.out.println("TEsting Function Read by id assigned jobs");
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<overideuser> query = session.createQuery("from overideuser where idoverideUser = 1;");
			overideusers = query.list();
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: ReadOveridePassword - OverideUserDAO");
			System.out.println(ex.toString());
		}
		finally
		{
			if(session != null && session.isConnected() && session.isOpen())
			{
				session.clear(); // ADDED 170302
				session.flush();
				session.close();
			}
		}
		
		
			return overideusers;
	}
	
	
	
	

}
