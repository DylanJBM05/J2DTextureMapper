package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;

import graphics.DesignerPanel;

public class DesignerAction implements ActionListener{
	JLabel[][] backGround;
	JButton[] buttons;
	String colour = "1";
	DesignerPanel dP;
	public DesignerAction(JLabel[][] backGround, JButton[] buttons, DesignerPanel dP) {
		this.backGround = backGround;
		this.buttons = buttons;
		this.dP = dP;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttons[0]) {//Open file button
			try (PrintWriter dataStream = new PrintWriter("Book1.csv"))
			{
				//Print data
				for (int i = 0; i < backGround.length; i++) {
					for (int j = 0; j < backGround[i].length; j++) {
						if ((backGround[i].length - 1) == j) {
							dataStream.print(backGround[i][j].getName());
						} else {
							dataStream.print(backGround[i][j].getName() + ",");
						}
		
					}
					dataStream.println();
					}
			    dataStream.close();
			}
			catch (Exception err){
			    System.out.println(" No such file exists.");
			    err.printStackTrace();
			}
			
		}
		//Colour changers
		if(e.getSource()==buttons[1]) {
			colour = "1";
		}
		if(e.getSource()==buttons[2]) {
			colour = "2";
		}
		dP.setColour(colour);
	}
}
