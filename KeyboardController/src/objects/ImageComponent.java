package objects;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class ImageComponent extends JComponent
{
	private Image image;
	
	public ImageComponent()
	{
		image = null;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
	
	public void setImage(Image image)
	{
		this.image = image;
		repaint();
	}
}
