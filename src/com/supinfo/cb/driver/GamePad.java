package com.supinfo.cb.driver;

import com.exlumina.j360.ButtonListener;
import com.exlumina.j360.Controller;
import com.exlumina.j360.ValueListener;

public class GamePad {
	
	static Controller controller;
	
	public static void init () {
		
		controller = Controller.C1;
		
		listeners();
		
	}
	
	public static void listeners () {
		
		controller.rightThumbX.addValueChangedListener(new ValueListener() {
			@Override
			public void value(int arg0) {
				
				if(arg0 > 500) {
					Server.send("RIGHT");
					System.out.println("[+] thumbx right switch");
				}
				else if(arg0 < -500) {
					Server.send("LEFT");
					System.out.println("[+] thumbx left switch");
				}
				else if(arg0 > -100 && arg0 < 100) {
					Server.send("STOP");
					System.out.println("[+] thumbx return middle");
				}
			}
		});
        
        controller.triggerRight.addValueChangedListener(new ValueListener() {
			@Override
			public void value(int arg0) {
				if(arg0 > 200) {
					Server.send("TORNADO");
					System.out.println("[+] trigger right pressed");
				}
			}
		});
        
        controller.triggerLeft.addValueChangedListener(new ValueListener() {
			@Override
			public void value(int arg0) {
				if(arg0 > 200) {
					Server.send("TORNADO");
					System.out.println("[+] trigger left pressed");
				}
			}
		});
        
        controller.buttonRightShoulder.addButtonPressedListener(new ButtonListener() {
			@Override
			public void button(boolean arg0) {
				Server.send("JUMP");
				System.out.println("[+] shoulder right pressed");
			}
		});
        
        controller.buttonLeftShoulder.addButtonPressedListener(new ButtonListener() {
			@Override
			public void button(boolean arg0) {
				Server.send("JUMP");
				System.out.println("[+] shoulder left pressed");
			}
		});
        
        controller.buttonB.addButtonPressedListener(new ButtonListener() {
			@Override
			public void button(boolean arg0) {
				Server.send("B");
				System.out.println("[+] key B pressed");
			}
		});
		
	}
	
	

}
