package graphics;

import javax.swing.JFrame;

import main.CSVReader;

public class JPanelHandler {
	//Creates JFrame
	private static JFrame mainWindow = new JFrame();
	
	//Creates size of designer
	private int resWidth = 1280;
	private int resHeight = 720;
	
	//Grid data
	private int designWidth = 32;
	private int designHeight = 18;
	
	//Starts the panels
	DesignerPanel designer = new DesignerPanel(resWidth, resHeight);
	FileOpener fileOpener = new FileOpener();
	
	//Default value for file
	String file = null;

	private boolean fileOpened = false;
	
public JPanelHandler() {
	//Default constructor
	resWidth = 1280;
	resHeight = 720;
}
public JPanelHandler(int resWidth, int resHeight) {
	//Constructor for width and height
	this.resWidth = resWidth;
	this.resHeight = resHeight;
}


public void jFrameOpen() {
	//Starts JFrame
	mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainWindow.setResizable(false);
	mainWindow.setTitle("Texture Mapper");
	mainWindow.setVisible(true);
	
}
public void openFileOpener() {
	//Sets data for fileOpener
	mainWindow.add(fileOpener);
	mainWindow.pack();
	mainWindow.repaint();
}

public void openDesigner() {
	//Creates data for designer
	mainWindow.remove(fileOpener);
	designer.setDesignWidth(designWidth);
	designer.setDesignHeight(designHeight);
	designer.layoutCreate();
	mainWindow.add(designer);
	mainWindow.pack();
}

public void closeFileOpener() {
	//Checks if file has been changed
	while(!(fileOpened)) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Gets file name
		file = fileOpener.getFile();
		fileOpened = fileOpener.isFileOpened();
	}
	
	//Sets the grid for the design
	if (!(file.equals(""))) {
		String[][] grid = CSVReader.fileReader(file);
		designWidth = grid[0].length;
		designHeight = grid.length;
		designer.setData(grid);
	} else {
		designWidth = fileOpener.getDesignWidth();
		designHeight = fileOpener.getDesignHeight();
	}
	
}
}
