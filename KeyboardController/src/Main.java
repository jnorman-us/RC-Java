import javax.swing.JFrame;

import managers.ConstantManager;
import managers.ImageManager;
import managers.ListenerManager;
import managers.NetworkManager;

public class Main 
{
	
	public static void main(String args[])
	{
		ListenerManager.initialize();
		NetworkManager.initialize();
		ImageManager.initialize();
		
		JFrame frame = new JFrame();
		frame.add(ImageManager.imageComponent);
		frame.addKeyListener(ListenerManager.keyListener);
		frame.getContentPane().addMouseListener(ListenerManager.mouseListener);
		frame.getContentPane().addMouseMotionListener(ListenerManager.mouseMovementListener);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		frame.setSize(ConstantManager.sizeX + 40, ConstantManager.sizeY + 40);
		frame.setTitle(ConstantManager.frameName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
