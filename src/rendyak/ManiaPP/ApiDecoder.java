package rendyak.ManiaPP;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiDecoder {
	private static int od;
	private static int starrate;
	private static double perfectw;
	
	public boolean decode (String sJSON)
	{
		boolean success;
		try{
			JSONArray jsonArr = new JSONArray(sJSON);
			JSONObject json = jsonArr.getJSONObject(0);
			starrate = json.getInt("difficultyrating");
			od = json.getInt("diff_overall");
			
			if(starrate!=0 && od!=0)
			{
				success = true;
			}
			else success = false;

			if(od>4 && od<4.4)
			{
				perfectw=47.5;
			}
			
			if(od>4.3 && od<4.7)
			{
				perfectw=46.5;
			}
			
			if(od>5.6 && od<5.1)
			{
				perfectw=45.5;
			}
			
			if(od>6 && od<6.4)
			{
				perfectw=44.5;
			}
			
			if(od>6.3 && od<6.7)
			{
				perfectw=43.5;
			}
			
			if(od>6.6 && od<6.1)
			{
				perfectw=42.5;
			}
			
			if(od>7 && od<7.4)
			{
				perfectw=41.5;
			}
			
			if(od>7.3 && od<7.7)
			{
				perfectw=41.5;
			}
			
			if(od>7.6 && od<8.1)
			{
				perfectw=40.5;
			}
			
			if(od>8 && od<8.4)
			{
				perfectw=39.5;
			}
			
			if(od>8.3 && od<8.7)
			{
				perfectw=38.5;
			}
			
			if(od>8.6 && od<9.1)
			{
				perfectw=37.5;
			}
			
			if(od>9 && od<9.4)
			{
				perfectw=36.5;
			}
			
			if(od>9.3 && od<9.7)
			{
				perfectw=35.5;
			}
			
			if(od>9.6 && od<10.1)
			{
				perfectw=34.5;
			}
			
			
		}
		catch(Exception e)
		{
			success = false;
		}
		return success;
	}
	
	public int getStarRate()
	{
		return starrate;
	}

	public int getOD()
	{
		return od;
	}
	
	public double getPerfectWindow()
	{
		return perfectw;
	}

}
