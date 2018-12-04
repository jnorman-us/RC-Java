package managers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkManager 
{
	public static ServerSocket listener = null;
	
	public static void initialize()
	{
		try {
			listener = new ServerSocket(ConstantManager.serverPort);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void end()
	{
		try {
			listener.close();
		} catch(IOException e) {
			System.exit(0);
		}
	}
	
	public static void send()
	{
		try {
	        Socket socket = NetworkManager.listener.accept();
	        try {
	            PrintWriter out =
	                new PrintWriter(socket.getOutputStream(), true);
	            out.println(ListenerManager.serverOutput());
	        } finally {
	    		socket.close();
	        }
		} catch(IOException e) {
			e.printStackTrace(); 
			System.exit(0);
		}
	}
}