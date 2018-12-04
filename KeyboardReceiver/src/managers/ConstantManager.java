package managers;

import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConstantManager 
{
	public static String ip = "";
	public static final int port = 5508;
	public static final int imagePort = 5509;
	
	public static final int server_sizeX = 1280;
	public static final int server_sizeY = 720;
	
	public static final int sizeX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int sizeY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static void initialize()
	{
		URL url = null;
		try {
			url = new URL("http://blog.team624.org/?p=membershub&do=ip");
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.exit(0);
		}
		URLConnection conn = null;
		try {
			conn = url.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(0);
		}
		InputStream is = null;
		try {
			is = conn.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		int i;
		try {
			while((i = is.read())!=-1) 
			{
				ip += (char)i;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
}
