import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionHandler extends Thread{//this class will be used to handle all connections, it will contain a send function called
	//by the main class whenever the packet needs to be sent to the server, and it will check for incoming packets on its own thread
	static int port=6789;
	static Socket socket;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	static Packet incoming;
	static Packet output;
	public void send() {
		try {
			oos.writeObject(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			socket=new Socket("localhost", port);
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	while(true) {
	try {
		incoming=(Packet) ois.readObject();
	} catch (Exception e) {
		e.printStackTrace();
	}
	//need to code a response for what needs to be done when a certain command has been made by the server
	}
}
	
}
