package rendyak.ManiaPP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiReq {
	public static String getData(String diffID) throws Exception {
		String url = "http://osu.ppy.sh/api/get_beatmaps?k=0c38a7a0c8b06f3c89bc2e1fd0690f3f39a2c1d8&b="+diffID;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");	
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}

}
