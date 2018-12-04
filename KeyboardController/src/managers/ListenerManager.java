package managers;

import java.util.Arrays;

import listeners.ListenerKey;
import listeners.ListenerMouse;
import listeners.ListenerMousePosition;

public class ListenerManager 
{
	public static ListenerKey keyListener = new ListenerKey();
	public static ListenerMousePosition mouseMovementListener = new ListenerMousePosition();
	public static ListenerMouse mouseListener = new ListenerMouse();
	
	public static int mouseX;
	public static int mouseY;
	
	public static boolean mouseButton1;
	public static boolean mouseButton2;
	public static boolean mouseButton3;
	
	public static int[] keys;
	
	public static void initialize()
	{
		mouseX = 0;
		mouseY = 0;
		
		mouseButton1 = false;
		mouseButton2 = false;
		mouseButton3 = false;
		
		keys = new int[5];
		for(int i = 0; i < keys.length; i ++)
		{
			keys[i] = -1;
		}
	}
	
	public static void updatePosition(int x, int y)
	{
		mouseX = x > ConstantManager.sizeX ? ConstantManager.sizeX : x;
		mouseY = y > ConstantManager.sizeY ? ConstantManager.sizeY : y;;
		NetworkManager.send();
	}
	
	public static void updateKeys(int keyCode, boolean down)
	{
		if(down)
		{
			for(int i = 0; i < keys.length; i ++)
			{
				if(keys[i] == keyCode)
					return;
			}
			for(int i = 0; i < keys.length; i ++)
			{
				if(keys[i] == -1)
				{
					keys[i] = keyCode;
					NetworkManager.send();
					return;
				}
			}
		}
		else
		{
			for(int i = 0; i < keys.length; i ++)
			{
				if(keys[i] == keyCode)
				{
					keys[i] = -1;
					NetworkManager.send();
					return;
				}
			}
		}
	}
	
	public static void updateMouseButton(int button, boolean down)
	{
		switch(button)
		{
			case 1:
				mouseButton1 = down;
				break;
			case 2:
				mouseButton2 = down;
				break;
			case 3:
				mouseButton3 = down;
				break;
			case -1:
				mouseButton1 = false;
				mouseButton2 = false;
				mouseButton3 = false;
				break;
		}
		NetworkManager.send();
	}
	
	public static String serverOutput()
	{
		String out = "" + 
				"MouseX: " + ListenerManager.mouseX + 
				";MouseY: " + ListenerManager.mouseY + 
				";Mouse Button 1: " + ListenerManager.mouseButton1 +
				";Mouse Button 2: " + ListenerManager.mouseButton2 +
				";Mouse Button 3: " + ListenerManager.mouseButton3 +
				";Keys Down: " + Arrays.toString(ListenerManager.keys);
		return out;
	}
}
