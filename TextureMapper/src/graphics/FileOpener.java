package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FileOpener extends JPanel implements ActionListener {
	//Default value for file
	private String file = null;
	
	//Sets grid
	private int designWidth = 32;
	private int designHeight = 18;
	
	//Buttons
	private JButton openFile;
	private JButton submit;
	
	//Text fields
	private JTextField designWidthText;
	private JTextField designHeightText;
	private JTextField designFileName;
	
	private boolean fileOpened = false;

	
	public FileOpener() { // Creates file opener design
		this.setPreferredSize(new Dimension(640, 480));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.setLayout(new FlowLayout());
		
		
		openFile = new JButton("Select File");
		openFile.addActionListener(this);
		
		submit = new JButton("Submit New File");
		submit.addActionListener(this);
		
		designWidthText = new JTextField(3);
		designHeightText = new JTextField(3);
		designFileName = new JTextField(15);
		
		//Packs
		this.add(openFile);
		this.add(designWidthText);
		this.add(designHeightText);
		this.add(designFileName);
		this.add(submit);
	}
	
	
public void actionPerformed(ActionEvent e) { //Button checking
		
		if(e.getSource()==openFile) {//Open file button
			//Chooses files
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File("."));
			
			int response = fileChooser.showOpenDialog(null);
			//Checks if file is desirable
			if(response == JFileChooser.APPROVE_OPTION) {
				String file = new String(fileChooser.getSelectedFile().getAbsolutePath());
				this.file = file;
				System.out.print(this.file);
				fileOpened = true;
			}
			
		}
		if(e.getSource()==submit) {//Submit button
			//Saves file & grid data
			file = designFileName.getText();
			try { 
				if ((Integer.parseInt(designWidthText.getText()) * Integer.parseInt(designHeightText.getText())) > 4096) {
					throw new Exception();
				}
					setDesignWidth(Integer.parseInt(designWidthText.getText()));
					setDesignHeight(Integer.parseInt(designHeightText.getText()));
					fileOpened = true;
			} catch (Exception err) {
				designWidthText.setText("32");
				designHeightText.setText("18");
			}
			
		}
	}


public String getFile() {
	return file;
}


public void setFile(String file) {
	this.file = file;
}


public int getDesignWidth() {
	return designWidth;
}


public void setDesignWidth(int designWidth) {
	this.designWidth = designWidth;
}


public int getDesignHeight() {
	return designHeight;
}


public void setDesignHeight(int designHeight) {
	this.designHeight = designHeight;
}


public boolean isFileOpened() {
	return fileOpened;
}


public void setFileOpened(boolean fileOpened) {
	this.fileOpened = fileOpened;
}

}
