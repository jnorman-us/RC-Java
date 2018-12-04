package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import managers.ListenerManager;

public class ListenerKey implements KeyListener
{
	@Override
	public void keyPressed(KeyEvent e) 
	{
		ListenerManager.updateKeys(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		ListenerManager.updateKeys(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		//Synthetic Method, DO NOT USE
	}

}