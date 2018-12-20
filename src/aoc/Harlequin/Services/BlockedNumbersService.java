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
	    BlockedNumbersDAO Object  = new BlockedNumbersDAO();
		
		List<BlockedNumberList> BlockedNumbers = Object.ReadAllBlockedNumbers();
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < BlockedNumbers.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idBlockedNumberList", BlockedNumbers.get(i).getIdBlockedNumberList());
			jsonObject.put("cellNumber", BlockedNumbers.get(i).getCellNumber());
			jsonObject.put("dateBlocked", BlockedNumbers.get(i).getDateBlocked());
			JsonArray.put(jsonObject);
		}
		
		return JsonArray.toString();
	}
	
	
	@Path("/DeleteNumber/{Id}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("Id") int Id) throws Exception
	{
		
		BlockedNumbersDAO Object  = new BlockedNumbersDAO();
		Object.delete(Object.getBlockedNumberInfoById(Id));
		return "Successful";
	}
	
	@Path("/DeleteCellNumber/{Cell_Number}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("Cell_Number") String Cell_Number) throws Exception
	{
		
		BlockedNumbersDAO Object  = new BlockedNumbersDAO();
		List<BlockedNumberList> BlockedNumbers = Object.getBlockedNumberInfoByCellNumber(Cell_Number);
		
		if(BlockedNumbers.size()> 0)
		{
			for(int i = 0; i < BlockedNumbers.size();i++)
			{
				Object.delete(BlockedNumbers.get(i)); 
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
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);		
		BlockedNumbersDAO Object  = new BlockedNumbersDAO();
		Object.AddBlockedNumberInfo(r.getString("CellNumber"), r.getString("Date_Blocked"));
		
		return "Sucessful";	
		
	}
	

}

