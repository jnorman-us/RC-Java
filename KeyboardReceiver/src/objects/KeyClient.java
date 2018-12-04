package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import managers.NetworkManager;

public class KeyClient implements Runnable
{
	public void run()
	{
		while(NetworkManager.running)
		{
			try {
				Socket s = new Socket(NetworkManager.ip, NetworkManager.port);
		        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		        NetworkManager.decodeInput(input.readLine());
		        s.close();
			} catch(IOException e) {
				NetworkManager.decodeInput("nothing");
			}
		}
	}
}
