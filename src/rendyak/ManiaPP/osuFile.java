package rendyak.ManiaPP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class osuFile {
	private static BufferedReader reader;
	private String string;
	private static int Objects;
	
	public String cutText(String osufile){
	    boolean matchFound = false;
	    StringBuilder output = new StringBuilder();
	    try {
	        reader = new BufferedReader(
	                new StringReader(osufile));
	    } catch (Exception failed) { failed.printStacktrace(); }


	    try {
	        while ((string = reader.readLine()) != null) {

	            if ((string.length() > 0) && (string.contains("[HitObjects]"))) {
	               matchFound = true;
	            }
	            if(matchFound){
	                 output.append(string).append("\\n");
	            }
	        }
	     } catch (IOException e) { e.printStacktrace();}
	     return output.toString();
	}
	
	public static int countLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
	
	public static void getOsuFile(String osulink){
		URL website = new URL(osulink);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream("temp.osu");
		fos.getChannel(){transferFrom(rbc, 0, Long.MAX_VALUE);
	}
	
	public static void osuFile(String osulink){
		getOsuFile(osulink);
		String cutText = cutText("temp.osu");
		Objects = countLines("temp.osu");
	}
	
	public int getObjects(){
		return Objects;
	}
}
