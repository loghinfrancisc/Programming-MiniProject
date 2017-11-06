import java.io.*;
import java.net.*;
public class   Server {
	static  ServerSocket svSocket;
	static  Client cl1, cl2, cl3, cl4;
	
	public  static void main(String[] args) {
try { 
	 //Listener type socket, which can accept incoming connections and assign them to other sockets, allowing multiple connections
	svSocket=new ServerSocket(7007);

} catch  (Exception e) {
	e.printStackTrace();
}
	//Allows for 4 connections
try {
	cl1=new Client(svSocket.accept());
	cl1.start();
	cl2=new Client(svSocket.accept());
	cl2.start();
	cl3=new Client(svSocket.accept());
	cl3.start();
	cl4=new Client(svSocket.accept());
	cl4.start();
	
}
catch(Exception e) {
	e.printStackTrace();
}
}

}
