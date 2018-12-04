package managers;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class ControllerManager
{
	public static Robot robot;
	
	public static int mouseX;
	public static int mouseY;

	public static boolean mouseButton1;
	public static boolean mouseButton2;
	public static boolean mouseButton3;
	
	public static int[] keys;
	
	public static void initialize()
	{
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
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
	
	public static void setMouseX(int x)
	{
		if(mouseX != x)
		{
			mouseX = x;
			robot.mouseMove((int)(mouseX * ConstantManager.sizeX / ConstantManager.server_sizeX), 
					(int)(mouseY * ConstantManager.sizeY / ConstantManager.server_sizeY));
		}
	}
	
	public static void setMouseY(int y)
	{
		if(mouseY != y)
		{
			mouseY = y;
			robot.mouseMove((int)(mouseX * ConstantManager.sizeX / ConstantManager.server_sizeX), 
					(int)(mouseY * ConstantManager.sizeY / ConstantManager.server_sizeY));
		}
	}
	
	public static void setMouseButton1(boolean c)
	{
		if(mouseButton1 != c)
		{
			mouseButton1 = c;
			if(mouseButton1)
				robot.mousePress(InputEvent.BUTTON1_MASK);
			else
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}
	}

	public static void setMouseButton2(boolean c)
	{
		if(mouseButton2 != c)
		{
			mouseButton2 = c;
			if(mouseButton2)
				robot.mousePress(InputEvent.BUTTON2_MASK);
			else
				robot.mouseRelease(InputEvent.BUTTON2_MASK);
		}
	}
	
	public static void setMouseButton3(boolean c)
	{
		if(mouseButton3 != c)
		{
			mouseButton3 = c;
			if(mouseButton3)
				robot.mousePress(InputEvent.BUTTON3_MASK);
			else
				robot.mouseRelease(InputEvent.BUTTON3_MASK);
		}
	}
	
	public static void setKeys(int[] ks)
	{
		if(keys != ks)
		{
			for(int i = 0; i < keys.length; i ++)
			{
				if(ks[i] != keys[i])
				{
					if(ks[i] == -1)
					{
						robot.keyRelease(keys[i]);
						keys[i] = ks[i];
						continue;
					}
					else
					{
						robot.keyPress(ks[i]);
						keys[i] = ks[i];
						continue;
					}
				}
			}
		}
	}
	
	public static BufferedImage getImage()
	{
		BufferedImage before = robot.createScreenCapture((new Rectangle(ConstantManager.sizeX, ConstantManager.sizeY)));
		BufferedImage after = new BufferedImage(ConstantManager.server_sizeX, 
				ConstantManager.server_sizeY, before.getType());
		Graphics2D graphics2D = after.createGraphics();
		graphics2D.drawImage(before, 0, 0, ConstantManager.server_sizeX, ConstantManager.server_sizeY, null);
		graphics2D.dispose();
		return after;
	}
}
