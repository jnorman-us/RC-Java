package managers;

import objects.ImageClient;
import objects.KeyClient;

public class NetworkManager
{
	public static String ip;
	public static int port;
	public static int imagePort;
	
	public static boolean running;
	
	public static Thread thread;
	public static Thread imageThread;
	
	public static KeyClient client;
	public static ImageClient imageClient;
	
	public static void initialize()
	{
		client = new KeyClient();
		thread = new Thread(client);
		running = true;
		thread.start();
		
		imageClient = new ImageClient();
		imageThread = new Thread(imageClient);
		imageThread.start();
		
		ip = ConstantManager.ip;
		port = ConstantManager.port;
		imagePort = ConstantManager.imagePort;
	}
	
	public static String last = "";
	public static void decodeInput(String input)
	{
		boolean same = false;
		if(last.equals(input))
		{
			same = true;
			last = input;
		}
		if(same)
			return;
		if(input.equals("nothing"))
		{
			last = input;
			return;
		}
		
		String[] split = input.split(";");
		ControllerManager.setMouseX(Integer.parseInt(split[0].split(": ")[1]));
		ControllerManager.setMouseY(Integer.parseInt(split[1].split(": ")[1]));
		ControllerManager.setMouseButton1(Boolean.parseBoolean(split[2].split(": ")[1]));
		ControllerManager.setMouseButton2(Boolean.parseBoolean(split[3].split(": ")[1]));
		ControllerManager.setMouseButton3(Boolean.parseBoolean(split[4].split(": ")[1]));
		
		String keys = split[5].split(": ")[1].substring(1, split[5].split(": ")[1].length() - 1);
		int[] ks = new int[5];
		int i = 0;
		for(String s : keys.split(", "))
		{
			ks[i] = Integer.parseInt(s);
			i ++;
		}
		ControllerManager.setKeys(ks);
		
		last = input;
	}
}
