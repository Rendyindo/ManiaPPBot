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

import javax.naming.MalformedLinkException;

import org.apache.commons.io.*;

public class osuFile {
	private static BufferedReader reader;
	private static String string;
	private Object rbc;
	private static int Objects;
	
	public static String cutText(String osufile){
	    boolean matchFound = false;
	    StringBuilder output = new StringBuilder();
	    try {
	        reader = new BufferedReader(
	                new StringReader(osufile));
	    } catch (Exception failed) { failed.getStackTrace(); }


	    try {
	        while ((string = reader.readLine()) != null) {

	            if ((string.length() > 0) && (string.contains("[HitObjects]"))) {
	               matchFound = true;
	            }
	            if(matchFound){
	                 output.append(string).append("\\n");
	            }
	        }
	     } catch (IOException e) { e.getStackTrace();}
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
	
	public static void getOsuFile(final String filename, final String urlString)
	        throws MalformedLinkException, IOException {
	    BufferedInputStream in = null;
	    FileOutputStream fout = null;
	    try {
	        in = new BufferedInputStream(new URL(urlString).openStream());
	        fout = new FileOutputStream(filename);

	        final byte data[] = new byte[1024];
	        int count;
	        while ((count = in.read(data, 0, 1024)) != -1) {
	            fout.write(data, 0, count);
	        }
	    } finally {
	        if (in != null) {
	            in.close();
	        }
	        if (fout != null) {
	            fout.close();
	        }
	    }
	}
	
	public static int doAll(String osulink) throws IOException, MalformedLinkException{
		getOsuFile("temp.osu", osulink);
		cutText("temp.osu");
		return Objects = countLines("temp.osu");
	}
	
	public int getObjects(){
		return Objects;
	}
}
