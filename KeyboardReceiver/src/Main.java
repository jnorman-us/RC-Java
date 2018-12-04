import managers.ConstantManager;
import managers.ControllerManager;
import managers.NetworkManager;

public class Main 
{
	public static void main(String args[])
	{
		ConstantManager.initialize();
		ControllerManager.initialize();
		NetworkManager.initialize();
	}
}