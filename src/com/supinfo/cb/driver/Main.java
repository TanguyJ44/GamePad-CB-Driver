package com.supinfo.cb.driver;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("GamePad CB Driver starting ...");
		
		Server.init(Integer.parseInt(args[0]));
		
		GamePad.init();
		
	}

}
