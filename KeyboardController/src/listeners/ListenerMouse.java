package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import managers.ListenerManager;

public class ListenerMouse implements MouseListener
{
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		//synthetic method do not use
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		ListenerManager.updatePosition(e.getX(), e.getY());
		ListenerManager.updateMouseButton(-1, false);
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		ListenerManager.updatePosition(e.getX(), e.getY());
		ListenerManager.updateMouseButton(-1, false);
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		ListenerManager.updatePosition(e.getX(), e.getY());
		ListenerManager.updateMouseButton(getMouseButton(e), true);
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		ListenerManager.updatePosition(e.getX(), e.getY());
		ListenerManager.updateMouseButton(getMouseButton(e), false);
	}
	
	public int getMouseButton(MouseEvent e)
	{
		switch(e.getButton())
		{
			case MouseEvent.BUTTON1:
				return 1;
			case MouseEvent.BUTTON2:
				return 2;
			case MouseEvent.BUTTON3:
				return 3;
		}
		return -1;
	}
}