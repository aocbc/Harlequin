package aoc.Harlequin.Services;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import aoc.Harlequin.DAOs.BlockedNumbersDAO;
import aoc.Harlequin.OBJs.BlockedNumberList;

@Path("BlockedCellNumbers")
public class BlockedNumbersService 
{
	
	@Path("/ReadAllBlockedNumbers")
	@GET
	@Produces("text/plain")
	public String GetAllBlockedNumbers() throws Exception
	{
	    BlockedNumbersDAO blockedNumbersDAO  = new BlockedNumbersDAO();
		
		List<BlockedNumberList> blockedNumbers = blockedNumbersDAO.ReadAllBlockedNumbers();
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < blockedNumbers.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idBlockedNumberList", blockedNumbers.get(i).getIdBlockedNumberList());
			jsonObject.put("cellNumber", blockedNumbers.get(i).getCellNumber());
			jsonObject.put("dateBlocked", blockedNumbers.get(i).getDateBlocked());
			jsonArray.put(jsonObject);
		}
		
		return jsonArray.toString();
	}
	
	
	@Path("/DeleteNumber/{Id}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("Id") int Id) throws Exception
	{
		
		BlockedNumbersDAO blockedNumbersDAO  = new BlockedNumbersDAO();
		blockedNumbersDAO.delete(blockedNumbersDAO.getBlockedNumberInfoById(Id));
		return "Successful";
	}
	
	@Path("/DeleteCellNumber/{Cell_Number}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("Cell_Number") String Cell_Number) throws Exception
	{
		
		BlockedNumbersDAO blockedNumbersDAO  = new BlockedNumbersDAO();
		List<BlockedNumberList> blockedNumbers = blockedNumbersDAO.getBlockedNumberInfoByCellNumber(Cell_Number);
		
		if(blockedNumbers.size()> 0)
		{
			for(int i = 0; i < blockedNumbers.size();i++)
			{
				blockedNumbersDAO.delete(blockedNumbers.get(i)); 
			}	
		}
		
		return "Successful";
	}
	
	@Path("/AddBlockedNumber")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		
		JSONObject jsonObject = new JSONObject(jsonTextObject);		
		BlockedNumbersDAO blockedNumbersDAO  = new BlockedNumbersDAO();
		blockedNumbersDAO.AddBlockedNumberInfo(jsonObject.getString("CellNumber"), jsonObject.getString("Date_Blocked"));
		
		return "Sucessful";	
		
	}
	

}

