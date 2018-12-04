package managers;

import java.awt.image.BufferedImage;

import objects.ImageComponent;
import objects.ImageServer;

public class ImageManager 
{
	public static ImageComponent imageComponent;
	public static ImageServer server;
	
	public static Thread thread;
	
	public static void initialize()
	{
		imageComponent = new ImageComponent();
		server = new ImageServer();
		thread = new Thread(server);
		thread.start();
	}
	
	public static void setImage(BufferedImage image)
	{
		imageComponent.setImage(image);
	}
}
