package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import managers.ListenerManager;

public class ListenerMousePosition implements MouseMotionListener
{
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		ListenerManager.updatePosition(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		ListenerManager.updatePosition(e.getX(), e.getY());
	}
}