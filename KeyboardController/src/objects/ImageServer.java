package objects;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

import managers.ConstantManager;
import managers.ImageManager;

public class ImageServer implements Runnable
{
	public ServerSocket listener = null;
	
	public ImageServer()
	{
		try {
			listener = new ServerSocket(ConstantManager.imageServerPort);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void end()
	{
		try {
			listener.close();
		} catch(IOException e) {
			System.exit(0);
		}
	}
	
	public void run()
	{
		while(true)
		{
			try {
		        Socket socket = listener.accept();
		        try {
		        	ImageManager.setImage(ImageIO.read(socket.getInputStream()));
		        } catch(IndexOutOfBoundsException e)
		        {
		        	ImageManager.setImage(new BufferedImage(35, 20, BufferedImage.TYPE_INT_ARGB));
		        }
		        try {
		    		socket.close();
		        } finally {
		        	
		        }
			} catch(IOException e) {
				e.printStackTrace(); 
				System.exit(0);
			}
		}
	}
}
