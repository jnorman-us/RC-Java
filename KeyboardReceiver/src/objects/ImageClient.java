package objects;

import java.io.PrintWriter;
import java.net.Socket;

import javax.imageio.ImageIO;

import managers.ControllerManager;
import managers.NetworkManager;

public class ImageClient implements Runnable
{
	public void run()
	{
		while(NetworkManager.running)
		{
			try {
				Socket s = new Socket(NetworkManager.ip, NetworkManager.imagePort);
		        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		        out.println(ImageIO.write(ControllerManager.getImage(), "PNG", s.getOutputStream()));
		        s.close();
			} catch(Exception e) {
				
			}
		}
	}
}
