package com.supinfo.cb.driver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	static ServerSocket serverSocket;
    static Socket socket;
    
    static PrintWriter printWriter;
	
	public static void init (int port) {
		try {
			
			serverSocket = new ServerSocket(port);
			
			System.out.println("Waiting for a client connection ... [" + port + "]");
			
			socket = serverSocket.accept();
			
			printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * @ Language [req] :
	 * - RIGHT  :  stick to the right ( > 500 )
	 * - LEFT  :  stick to the left ( < -500 )
	 * - STOP  :  stick return in the middle
	 * - JUMP  :  shoulder left & right pressed
	 * - TORNADO  :  trigger left & right pressed ( > 200 )
	 * - B  :  key B pressed
	 */
	
	public static void send (String req) {
		if(!socket.isClosed()) {
			printWriter.println(req);
		} else {
			disconnect();
		}
	}
	
	public static void disconnect () {
		try {
			printWriter.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("GamePad CB Driver stopping ...");

		System.exit(0);
	}

}
