package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import graphics.DesignerPanel;

public class DesignerOnClick implements MouseListener {
	// Declarations
	private JLabel[][] backGround;
	private String colour;
	private ImageIcon imageIcon;
	private ImageIcon imageIcon1;
	private DesignerPanel dP;

	public DesignerOnClick(JLabel[][] backGround, String colour, ImageIcon imageIcon, ImageIcon imageIcon1,
			DesignerPanel dP) {
		// Constructor
		this.backGround = backGround;
		this.colour = colour;
		this.imageIcon = imageIcon;
		this.imageIcon1 = imageIcon1;
		this.dP = dP;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		colour = dP.getColour(); // Check the colour that's selected
		// Width cycle
		for (int i = 0; i < backGround.length; i++) {
			// Length Cycle
			for (int j = 0; j < backGround[i].length; j++) {
				// Check if it's within width
				if (backGround[i][j].getX() <= e.getX()
						&& (backGround[i][j].getX() + backGround[i][j].getWidth()) >= e.getX()) {
					// Check if it's within height
					if (backGround[i][j].getY() <= e.getY()
							&& (backGround[i][j].getY() + backGround[i][j].getHeight()) >= e.getY()) {
						// Change icon if true
						if (colour.equals("2")) {
							backGround[i][j].setName(colour);
							backGround[i][j].setIcon(imageIcon1);
						} else {
							backGround[i][j].setName(colour);
							backGround[i][j].setIcon(imageIcon);
						}

					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
