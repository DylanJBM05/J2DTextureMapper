package main;

import graphics.JPanelHandler;

public class Main {

	public static void main(String[] args) {
		//Create the screen
		JPanelHandler graphicsHandler = new JPanelHandler();
		
		//Start the screen
		graphicsHandler.jFrameOpen();
		
		//Opens the fileOpener & closes it
		graphicsHandler.openFileOpener();
		graphicsHandler.closeFileOpener();
		
		//Opens designer
		graphicsHandler.openDesigner();
	}

}
